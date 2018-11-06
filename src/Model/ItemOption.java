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
public class ItemOption implements ItemBase{
    private String name;
    private double price;
    private ItemBase decoratee;
    
    /**
     * Empty Constructor needed for XML Encoding
     */
    public ItemOption(){        
    }
    
    /**
     * Copy Constructor
     * @param original The ItemOption to duplicate
     */
    public ItemOption(ItemOption original){
        this.name = original.name;
        this.price = original.price;
    }
    
    /**
     * Standard Constructor
     * @param name The name of the new option
     * @param price the price of the new option
     */
    public ItemOption(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    /**
     * Assigns the base instance that this ItemOption decorates
     * @param decoratee the instance of the object to decorate
     * @return this ItemOption
     */
    public ItemOption addDecoration(ItemBase decoratee){
        this.decoratee = decoratee;
        return this;
    }
    
    /**
     * Builds a String containing the name of the decoratee and this
     * ItemOption's name
     * @return a formatted String
     */
    @Override
    public String getName() {
        if (decoratee != null)
            return decoratee.getName() + " +" + name;
        return name;
    }
    //used to print out the decorated item line by line, rather than all in one line
    @Override
    public String getName_multiLine() {
        if (decoratee != null)
            return decoratee.getName_multiLine() + "\n\t" + name;
        return name;
    }
    /**
     * Calculates the total price of the decoratee and the decorator
     * @return the total price
     */
    @Override
    public double getPrice() {
        if (decoratee != null)
            return decoratee.getPrice() + price;
        return price;
    }
    
    /**
     * Standard set function for name
     * @param name the name to set
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Standard set function for price
     * @param price the price to set
     */
    public void setPrice(double price){
        this.price = price;
    }
    
    /**
     * Overridden toString
     * @return the item name and price as a properly formatted String
     */
    @Override
    public String toString(){
        return getName() + " +" + String.format("$%3.2f", getPrice());
    }
}
