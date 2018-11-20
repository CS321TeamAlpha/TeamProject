/*******************************************************************
*   ManagerLoggedInState.java
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * A specific implementation of State to provide access to manager level options
 * in maintaining the system.  It is also an internal State Machine
 * 
 */
public class ManagerLoggedInState implements State, FSM{
    private final Stack<State> states = new Stack();
    private final BorderPane root = new BorderPane();
    
    /**
     * Constructor which ties a Manager Account to the State
     * @param account The Manager Account used to log in to the system
     */
    public ManagerLoggedInState(Account account){
        states.push(new ManagerMenuState(account));
    }
    
    /**
     * Creates the GUI for this State
     * @param machine the State Machine handling this State
     * @return a javaFX node (any GUI component)
     */
    @Override
    public Node getGUI(FSM machine) {
        HBox buttonBar = new HBox();
        buttonBar.setSpacing(5);
        buttonBar.setAlignment(Pos.CENTER_RIGHT);
        buttonBar.setPadding(new Insets(5));
        
//        Button btn_Shutdown = new Button("Shutdown");
//        btn_Shutdown.setOnAction((event) ->{
//            System.out.println("Still working on this! (^_^)");
//        });
//        buttonBar.getChildren().add(btn_Shutdown);
//        
//        Button btn_EditProfile = new Button("Edit Profile");
//        btn_EditProfile.setOnAction((event) ->{
//            System.out.println("Still working on this! (^_^)");
//        });
//        buttonBar.getChildren().add(btn_EditProfile);
        
        Button btn_Logout = new Button("Log Out");
        btn_Logout.setOnAction((event) ->{
            machine.popState();
        });
        buttonBar.getChildren().add(btn_Logout);
        
        root.setTop(buttonBar);
        root.setCenter(states.peek().getGUI(this));
        return root;
    }
    
    /**
     * Adds a state to an internal stack of states
     * @param state the state to add
     */
    @Override
    public void pushState(State state){
        states.push(state);
        root.setCenter(getGUI());
    }
    
    /**
     * Remove a state from an internal stack of states
     */
    @Override
    public void popState(){
        states.pop();
        root.setCenter(getGUI());  
    }
    
    /**
     * Returns the GUI of the state at the top of the stack
     * @return a javafx GUI Node
     */
    @Override
    public Node getGUI(){
        return states.peek().getGUI(this);
    }
    
    /**
     * Removes all states except for the initial state
     */
    @Override
    public void reset(){
        while(states.size() > 1){
            states.pop();
        }
        root.setCenter(getGUI());
    }
}
