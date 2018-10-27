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
import Model.AccountManager;
import Model.AccountType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

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
        centerPane.setVgap(5);
        centerPane.setHgap(5);
        
        Label lbl_Welcome = new Label("Welcome to [Insert Cafe Name Here]!" +
                "\r\nPlease log in to place an order");
        
        Label lbl_Status = new Label("Manager username: 'admin'\r\npassword: 'password'");
        lbl_Status.setTextFill(Paint.valueOf("FF0000"));
        
        Label lbl_UserName = new Label("User Name");
        TextField fld_UserName = new TextField();
        
        Label lbl_Password = new Label("Password");
        PasswordField fld_Password = new PasswordField();
        fld_Password.setOnKeyPressed((event) ->{
            KeyCode keyCode = event.getCode();
            if (keyCode.equals(KeyCode.ENTER)){
                String userName = fld_UserName.getText();
                String password = fld_Password.getText();
                Account account = AccountManager.get().validateAccount(userName,password);
                if(account != null){
                    if(account.getAccountType() == AccountType.MANAGER){
                        machine.pushState(new ManagerLoggedInState(account));
                    } else {
                        machine.pushState(new LoggedInState(account));
                    }
                } else {
                    lbl_Status.setText("user name or password is incorrect.");
                }
            }
        });
        centerPane.add(lbl_Status, 0,0,2,1);
        centerPane.add(lbl_UserName, 0,1);
        centerPane.add(fld_UserName, 1,1);
        centerPane.add(lbl_Password, 0,2);
        centerPane.add(fld_Password, 1,2);        
        
        HBox buttonBar = new HBox();
        buttonBar.setPadding(new Insets(5));
        buttonBar.setSpacing(5);
        
        Button btn_Login = new Button("Log In");
        btn_Login.setOnAction((event) -> {
            String userName = fld_UserName.getText();
            String password = fld_Password.getText();
            Account account = AccountManager.get().validateAccount(userName,password);
            if(account != null){
                if(account.getAccountType() == AccountType.MANAGER){
                    machine.pushState(new ManagerLoggedInState(account));
                } else {
                    machine.pushState(new LoggedInState(account));
                }
            } else {
                lbl_Status.setText("user name or password is incorrect.");
            }
        });
        buttonBar.getChildren().add(btn_Login);
        
        Button btn_NewAccount = new Button("Create Account");
        btn_NewAccount.setOnAction((event) -> {
            machine.pushState(new CreateAccountState());
        });
        buttonBar.getChildren().add(btn_NewAccount);
        
        // *** Convenience Buttons.  Remove for actual use ***
        Button btn_FastLogin = new Button("Fast User Login");
        btn_FastLogin.setOnAction((event) -> {
            Account account = AccountManager.get().validateAccount("user", "password");
            machine.pushState(new LoggedInState(account));
        });
        buttonBar.getChildren().add(btn_FastLogin);
        
        Button btn_FastManager = new Button("Fast Manager Login");
        btn_FastManager.setOnAction((event) -> {
            Account account = AccountManager.get().validateAccount("admin", "password");
            machine.pushState(new ManagerLoggedInState(account));
        });
        buttonBar.getChildren().add(btn_FastManager);
        // ***************************************************
        
        pane.setTop(lbl_Welcome);
        pane.setCenter(centerPane);
        pane.setBottom(buttonBar);
        
        return pane;
    }
}
