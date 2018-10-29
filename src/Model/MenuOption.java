/*******************************************************************
*   MenuOption.java
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
 * Representation of an extra option for a purchasable item
 */
public class MenuOption {
    private ItemOption option;
    private boolean selected;
    private boolean available;
    
    /**
     * Default Constructor: Required for XML Encoding
     */
    public MenuOption(){
        selected = false;
        available = true;
    }
    
    /**
     * Primary Constructor.  Initializes this MenuOption with a reference to an
     * ItemOption object
     * @param option The ItemOption to associate with this MenuOption
     */
    public MenuOption(ItemOption option){
        this.option = option;
        selected = false;
    }
    
    public MenuOption(MenuOption original){
        this.option = original.option;
        this.selected = false;
        this.available = true;
    }
    /**
     * Returns the base reference item
     * @return item
     */
    public ItemOption getOption(){
        return option;
    }
    
    /**
     * Returns the selection state of this option
     * @return item
     */
    public boolean getSelected(){
        return selected;
    }    
    
    public boolean isAvailable(){
        return available;
    }
    
    /**
     * Standard set function for option
     * @param option the option to reference
     */
    public void setOption(ItemOption option){
        this.option = option;
    }
    
    public void setAvailable(boolean available){
        this.available = available;
    }
            
    /**
     * Standard set function for selected
     * @param selected whether this option is selected or not
     */    
    public void select(boolean selected){
        this.selected = selected;
    }
    
    /**
     * Convenience function; fetches the name of the referenced item
     * @return name of referenced item
     */
    public String getName(){
        return option.getName();
    }
    
    /**
     * Convenience function; fetches the price of the referenced item
     * @return price of referenced item
     */
    public double getPrice(){
        return option.getPrice();
    }
        
    /**
     * Overridden toString
     * @return the referenced option's String
     */
    @Override
    public String toString(){
        return option.toString();
    }
    
    public MenuOption returnIfMatch(String name){
        if (this.getName().equals(name)){
            return this;
        }
        return null;
    }
}
