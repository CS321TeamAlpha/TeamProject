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
    private List<MenuItem> items;
    
    /**
     * Default Constructor: Required for XML Encoding
     */
    public Menu(){
        items = new ArrayList();
    }
    
    public Menu(Menu original){
        for (MenuItem menuItem : items){
            this.items.add(menuItem);
        }
    }
    /**
     * Standard get function for name
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Standard get function for items
     * @return items
     */
    public List<MenuItem> getItems(){
        return items;
    }
    
    /**
     * Standard set function for name
     * @param name the name to set
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Standard set function for items
     * @param items the list to set
     */
    public void setItems(List<MenuItem> items){
        this.items = items;
    }
    
    /**
     * Adds a MenuItem to the list
     * @param item The MenuItem to add
     */
    public void addItem(MenuItem item){
        items.add(item);
    }
        
    /**
     * Overridden toString
     * @return the name of the menu
     */
    @Override
    public String toString(){
        return name;
    }
}
