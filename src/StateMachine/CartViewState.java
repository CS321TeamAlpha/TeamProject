/*******************************************************************
*   CartViewState.java
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * A specific implementation of State to view a shopping cart
 * @author bs0084
 */
public class CartViewState implements State{

    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));
        
        HBox buttonBar = new HBox();
        buttonBar.setPadding(new Insets(5));
        buttonBar.setSpacing(5);
        
        Button btn_Purchase = new Button("Purchase");
        btn_Purchase.setOnAction((event) -> {
            machine.pushState(new CartViewState());
        });
        buttonBar.getChildren().add(btn_Purchase);
        
        Button btn_Back = new Button("Back to Browser");
        btn_Back.setOnAction((event) -> {
            machine.popState();
        });
        buttonBar.getChildren().add(btn_Back);
        
        Button btn_Cancel = new Button("Cancel");
        btn_Cancel.setOnAction((event) -> {
            machine.reset();
        });
        buttonBar.getChildren().add(btn_Cancel);
        
        pane.setBottom(buttonBar);
        
        return pane;
    }    
}
