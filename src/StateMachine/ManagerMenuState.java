/*******************************************************************
*   ManagerMenuState.java
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * Specific implementation of State displaying Manager settings
 * 
 */
public class ManagerMenuState implements State{
    private Account account;
    /**
     * Constructor which attaches the current Manager login to this State
     * @param account The Manager Account used to view this State
     */
    public ManagerMenuState(Account account){
        account = this.account;
    }
    
    /**
     * Creates the GUI for this State
     * @param machine the State Machine handling this State
     * @return a javaFX node (any GUI component)
     */
    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        GridPane centerPane = new GridPane();
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setPadding(new Insets(5));
        centerPane.setHgap(5);
        centerPane.setVgap(5);
        
        Button btn_EditAccounts = new Button("Edit Accounts");
        btn_EditAccounts.setPrefWidth(200);
        btn_EditAccounts.setOnAction((event) ->{
            System.out.println("Still Working on this portion! (^_^)");
        });
        
        Button btn_EditStores = new Button("Edit Stores");
        btn_EditStores.setPrefWidth(200);
        btn_EditStores.setOnAction((event) ->{
            machine.pushState(new EditStoreState());
        });
        
//        Button btn_EditItems = new Button("Edit Items");
//        btn_EditItems.setPrefWidth(200);
//        btn_EditItems.setOnAction((event) ->{
//            machine.pushState(new EditItemsState());
//        });
//        
//        Button btn_EditOptions = new Button("Edit Options");
//        btn_EditOptions.setPrefWidth(200);
//        btn_EditOptions.setOnAction((event) ->{
//            System.out.println("Still Working on this portion! (^_^)");
//        });
//        
//        Button btn_EditMenus = new Button("Edit Menus");
//        btn_EditMenus.setPrefWidth(200);
//        btn_EditMenus.setOnAction((event) ->{
//            System.out.println("Still Working on this portion! (^_^)");
//        });        
        
        //centerPane.add(btn_EditAccounts, 1, 1);
        centerPane.add(btn_EditStores, 1, 2);
//        centerPane.add(btn_EditItems, 1, 2);
//        centerPane.add(btn_EditOptions, 1, 3);
//        centerPane.add(btn_EditMenus, 1, 4);        
        
        pane.setCenter(centerPane);
        
        return pane;
    }    
}
