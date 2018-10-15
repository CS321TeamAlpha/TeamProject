/*******************************************************************
*   State.java
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
 * An interface for various states of a state machine
 * 
 */
public interface State {
    /**
     * A function to return the javafx GUI component of this state
     * @param machine a reference to the state machine
     * @return a javafx GUI Node
     */
    Node getGUI(FSM machine);
}
