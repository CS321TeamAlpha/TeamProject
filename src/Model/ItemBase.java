/*******************************************************************
*   ItemBase.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package Model;

import Utilities.Utilities;

/**
 * The base class of the Decorator Design Pattern
 * 
 */
public abstract class ItemBase {
    protected String name;
    protected int price;
    
    public abstract String getName();
    
    public abstract int getPrice();
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    @Override
    public String toString(){
        return getName() + " " + Utilities.intToCurrencyString(getPrice());
    }
}
