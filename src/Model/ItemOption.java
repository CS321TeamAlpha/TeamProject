/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bernard
 */
public abstract class ItemOption extends ItemBase{
    protected ItemBase decoratee;
    
    public ItemOption(ItemBase decoratee){
        this.decoratee = decoratee;
    }    
}
