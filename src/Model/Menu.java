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
public class Menu {
    private String name;
    private List<MenuItem> items;
    
    public Menu(){
        items = new ArrayList();
    }
    
    public List<MenuItem> getItems(){
        return items;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void add(MenuItem item){
        items.add(item);
    }
        
    @Override
    public String toString(){
        return name;
    }
}
