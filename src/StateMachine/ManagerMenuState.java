/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateMachine;

import Model.Account;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Bernard
 */
public class ManagerMenuState implements State{
    private Account account;
    public ManagerMenuState(Account account){
        account = this.account;
    }
    
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
        Button btn_EditOptions = new Button("Edit Options");
        btn_EditOptions.setOnAction((event) ->{
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
