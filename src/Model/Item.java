/*******************************************************************
*   Item.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package Model;

import java.util.List;

/**
 *  A derived Class of ItemBase, making use of the Decorator Design Pattern
 * 
 */
public class Item extends ItemBase{
    private List<ItemOption> availableOptions;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
    
}
