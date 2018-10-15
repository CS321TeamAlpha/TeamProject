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

import Model.ItemBase;
import Model.Order;
import Model.OrderManager;
import Utilities.Utilities;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * A specific implementation of State to view a shopping cart
 * 
 */
public class CartViewState implements State{
    private final Order order;
    
    public CartViewState(Order order){
        this.order = order;
    }
    
    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));

        HBox purchaseHeader = new HBox();
        purchaseHeader.setAlignment(Pos.CENTER);
        
        String purchaseStr = "Purchase for " +
                order.getPurchaser() + " at " +
                order.getStore().getName() + ":";
        Label lbl_PurchaseHeader = new Label(purchaseStr);
        purchaseHeader.getChildren().add(lbl_PurchaseHeader);
        
        pane.setTop(purchaseHeader);
        
        VBox orderBox = new VBox();
        orderBox.setPadding(new Insets(5));
        orderBox.setSpacing(5);
        for(ItemBase item : order.getItems()){
            orderBox.getChildren().add(buildItemEntry(item));
        }
        pane.setCenter(orderBox);
        
        HBox buttonBar = new HBox();
        buttonBar.setPadding(new Insets(5));
        buttonBar.setSpacing(5);
        
        Button btn_Purchase = new Button("Purchase");
        btn_Purchase.setOnAction((event) -> {
            order.setDate();
            OrderManager.get().add(order);
            machine.pushState(new PurchaseConfirmedState());
        });
        buttonBar.getChildren().add(btn_Purchase);
        
        Button btn_Back = new Button("Continue Shopping");
        btn_Back.setOnAction((event) -> {
            machine.popState();
        });
        buttonBar.getChildren().add(btn_Back);
        
        pane.setBottom(buttonBar);
        
        return pane;
    }
    
    private Node buildItemEntry(ItemBase item){
        HBox itemEntry = new HBox();
        itemEntry.setSpacing(5);
        Label lbl_Name = new Label(item.getName());
        lbl_Name.setPrefWidth(200);
        lbl_Name.setAlignment(Pos.CENTER_LEFT);
        itemEntry.getChildren().add(lbl_Name);
        
        Label lbl_Price = new Label(Utilities.intToCurrencyString(item.getPrice()));
        lbl_Price.setPrefWidth(200);
        lbl_Price.setAlignment(Pos.CENTER_RIGHT);
        itemEntry.getChildren().add(lbl_Price);
        
        Button btn_Remove = new Button("X");
        btn_Remove.setOnAction((event) ->{
            order.removeItem(item);
            lbl_Name.setTextFill(Color.web("#FF0000"));
            lbl_Price.setText(Utilities.intToCurrencyString(0));
            lbl_Price.setTextFill(Color.web("#FF0000"));
        });
        itemEntry.getChildren().add(btn_Remove);
        return itemEntry;
    }
}
