/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.dovile.warehouseinfosystem.readfile;

import lt.dovile.warehouseinfosystem.data.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dovile Barkauskaite <barkauskaite.dovile@gmail.com>
 */
public class DataReader {

    private final static Logger logger = Logger.getLogger(DataReader.class.getName());

    private static final String CSV_FILE = "sample.csv";

    /**
     *
     * @return Items list from file. Items list is sort and without duplicate.
     */
    public List<Item> readStockFile() {
        List<Item> items = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(CSV_FILE));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] stock = line.split(cvsSplitBy);
                Item item;
                try {
                    item = createItem(stock);
                } catch (NumberFormatException e) {
                    //If first line is not the object
                    continue;
                }
                items.add(item);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.WARNING, "File is not exist", e.getMessage());
        } catch (IOException e) {
            logger.log(Level.WARNING, "Something wrong with file data", e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    logger.log(Level.WARNING, "Something wrong with close reader", e.getMessage());
                }
            }
        }
        return removeDuplicate(items);
    }

    /**
     *
     * @param item
     * @return Item object by constructor
     */
    private Item createItem(String[] item) {
        String name = item[0];
        long code = new Long(item[1]);
        int quantity = Integer.parseInt(item[2]);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date expirationDate;
        try {
            expirationDate = sdf.parse(item[3]);
        } catch (ParseException ex) {
            logger.log(Level.WARNING, "Can not read date from file", ex.getMessage());
            expirationDate = null;
        }
        return new Item(name, code, quantity, expirationDate);
    }

    /**
     *
     * @param items sort by Items name
     */
    private void SortList(List<Item> items) {
        Collections.sort(items, (Item i1, Item i2) -> i1.name.compareTo(i2.name));
    }

    /**
     *
     * @param items
     * @return new List without duplicate. Duplicate remove when items have the
     * same name, code and expiration date
     */
    private List<Item> removeDuplicate(List<Item> items) {
        List<Item> dupItem = new ArrayList<>();
        SortList(items);
        for (int i = 0; i < items.size(); i++) {
            int sum = 0;
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(i).getName().equals(items.get(j).getName()) && items.get(i).getCode() == items.get(j).getCode()
                        && items.get(i).getExpirationDate().equals(items.get(j).getExpirationDate())) {
                    sum = sum + items.get(j).getQuantity();
                    items.get(j).setQuantity(0);
                }
            }
            if (sum != 0) {
                sum = sum + items.get(i).getQuantity();
                items.get(i).setQuantity(sum);
            }
            if (items.get(i).getQuantity() != 0) {
                dupItem.add(items.get(i));
            }
        }
        return dupItem;
    }
}
