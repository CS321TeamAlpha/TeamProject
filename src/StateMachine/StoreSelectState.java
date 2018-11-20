/*******************************************************************
*   StoreSelectState.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package StateMachine;

import Model.Account;
import Model.Store;
import Model.StoreManager;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * A specific implementation of State to allow a purchaser to select a store.
 *
 */
public class StoreSelectState implements State{
    private final Account account;
    
    /**
     * Constructor which attaches the currently used Account to this State
     * @param account The Account used to log in
     */
    public StoreSelectState(Account account){
        this.account = account;
    }
    
    /**
     * Creates the GUI for this State
     * @param machine the State Machine handling this State
     * @return a javaFX node (any GUI component)
     */
    @Override
    public Node getGUI(FSM machine) {
       BorderPane pane = new BorderPane();
       
       VBox storeList = new VBox();
       storeList.setPadding(new Insets(5));
       storeList.setSpacing(5);
       for(Store store : StoreManager.get().getItems()){
           storeList.getChildren().add(buildStoreEntry(machine, store));
       }
       pane.setCenter(storeList);
       
       return pane;
    }

    private Node buildStoreEntry(FSM machine, Store store){
        Pane pane = new Pane();
        Button btn_Store = new Button(store.getName());
        btn_Store.setPrefWidth(150);
        btn_Store.setOnAction((event) ->{
            machine.pushState(new BrowseState(account, store));
        });
        pane.getChildren().add(btn_Store);
        return pane;
    }
}
