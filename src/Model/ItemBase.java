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

/**
 * The base interface of the Decorator Design Pattern
 * 
 */
public interface ItemBase {
    public String getName();
    public double getPrice();
    public String getName_multiLine();
}
