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
public class Store {
    private String name;
    private Menu activeMenu;
    private final List<Menu> menus;
    
    public Store(){
        menus = new ArrayList();
    }
    
    public Menu getActiveMenu(){
        return activeMenu;
    }
    
    public List<MenuItem> getActiveMenuItems(){
        return activeMenu.getItems();
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void addMenu(Menu menu){
        menus.add(menu);
        if(activeMenu == null)
            activeMenu = menu;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
