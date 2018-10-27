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

import Exceptions.OrderAlreadyFinalizedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a purchase
 * 
 */
public class Order implements Comparable<Order>{
    private Account purchaser;
    private Store store;
    private String purchaseDate;
    private List<ItemBase> items;
    
    /**
     * Default Constructor: Required for XML Encoding
     */
    public Order(){
        items = new ArrayList();
    }
    
    /**
     * Primary Constructor.  Initializes this Order with an Account and a Store
     * @param purchaser the Account to tie to this order
     * @param store the Store to tie to this order
     */
    public Order(Account purchaser, Store store){
        this.purchaser = purchaser;
        this.store = store;
        items = new ArrayList();
    }
    
    /**
     * Returns the purchaser
     * @return purchaser
     */
    public Account getPurchaser(){
        return purchaser;
    }
    
    /**
     * Returns the store
     * @return store
     */
    public Store getStore(){
        return store;
    }
    
    /**
     * Returns the date this order was finalized
     * @return purchaseDate
     */
    public String getPurchaseDate(){
        return purchaseDate;
    }
    
    /**
     * Returns a list of all decorated items on this order
     * @return items
     */
    public List<ItemBase> getItems(){
        return items;
    }
    
    /**
     * Standard set function for purchaser
     * @param purchaser the Account making the purchase
     */
    public void setPurchaser(Account purchaser){
        this.purchaser = purchaser;
    }
    
    /**
     * Standard set function for store
     * @param store The location of the purchase
     */
    public void setStore(Store store){
        this.store = store;
    }
    
    /**
     * Standard set function for purchaseDate
     * @param purchaseDate a String representing the date stamp
     */
    public void setPurchaseDate(String purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    /**
     * Standard set function for items
     * @param items the list of items to assign to this order
     */
    public void setItems(List<ItemBase> items){
        this.items = items;
    }
    
    /**
     * Adds a decorated item to the order
     * @param item The item to add
     */
    public void addItem(ItemBase item){
        items.add(item);
    }
    
    /**
     * Removes an item from the order
     * @param item the item to remove
     */
    public void removeItem(ItemBase item){
        items.remove(item);
    }
    
    /**
     * Finalizes and date stamps the order.  This can only be done once per
     * order
     * @throws OrderAlreadyFinalizedException This order has already been finalized
     */
    public void purchaseOrder() throws OrderAlreadyFinalizedException{
        if (purchaseDate == null){
            purchaseDate = LocalDateTime.now().toString();
            OrderManager.get(null).add(this);
        } else {
            throw new OrderAlreadyFinalizedException(
                    "This Order has already been finalized.");
        }
    }
    
    /**
     * Overridden toString
     * @return a formatted String containing the purchaser, store, and date stamp
     */
    @Override
    public String toString(){
        return purchaser.getName() + ": " + store.getName() + ": " + purchaseDate;
    }
    
    /**
     * Overridden compareTo
     * @param o the other Order to compare to this one
     * @return standard compare results
     */
    @Override
    public int compareTo(Order o) {
        if(purchaser.compareTo(o.getPurchaser()) == 0){
            if(store.compareTo(o.getStore()) == 0){
                return purchaseDate.compareTo(o.getPurchaseDate());
            }
            return store.compareTo(o.getStore());
        }
        return purchaser.compareTo(o.getPurchaser());
    }
}
