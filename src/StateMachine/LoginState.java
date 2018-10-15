/*******************************************************************
*   LoginState.java
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * A specific Implementation of State to handle login authentication
 * 
 */
public class LoginState implements State{
   
    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        GridPane centerPane = new GridPane();
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setPadding(new Insets(5));
        
        Label lbl_Welcome = new Label("Welcome to [Insert Cafe Name Here]!" +
                "\r\nPlease log in to place an order");
                
        Label lbl_UserName = new Label("User Name:");
        TextField fld_UserName = new TextField();
        
        Label lbl_Password = new Label("Password");
        PasswordField fld_Password = new PasswordField();
        
        centerPane.add(lbl_UserName, 0,0);
        centerPane.add(fld_UserName, 1,0);
        centerPane.add(lbl_Password, 0,1);
        centerPane.add(fld_Password, 1,1);
        centerPane.setVgap(5);
        centerPane.setHgap(5);
        
        HBox buttonBar = new HBox();
        buttonBar.setPadding(new Insets(5));
        buttonBar.setSpacing(5);
        
        Button btn_Login = new Button("Log In");
        btn_Login.setOnAction((event) -> {
            machine.pushState(new LoggedInState(new Account()));
        });
        buttonBar.getChildren().add(btn_Login);
        
        Button btn_NewAccount = new Button("Create Account");
        btn_NewAccount.setOnAction((event) -> {
            System.out.println("Still working on this! (^_^)");
        });
        buttonBar.getChildren().add(btn_NewAccount);
        
//        Button btn_Cancel = new Button("Cancel");
//        btn_Cancel.setOnAction((event) -> {
//            machine.popState();
//        });
//        buttonBar.getChildren().add(btn_Cancel);
        
        pane.setTop(lbl_Welcome);
        pane.setCenter(centerPane);
        pane.setBottom(buttonBar);
        
        return pane;
    }    
        
    @Override
    public String toString(){
        return "Login State";
    } 
}
