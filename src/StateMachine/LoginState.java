/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateMachine;

import GUI.IntField;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Bernard
 */
public class LoginState implements State{
   
    @Override
    public Node getGUI(FSM machine) {
        GridPane pane = new GridPane();
        Label lbl_PinNumber = new Label("PIN Number:");
        IntField fld_PinNumber = new IntField();
        Button btn_Login = new Button("Log In");
        btn_Login.setOnAction((event) -> {
            //machine.pushState(new ManagerState());
        });
        Button btn_Cancel = new Button("Cancel");
        btn_Cancel.setOnAction((event) -> {
            machine.popState();
        });
        
        pane.add(lbl_PinNumber, 0,0);
        pane.add(fld_PinNumber, 1,0);
        pane.add(btn_Login, 0,1);
        pane.add(btn_Cancel, 1,1);
        
        return pane;
    }    
        
    @Override
    public String toString(){
        return "Login State";
    } 
}
