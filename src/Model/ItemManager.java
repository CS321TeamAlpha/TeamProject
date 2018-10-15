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
    private List<ItemBase> items;
    
    private ItemManager(){
        items = (ArrayList<ItemBase>)XMLDataLoader.get().loadData("MasterItemList.xml");
        if (items != null){
            items.sort(null);
        } else {
            items = new ArrayList();
        }
    }
    
    public static ItemManager get(){
        if(instance==null){
            instance = new ItemManager();
        }
        return instance;
    }
    
    public List<ItemBase> getItems(){
        return items;
    }
}
