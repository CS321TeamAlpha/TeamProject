/*******************************************************************
*   Menu.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a menu of purchasable items
 * 
 */
public class Menu {
    private String name;
    private final List<MenuItem> items;
    
    public Menu(){
        items = new ArrayList();
    }
    
    public List<MenuItem> getItems(){
        return items;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void add(MenuItem item){
        items.add(item);
    }
        
    @Override
    public String toString(){
        return name;
    }
}
