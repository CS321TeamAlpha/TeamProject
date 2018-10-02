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

import StateMachine.FSM;
import StateMachine.StartState;
import StateMachine.State;
import java.util.Stack;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * A Kiosk Simulator
 * @author Bernard
 */
public class CafeKiosk extends Application implements FSM {
    private final Stack<State> states = new Stack();
    private final StackPane root = new StackPane();
    
    @Override
    public void start(Stage primaryStage) {
        pushState(new StartState());
               
        root.getChildren().add(getGUI());
        
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Cafe Kiosk");
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
        root.getChildren().clear();
        root.getChildren().add(getGUI());
    }
    
    @Override
    public void popState(){
        states.pop();
        root.getChildren().clear();
        root.getChildren().add(getGUI());       
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
        root.getChildren().clear();
        root.getChildren().add(getGUI());
    }
}
