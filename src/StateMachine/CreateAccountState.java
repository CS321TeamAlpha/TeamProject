/*******************************************************************
*   CreateAccountState.java
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
import Model.AccountManager;
import Model.AccountType;
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
import javafx.scene.paint.Paint;

/**
 * A specific implementation of State to handle new Customer Account Creation
 * 
 */
public class CreateAccountState implements State{

    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        
        GridPane centerPane = new GridPane();
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setPadding(new Insets(5));
        centerPane.setVgap(5);
        centerPane.setHgap(5);
        pane.setCenter(centerPane);
        
        Label lbl_Status = new Label("");
        lbl_Status.setTextFill(Paint.valueOf("FF0000"));
        Label lbl_UserName = new Label("User Name");
        TextField fld_UserName = new TextField();
        
        Label lbl_Password = new Label("Password");
        PasswordField fld_Password = new PasswordField();
        
        Button btn_Create = new Button("Create Account");
        btn_Create.setOnAction((event) ->{
            String userName = fld_UserName.getText();
            String password = fld_Password.getText();
            if (!AccountManager.get().accountExists(userName)){
                Account newAccount = new Account(
                        userName, 
                        password, 
                        AccountType.USER);
                AccountManager.get().add(newAccount);
                machine.popState();
                machine.pushState(new LoggedInState(newAccount));
            } else {
                lbl_Status.setText("There is already an account with that name.");
            }
        });
        
        centerPane.add(lbl_Status, 0,0,2,1);
        centerPane.add(lbl_UserName, 0,1);
        centerPane.add(fld_UserName, 1,1);
        centerPane.add(lbl_Password, 0,2);
        centerPane.add(fld_Password, 1,2);
        centerPane.add(btn_Create, 0,3,2,1);
        
        HBox buttonBar = new HBox();
        buttonBar.setPadding(new Insets(5));
        buttonBar.setSpacing(5);
        pane.setBottom(buttonBar);
        
        Button btn_Cancel = new Button("Cancel");
        btn_Cancel.setOnAction((event) ->{
            machine.popState();
        });
        buttonBar.getChildren().add(btn_Cancel);
        
        return pane;
    }
    
}
