/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateMachine;

import javafx.scene.Node;

/**
 *
 * @author Bernard
 */
public interface FSM {      
    public void pushState(State state);
    public void popState();
    public Node getGUI();
}
