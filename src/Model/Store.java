/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bs0084
 */
public class Store {
    private String name;
    private Menu activeMenu;
    private List<Menu> menus;
    
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
