/*******************************************************************
*   Store.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a Store with a set of menus
 * 
 */
public class Store implements Comparable<Store>{
    private String name;
    private Menu activeMenu;
    private List<Menu> menus;
    
    /**
     * Default Constructor: Required for XML Encoding
     */
    public Store(){
        menus = new ArrayList();
        Menu menu = new Menu(MenuManager.get().getMenu());  
    }    
    
    
    /**
     * Primary Constructor.  Initializes this Store with a name
     * @param name The name of the new Store
     */
    public Store(String name){
        this.name = name;
        menus = new ArrayList();
    }
    
    /**
     * Returns the name of the store
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns the currently active menu at this store
     * @return activeMenu
     */
    public Menu getActiveMenu(){
        return activeMenu;
    }
    
    /**
     * Returns a list of available menus at this store
     * @return menus
     */
    public List<Menu> getMenus(){
        return menus;
    }
    
    /**
     * Standard set function for name
     * @param name the name of the store
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Standard set function for menu
     * @param menu the Menu to be made active
     */
    public void setActiveMenu(Menu menu){
        this.activeMenu = menu;
    }
    
    /**
     * Standard set function for menus
     * @param menus the list of Menus to assign to this store
     */
    public void setMenus(List<Menu> menus){
        this.menus = menus;
    }
    
    /**
     * Adds a menu to the list of available menus
     * @param menu the menu to add
     */
    public void addMenu(Menu menu){
        menus.add(menu);
        if(activeMenu == null)
            activeMenu = menu;
    }
    
    /**
     * Returns a list of items on the active menu
     * @return a list of items on the active menu
     */
    public List<MenuItem> getActiveMenuItems(){
        return activeMenu.getItems();
    }
    
    /**
     * Overridden toString
     * @return the name of the store
     */
    @Override
    public String toString(){
        return name;
    }

    /**
     * Overridden compareTo
     * @param o the other Store to compare to this one
     * @return standard compare results
     */
    @Override
    public int compareTo(Store o) {
        return name.compareTo(o.getName());
    }
}
