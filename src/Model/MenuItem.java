/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author bs0084
 */
public class MenuItem {
    ItemBase item;
    
    public MenuItem(ItemBase item){
        this.item = item;
    }
    
    public String getName(){
        return item.getName();
    }
    
    public int getPrice(){
        return item.getPrice();
    }
  
    @Override
    public String toString(){
        return item.toString();
    }
}
