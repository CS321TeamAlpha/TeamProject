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
    //private List<Menu> menus;
    private List<MenuItem> items;
    private List<MenuOption> options;
    
    /**
     * Default Constructor: Required for XML Encoding
     */
    public Store(){
        this.name = "Unamed";
        items = new ArrayList();
        options = new ArrayList();
        activeMenu = new Menu();
        //menus = new ArrayList();
        
        LoadMenu();
    }
    
    /**
     * Primary Constructor.  Initializes this Store with a name
     * @param name The name of the new Store
     */
    public Store(String name){
        this.name = name;
        items = new ArrayList();
        options = new ArrayList();
        activeMenu = new Menu();
        //menus = new ArrayList();
        
        LoadMenu();        
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
    public Menu getMenu(){
        return activeMenu;
    }
    
    /**
     * Returns a list of available menus at this store
     * @return menus
     */
//    public List<Menu> getMenus(){
//        return menus;
//    }
    
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
//    public void setActiveMenu(Menu menu){
//        this.activeMenu = menu;
//    }
    
    /**
     * Standard set function for menus
     * @param menus the list of Menus to assign to this store
     */
//    public void setMenus(List<Menu> menus){
//        this.menus = menus;
//    }
    
    /**
     * Adds a menu to the list of available menus
     * @param menu the menu to add
     */
//    public void addMenu(Menu menu){
//        menus.add(menu);
//        if(activeMenu == null)
//            activeMenu = menu;
//    }
    
    /**
     * Returns a list of items on the active menu
     * @return a list of items on the active menu
     */
    public List<MenuItem> getActiveMenuItems(){
        return items;
    }
    
    public List<MenuOption> getActiveMenuOptions(){
        return options;
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
    
    private void LoadMenu(){
        // Every Time a store is created, it needs a deep copy of the Master
        // Menu so that each store can mark items as unavailable for just its
        // menu.
        Menu masterMenu = MenuManager.get().getMenu();
        
        // For every MenuItem in the MasterMenu
        for (MenuItem masterItem : masterMenu.getItems()){
            // Copy that MenuItem and add it to the store's list
            // The copy constructor for MenuItem does not populate its options
            // list however, since those too have to be a deep copy.
            MenuItem item = new MenuItem(masterItem);
            items.add(item);
            // And add the item to the local menu
            activeMenu.addItem(item);
            
            // So for each MenuOption for this MenuItem from the Master Menu
            for(MenuOption masterOption : masterItem.getOptions()){
                MenuOption current = null;
                // Check to see if there is already a local copy in the Store,
                // and if so store it in 'current'
                for(MenuOption option : options){
                    current = option.returnIfMatch(masterOption.getName());
                    if (current != null){
                        break;
                    }
                }
                // By this point 'current' will either have a local reference
                // or be null if no local copy was found.  If it is null, then
                // create a local copy and put in the store's MenuOption list
                if (current == null){
                    current = new MenuOption(masterOption);
                    options.add(current);
                }
                // And add the option to the item
                item.addOption(current);
            }
        }
    }
}
