/*******************************************************************
*   ItemManager.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package Model;

import DataLoader.XMLDataLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class to manage the master list of items
 * 
 */
public class ItemManager {
    private static ItemManager instance;
    private List<Item> items;
    private List<ItemOption> options;
    
    /**
     * private Constructor for Singleton construction
     * @param itemFilename If provided, will attempt to load item data from the
     * supplied file.
     * @param optionFilename If provided, will attempt to load option data from
     * the supplied file.
     */
    private ItemManager(String itemFilename, String optionFilename){
        if (itemFilename != null){
            items = (ArrayList<Item>)XMLDataLoader.get().loadData(itemFilename);
        } else {
            items = null;
        }
        
        if (items != null){
            //items.sort(null);
        } else {
            items = new ArrayList();
        }
        
        if (optionFilename != null){
            options = (ArrayList<ItemOption>)XMLDataLoader.get().loadData(optionFilename);
        } else {
            options = null;
        }
        
        if (options != null){
            //options.sort(null);
        } else {
            options = new ArrayList();
        }
    }
    
    /**
     * Static get function for Singleton access. For the first time call, the
     * supplied filename will be used to attempt a data load. Subsequent calls
     * ignore the argument.
     * @param itemFilename The file to load item data from. May be null
     * @param optionFilename The file to load option data from. May be null
     * @return sole instance of ItemManager
     */
    public static ItemManager get(String itemFilename, String optionFilename){
        if(instance==null){
            instance = new ItemManager(itemFilename, optionFilename);
        }
        return instance;
    }
    
    /**
     * Static get function for Singleton access. For the first time call using
     * this overloaded method will generate empty lists.
     * @return sole instance of ItemManager
     */
    public static ItemManager get(){
        if(instance==null){
            instance = new ItemManager(null, null);
        }
        return instance;
    }
    /**
     * Retrieves the list of Items
     * @return list of Items
     */
    public List<Item> getItems(){
        return items;
    }
    
    /**
     * Adds an item to the list
     * @param item The Item to be added
     */
    public void add(Item item){
        items.add(item);
    }
    
    /**
     * Retrieves the list of Options
     * @return list of Options
     */
    public List<ItemOption> getOptions(){
        return options;
    }
    
    /**
     * Adds an option to the list
     * @param option The Option to be added
     */
    public void add(ItemOption option){
        options.add(option);
    }
}
