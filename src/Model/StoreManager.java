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
    
    private StoreManager(){
        stores = (ArrayList<Store>)XMLDataLoader.get().loadData("MasterStoreList.xml");
        if (stores != null){
            stores.sort(null);
        } else {
            stores = new ArrayList();
        }
    }
    
    public static StoreManager get(){
        if(instance == null){
            instance = new StoreManager();
        }
        return instance;
    }
    
    public List<Store> getItems(){
        return stores;
    }
    
    public void add(Store store){
        stores.add(store);
    }
}
