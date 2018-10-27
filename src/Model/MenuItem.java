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

import Exceptions.DuplicateItemException;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a purchasable item for a menu
 * 
 */
public class MenuItem {
    ItemBase item;
    DrinkSize size;
    List<MenuOption> options;
    
    /**
     * Default Constructor: Required for XML Encoding
     */
    public MenuItem(){
        size = DrinkSize.SMALL;
        options = new ArrayList();
    }
    
    /**
     * Primary Constructor.  Initializes this MenuItem with a reference to an
     * ItemBase object
     * @param item the ItemBase to reference
     */
    public MenuItem(ItemBase item){
        this.item = item;
        size = DrinkSize.SMALL;
        options = new ArrayList();
    }
    
    /**
     * Returns the base reference item
     * @return item
     */
    public ItemBase getItemBase(){
        return item;
    }
    
    /**
     * Returns the currently selected drink size
     * @return size
     */
    public DrinkSize getSize(){
        return size;
    }
    
    /**
     * Returns a list of available options associated with this MenuItem
     * @return options
     */
    public List<MenuOption> getOptions(){
        return options;
    }
    
    /**
     * Standard set function for item
     * @param item the item to set
     */
    public void setItemBase(ItemBase item){
        this.item = item;
    }

    /**
     * Standard set function for size
     * @param size the size to set
     */
    public void setSize(DrinkSize size){
        this.size = size;
    }
    
    /**
     * Standard set function for options
     * @param options the list of options to set
     */
    public void setOptions(List<MenuOption> options){
        this.options = options;
    }
    
    /**
     * Convenience function; fetches the name of the referenced item
     * @return name of referenced item
     */
    public String getName(){
        return item.getName();
    }
    
    /**
     * Convenience function; fetches the price of the referenced item
     * @return price of referenced item
     */
    public double getPrice(){
        return item.getPrice();
    }
    
    /**
     * Adds a MenuOption item to the list of available options for this
     * MenuItem
     * @param newOption the option to add
     */
    public void addOption(MenuOption newOption){
        for(MenuOption option : options){
            if (option.equals(newOption)){
                throw new DuplicateItemException("Item already exists.");
            }
        }
        options.add(newOption);
    }
    
    /**
     * Uses the selected options of this MenuItem to construct a properly 
     * decorated Item
     * @return A decorated ItemBase object
     */
    public ItemBase buildItem(){
        // First get the actual base item
        ItemBase newItem = item;
        
        // Next, create and assign a new Decorator based on the selected size
        newItem = new ItemOption(size.getName(), size.getPrice()).addDecoration(newItem);

        // Next, cycle through all options associated with the item
        for (MenuOption option : options){
            // if the option is selected, use the ItemOption copy constructor
            // and add the new Decorator to the item
            if (option.getSelected()){
                newItem = new ItemOption(option.getOption()).addDecoration(newItem);
            }
        }
        return newItem;
    }
    
    /**
     * Overridden toString
     * @return returns the string of the referenced item
     */
    @Override
    public String toString(){
        return item.toString();
    }
}
