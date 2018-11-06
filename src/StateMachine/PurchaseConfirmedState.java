/*******************************************************************
*   PurchaseConfirmedState.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package StateMachine;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Specific implementation of State which confirms a purchase
 * 
 */
public class PurchaseConfirmedState implements State{

    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        
        VBox body = new VBox();
        body.setPadding(new Insets(5));
        body.setSpacing(5);
        
        String confirmStr = "Thank you for pretending to purchase pretend items"
                + " from a pretend store.  \nYour purchase has been confirmed.";
        Label lbl_PurchaseConfirmed = new Label(confirmStr);
        body.getChildren().add(lbl_PurchaseConfirmed);
        
        Button btn_AnotherPurchase = new Button("Make Another Purchase");
        btn_AnotherPurchase.setOnAction((event) ->{
            machine.reset();
        });
        body.getChildren().add(btn_AnotherPurchase);
        
        pane.setCenter(body);
        return pane;
    }
    
}
