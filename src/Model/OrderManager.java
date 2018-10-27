/*******************************************************************
*   OrderManager.java
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
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class to manage the master list of orders
 * 
 */
public class OrderManager {
    private static OrderManager instance;
    private List<Order> orders;
    
    /**
     * private Constructor for Singleton construction
     * @param filename If provided, will attempt to load order data from the
     * supplied file.
     */
    private OrderManager(String filename){
        if (filename != null){
            orders = (ArrayList<Order>)XMLDataLoader.get().loadData(filename);
        } else {
            orders = null;
        }
        
        if (orders != null){
            orders.sort(null);
        } else {
            orders = new ArrayList();
        }
    }
    
    /**
     * Static get function for Singleton access. For the first time call, the
     * supplied filename will be used to attempt a data load. Subsequent calls
     * ignore the argument.
     * @param filename The file to load data from. May be null
     * @return sole instance of OrderManager
     */
    public static OrderManager get(String filename){
        if(instance == null){
            instance = new OrderManager(filename);
        }
        return instance;
    }
    
    /**
     * Static get function for Singleton access. For the first time call using
     * this overloaded method, an empty list will be generated.
     * ignore the argument.
     * @return sole instance of OrderManager
     */
    public static OrderManager get(){
        if(instance == null){
            instance = new OrderManager(null);
        }
        return instance;
    }
    
    /**
     * Retrieves the list of Orders
     * @return list of Orders
     */
    public List<Order> getItems(){
        return orders;
    }
    
    /**
     * Adds an order to the list
     * @param order The Order to be added
     */
    public void add(Order order){
        orders.add(order);
    }
}
