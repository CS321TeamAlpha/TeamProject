/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utilities.Utilities;

/**
 *
 * @author bs0084
 */
public abstract class ItemBase {
    protected String name;
    protected int price;
    
    public abstract String getName();
    
    public abstract int getPrice();
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(int price){
        this.price = price;
    }
    
    @Override
    public String toString(){
        return getName() + " " + Utilities.intToCurrencyString(getPrice());
    }
}
