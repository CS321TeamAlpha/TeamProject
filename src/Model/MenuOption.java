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
    
    /**
     * Default Constructor: Required for XML Encoding
     */
    public MenuOption(){
        selected = false;
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
    
    /**
     * Standard set function for option
     * @param option the option to reference
     */
    public void setOption(ItemOption option){
        this.option = option;
    }

    /**
     * Standard set function for selected
     * @param selected whether this option is selected or not
     */    
    public void setSelected(boolean selected){
        this.selected = selected;
    }
    
    /**
     * Overridden toString
     * @return the referenced option's String
     */
    @Override
    public String toString(){
        return option.toString();
    }
}
