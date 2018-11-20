/*******************************************************************
*   MenuManager.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package Model;

import DataLoader.XMLDataLoader;

/**
 * Singleton class to manage the menus
 * 
 */
public class MenuManager {
    private static MenuManager instance;
    private Menu menu;
    
    /**
     * private Constructor for Singleton construction
     * @param filename If provided, will attempt to load order data from the
     * supplied file.
     */
    private MenuManager(String filename){
        if (filename != null){
            menu = (Menu)XMLDataLoader.get().loadData(filename);
        } else {
            menu = null;
        }
        
        if (menu == null)
        {
            menu = new Menu();
        }
    }
    
    /**
     * Static get function for Singleton access. For the first time call, the
     * supplied filename will be used to attempt a data load. Subsequent calls
     * ignore the argument.
     * @param filename The file to load data from. May be null
     * @return sole instance of OrderManager
     */
    public static MenuManager get(String filename){
        if(instance == null){
            instance = new MenuManager(filename);
        }
        return instance;
    }
    
    /**
     * Static get function for Singleton access. For the first time call using
     * this overloaded method, an empty list will be generated.
     * ignore the argument.
     * @return sole instance of OrderManager
     */
    public static MenuManager get(){
        if(instance == null){
            instance = new MenuManager(null);
        }
        return instance;
    }
    
    /**
     * Retrieves the menu
     * @return menu
     */
    public Menu getMenu(){
        return menu;
    }
    
    public void setMenu(Menu menu){
        this.menu = menu;
    }
}

