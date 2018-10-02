/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateMachine;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Bernard
 */
public class StartState implements State{
    
    @Override
    public Node getGUI(FSM machine){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        
        VBox buttonStack = new VBox();
        buttonStack.setAlignment(Pos.CENTER);
        buttonStack.setSpacing(10);
        
        Button btn_BrowseMenu = new Button("Browse Menu");
        btn_BrowseMenu.setOnAction((event) -> {
            machine.pushState(new BrowseState());
        });
        
        Button btn_Login = new Button("Log in");
        btn_Login.setOnAction((event) -> {
            machine.pushState(new LoginState());
        });
        buttonStack.getChildren().addAll(btn_BrowseMenu, btn_Login);
        
        pane.getChildren().add(buttonStack);
        
        return pane;
    }
    
    @Override
    public String toString(){
        return "Start State";
    }
}