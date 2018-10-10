/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import filemanager.XMLDataLoader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bs0084
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
