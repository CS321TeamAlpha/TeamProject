/*******************************************************************
*   Order.java
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
import java.util.Date;
import java.util.List;


/**
 * Representation of a purchase
 * 
 */
public class Order {
    private final Account purchaser;
    private final Store store;
    private Date purchaseDate;
    private final List<ItemBase> orderItems;
    
    public Order(Account purchaser, Store store){
        this.purchaser = purchaser;
        this.store = store;
        orderItems = new ArrayList();
    }
    
    public List<ItemBase> getItems(){
        return orderItems;
    }
    
    public void addItem(ItemBase item){
        orderItems.add(item);
    }
    
    public void removeItem(ItemBase item){
        orderItems.remove(item);
    }
    
    public Account getPurchaser(){
        return purchaser;
    }
    
    public Store getStore(){
        return store;
    }
    
    public Date getPurchaseDate(){
        return purchaseDate;
    }
    
    public void setDate(){
        purchaseDate = new Date();
    }
}
