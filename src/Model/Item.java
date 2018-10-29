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

import java.util.Scanner;

/**
 *  A derived Class of ItemBase, making use of the Decorator Design Pattern
 * 
 */
public class Item implements ItemBase, Comparable<Item>{
    private String name;
    private double price;
    
    /**
     * Empty Constructor needed for XML Encoding
     */
    public Item(){
    }
    
    /**
     * Primary Constructor which creates object with a name and price.
     * @param name The name of the item
     * @param price The price of the item
     */
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }
    /**
     * Standard get function for name
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Standard get function for price
     * @return price
     */
    @Override
    public double getPrice() {
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
        return getName() + " " + String.format("$%3.2f", getPrice());
    }
    
    /**
     * Overridden compareTo
     * @param o the Item to compare to the current Item
     * @return a standard compare result (-1,0, 1)
     */
    @Override
    public int compareTo(Item o) {
        return name.compareTo(o.getName());
    }
    
    public static double stringToDouble(String string){
        Scanner scanner = new Scanner(string);
        scanner.useDelimiter("$");
        if(scanner.hasNextDouble()){
            return scanner.nextDouble();
        }
        return 0.0;
    }
}
