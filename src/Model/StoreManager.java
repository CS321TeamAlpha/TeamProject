/*******************************************************************
*   StoreManager.java
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
 * Singleton class which manages the master list of Stores
 * 
 */
public class StoreManager {
    private static StoreManager instance;
    private List<Store> stores;
    
    /**
     * private Constructor for Singleton construction
     * @param filename If provided, will attempt to load store data from the
     * supplied file.
     */
    private StoreManager(String filename){
        if (filename != null){
            stores = (ArrayList<Store>)XMLDataLoader.get().loadData(filename);
        } else {
            stores = null;
        }
        
        if (stores != null){
            //stores.sort(null);
        } else {
            stores = new ArrayList();
        }
    }
    
    /**
     * Static get function for Singleton access. For the first time call, the
     * supplied filename will be used to attempt a data load. Subsequent calls
     * ignore the argument.
     * @param filename The file to load data from. May be null
     * @return sole instance of StoreManager
     */
    public static StoreManager get(String filename){
        if(instance == null){
            instance = new StoreManager(filename);
        }
        return instance;
    }
    
    /**
     * Static get function for Singleton access. For the first time call using 
     * this overloaded method, an empty list will be generated.
     * @return sole instance of StoreManager
     */
    public static StoreManager get(){
        if(instance == null){
            instance = new StoreManager(null);
        }
        return instance;
    }
    
    /**
     * Retrieves the list of Stores
     * @return list of Stores
     */
    public List<Store> getItems(){
        return stores;
    }
    
    /**
     * Adds a store to the list
     * @param store The Store to be added
     */
    public void add(Store store){
        stores.add(store);
    }
}
