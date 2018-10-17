/*******************************************************************
*   CafeKiosk.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package cafekiosk;

import Model.Account;
import Model.AccountManager;
import Model.AccountType;
import Model.Item;
import Model.ItemBase;
import Model.ItemManager;
import Model.Menu;
import Model.MenuItem;
import Model.OrderManager;
import Model.Store;
import Model.StoreManager;
import StateMachine.FSM;
import StateMachine.LoginState;
import StateMachine.State;
import java.util.Stack;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * A simulator for an on-line purchasing system
 * 
 */
public class CafeKiosk extends Application implements FSM {
    private final ItemManager itemManager = ItemManager.get();
    private final StoreManager storeManager = StoreManager.get();
    private final OrderManager orderManager = OrderManager.get();
    private final AccountManager accountManager = AccountManager.get();
    private final Stack<State> states = new Stack();
    private final BorderPane root = new BorderPane();
    
    @Override
    public void start(Stage primaryStage) {
        GenerateTestData();
        pushState(new LoginState());
               
        //root.getChildren().add(getGUI());
        
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Cafe Kiosk");
        primaryStage.setScene(scene);
        primaryStage.show();   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }  
    
    @Override
    public void pushState(State state){
        states.push(state);
        root.setCenter(getGUI());
    }
    
    @Override
    public void popState(){
        states.pop();
        root.setCenter(getGUI());
    }
    
    @Override
    public Node getGUI(){
        return states.peek().getGUI(this);
    }
    
    @Override
    public void reset(){
        while(states.size() > 1){
            states.pop();
        }
        root.setCenter(getGUI());
    }
    
    public void GenerateTestData(){
        if (!AccountManager.get().accountExists("admin")){
            Account adminAccount = new Account("admin", "password", AccountType.MANAGER);
            AccountManager.get().add(adminAccount);
        }
        if (!AccountManager.get().accountExists("user")){
            Account adminAccount = new Account("user", "password", AccountType.USER);
            AccountManager.get().add(adminAccount);
        }
        
        Store newStore1 = new Store();
        newStore1.setName("Test Store 1");
        Store newStore2 = new Store();
        newStore2.setName("Test Store 2");
        StoreManager.get().add(newStore1);
        StoreManager.get().add(newStore2);
        
        Menu newMenu1 = new Menu();
        newMenu1.setName("Test Menu 1");
        newStore1.addMenu(newMenu1);
        
        Menu newMenu2 = new Menu();
        newMenu2.setName("Test Menu 2");
        newStore2.addMenu(newMenu2);
        
        ItemBase itemprof1 = new Item();
        itemprof1.setName("Coffee");
        itemprof1.setPrice(100);
        ItemBase itemprof2 = new Item();
        itemprof2.setName("Tea");
        itemprof2.setPrice(100);
        ItemManager.get().add(itemprof1);
        ItemManager.get().add(itemprof2);
        
        MenuItem menuItem11 = new MenuItem(itemprof1);
        MenuItem menuItem12 = new MenuItem(itemprof2);
        MenuItem menuItem21 = new MenuItem(itemprof1);

        newMenu1.add(menuItem11);
        newMenu2.add(menuItem12);
        newMenu2.add(menuItem21);
    }
}
