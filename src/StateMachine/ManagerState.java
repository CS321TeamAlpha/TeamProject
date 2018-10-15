/*******************************************************************
*   ManagerState.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package StateMachine;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * A specific implementation of State to provide access to manager level options
 * in maintaining the system.
 * 
 */
public class ManagerState implements State{

    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        
        VBox buttonBox = new VBox();
        
        Button btn_EditStores = new Button("Edit Stores");
        btn_EditStores.setOnAction((event) ->{
            System.out.println("Still Working on this portion! (^_^)");
        });
        Button btn_EditItems = new Button("Edit Items");
        btn_EditItems.setOnAction((event) ->{
            System.out.println("Still Working on this portion! (^_^)");
        });
        Button btn_EditMenus = new Button("Edit Menus");
        btn_EditMenus.setOnAction((event) ->{
            System.out.println("Still Working on this portion! (^_^)");
        });
        Button btn_EditAccounts = new Button("Edit Accounts");
        btn_EditAccounts.setOnAction((event) ->{
            System.out.println("Still Working on this portion! (^_^)");
        });
        
        buttonBox.getChildren().add(btn_EditStores);
        buttonBox.getChildren().add(btn_EditItems);
        buttonBox.getChildren().add(btn_EditMenus);
        buttonBox.getChildren().add(btn_EditAccounts);
        
        pane.setCenter(buttonBox);
        
        return pane;
    }
    
}
