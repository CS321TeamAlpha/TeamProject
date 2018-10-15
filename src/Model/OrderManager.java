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
    
    private OrderManager(){
        orders = (ArrayList<Order>)XMLDataLoader.get().loadData("MasterOrderList.xml");
        if (orders != null){
            orders.sort(null);
        } else {
            orders = new ArrayList();
        }
    }
    
    public static OrderManager get(){
        if(instance == null){
            instance = new OrderManager();
        }
        return instance;
    }
    
    public List<Order> getItems(){
        return orders;
    }
    
    public void add(Order order){
        orders.add(order);
    }
}
