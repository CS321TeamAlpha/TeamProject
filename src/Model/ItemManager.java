/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import filemanager.FileManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bs0084
 */
public class ItemManager {
    private static ItemManager instance;
    private List<ItemBase> items;
    
    private ItemManager(){
        items = (ArrayList<ItemBase>)FileManager.loadObjectFromXML("MasterItemList.xml");
        if (items != null){
            items.sort(null);
        } else {
            items = new ArrayList();
        }
    }
    
    public static ItemManager Instance(){
        if(instance==null){
            instance = new ItemManager();
        }
        return instance;
    }
    
    public List<ItemBase> getItems(){
        return items;
    }
}
