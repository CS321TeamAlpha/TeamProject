/*******************************************************************
*   ItemOption.java
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
 * A derived class of ItemBase, making use of the Decorator Design Pattern
 * 
 */
public abstract class ItemOption extends ItemBase{
    protected ItemBase decoratee;
    
    public ItemOption(ItemBase decoratee){
        this.decoratee = decoratee;
    }    
}
