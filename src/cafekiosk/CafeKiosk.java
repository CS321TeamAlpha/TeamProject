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

import DataLoader.XMLDataLoader;
import Model.AccountManager;
import Model.ItemManager;
import Model.MenuManager;
import Model.OrderManager;
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
    private final ItemManager itemManager = 
            ItemManager.get("MasterItemList.xml", "MasterOptionList.xml");
    private final MenuManager menuManager =
            MenuManager.get("MasterMenu.xml");
    private final StoreManager storeManager = 
            StoreManager.get("MasterStoreList.xml");
    private final OrderManager orderManager = 
            OrderManager.get("MasterOrderList.xml");
    private final AccountManager accountManager = 
            AccountManager.get("MasterAccountList.xml");
    
    private final Stack<State> states = new Stack();
    private final BorderPane root = new BorderPane();
    
    @Override
    public void start(Stage primaryStage) {
      //TestData testData = new TestData();
      //testData.generate();
        
        pushState(new LoginState());
               
        //root.getChildren().add(getGUI());
        
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Cafe Kiosk");
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Saving files:");
            XMLDataLoader.get().saveData(
                    itemManager.getItems(), "MasterItemList.xml");
            XMLDataLoader.get().saveData(
                    itemManager.getOptions(), "MasterOptionList.xml");
            XMLDataLoader.get().saveData(
                    orderManager.getItems(), "MasterOrderList.xml");
            XMLDataLoader.get().saveData(
                    storeManager.getItems(), "MasterStoreList.xml");
            XMLDataLoader.get().saveData(
                    accountManager.getItems(), "MasterAccountList.xml");
            XMLDataLoader.get().saveData(
                    menuManager.getMenu(), "MasterMenu.xml");
        });
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
}
