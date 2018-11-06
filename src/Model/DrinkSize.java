/*******************************************************************
*   DrinkSize.java
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
 *  An enumeration detailing the sizes of Drinks
 *  This data will be used to construct some Decorators, since
 *  drink sizes are a special case
 */
public enum DrinkSize {
    SMALL ("Small", 0.0),
    MEDIUM ("Medium", 0.20),
    LARGE ("Large", 0.40);
    
    private final String name;
    private final double price;
    
    /**
     * Private Constructor needed to assign the name and price to a given size.
     * @param name The display name for this size
     * @param price The additional price for this size
     */
    private DrinkSize(String name, double price){
        this.name = name;
        this.price = price;
    }
    
    /**
     * returns the name of this size
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * returns the price of this size
     * @return price
     */
    public double getPrice(){
        return price;
    }
    
    /**
     * Overridden toString
     * @return a properly formated String with the name and price
     */
    @Override
    public String toString(){
        return name + " " + String.format("$%3.2f", price);
    }
}
