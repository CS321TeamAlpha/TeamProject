/*******************************************************************
*   MenuItem.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package Model;

/**
 * Representation of a purchasable item for a menu
 * 
 */
public class MenuItem {
    ItemBase item;
    
    public MenuItem(ItemBase item){
        this.item = item;
    }
    
    public ItemBase getItemBase(){
        return item;
    }
    
    public String getName(){
        return item.getName();
    }
    
    public int getPrice(){
        return item.getPrice();
    }
  
    @Override
    public String toString(){
        return item.toString();
    }
}
