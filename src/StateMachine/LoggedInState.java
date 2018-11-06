/*******************************************************************
*   LoggedInState.java
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
import java.util.Stack;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * A specific State to handle a logged in account as well as being a state
 * machine as well.
 */
public class LoggedInState implements State, FSM{
    private final Stack<State> states = new Stack();
    private final BorderPane root = new BorderPane();
    private final Account account;
    public LoggedInState(Account account){
        this.account = account;
        states.push(new StoreSelectState(account));
    }
    
    @Override
    public Node getGUI(FSM machine) {
        HBox buttonBar = new HBox();
        buttonBar.setSpacing(5);
        buttonBar.setAlignment(Pos.CENTER_RIGHT);
        buttonBar.setPadding(new Insets(5));
        
        Label lbl_UserName = new Label(account.getName());
        buttonBar.getChildren().add(lbl_UserName);
        
        //Button btn_EditProfile = new Button("Edit Profile");
        //btn_EditProfile.setOnAction((event) ->{
            //System.out.println("Still working on this! (^_^)");
        //});
        //buttonBar.getChildren().add(btn_EditProfile);
        
        Button btn_Logout = new Button("Log Out");
        btn_Logout.setOnAction((event) ->{
            machine.popState();
        });
        buttonBar.getChildren().add(btn_Logout);
        
        root.setTop(buttonBar);
        root.setCenter(states.peek().getGUI(this));
        return root;
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
