/*******************************************************************
*   FSM.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package StateMachine;

import javafx.scene.Node;

/**
 * Finite State Machine Interface
 */
public interface FSM {
    /**
     * Adds a state to an internal stack of states
     * @param state the state to add
     */
    public void pushState(State state);
    
    /**
     * Remove a state from an internal stack of states
     */
    public void popState();
    
    /**
     * Returns the GUI of the state at the top of the stack
     * @return a javafx GUI Node
     */
    public Node getGUI();
    
    /**
     * Removes all states except for the initial state
     */
    public void reset();
}
