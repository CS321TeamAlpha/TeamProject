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

import GUI.CurrencyField;
import Model.ItemBase;
import Model.Order;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

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
        HBox purchaseHeader = new HBox();
        Label lbl_PurchaseHeader = new Label();
        VBox orderBox = new VBox();
        HBox totalBox = new HBox();
        ScrollPane scroll = new ScrollPane();
        TextField fld_Total = new TextField("Total");
        CurrencyField fld_TotalPrice = new CurrencyField();
        HBox buttonBar = new HBox();
        Button btn_Purchase = new Button("Purchase");
        Button btn_Back = new Button("Continue Shopping");
        
        pane.setPadding(new Insets(5));
        pane.setTop(purchaseHeader);
        pane.setCenter(scroll);        
        pane.setBottom(buttonBar);
        
        purchaseHeader.setAlignment(Pos.CENTER); 
        purchaseHeader.getChildren().add(lbl_PurchaseHeader);     
        
        String purchaseStr = "Purchase for " +
                order.getPurchaser().getName() + " at " +
                order.getStore().getName() + ":";        
        lbl_PurchaseHeader.setText(purchaseStr);
        
        //edit 10.30
        scroll.setContent(orderBox);
        orderBox.setPadding(new Insets(5));
        orderBox.setSpacing(5);

        
        for(ItemBase item : order.getItems()){
            HBox itemEntry = new HBox();
            itemEntry.setSpacing(5);

            //edited on 10.30
            TextArea fld_Name = new TextArea(item.getName_multiLine());
            fld_Name.setPrefWidth(400);
            fld_Name.setEditable(false);
            itemEntry.getChildren().add(fld_Name);

            CurrencyField fld_Price = new CurrencyField();
            fld_Price.setPrefWidth(100);
            fld_Price.setEditable(false);
            fld_Price.setValue(item.getPrice());
            itemEntry.getChildren().add(fld_Price);

            Button btn_Remove = new Button("X");
            btn_Remove.setOnAction((event) ->{
                order.removeItem(item);
                orderBox.getChildren().remove(itemEntry);
                fld_TotalPrice.setValue(calculateTotal());
            });
            itemEntry.getChildren().add(btn_Remove);
            orderBox.getChildren().add(itemEntry);
        }
        orderBox.getChildren().add(totalBox);
        
        totalBox.setSpacing(5);        
        totalBox.getChildren().add(fld_Total);
        totalBox.getChildren().add(fld_TotalPrice);
        
        fld_Total.setPrefWidth(400);
        fld_Total.setEditable(false);
        
        fld_TotalPrice.setPrefWidth(100);
        fld_TotalPrice.setEditable(false);
        fld_TotalPrice.setValue(calculateTotal());
        
        buttonBar.setPadding(new Insets(5));
        buttonBar.setSpacing(5);
        buttonBar.getChildren().add(btn_Purchase);        
        buttonBar.getChildren().add(btn_Back);
        
        btn_Purchase.setOnAction((event) -> {
            if(!order.getItems().isEmpty()){
                order.purchaseOrder();
                machine.pushState(new PurchaseConfirmedState());
            } else {
                lbl_PurchaseHeader.setTextFill(Paint.valueOf("#FF0000"));
                lbl_PurchaseHeader.setText("Your order is empty!");
            }            
        });        
        
        btn_Back.setOnAction((event) -> {
            machine.popState();
        });

        return pane;
    }
    
    private double calculateTotal(){
        double t = 0.0;
        for (ItemBase item: order.getItems()){
            t += item.getPrice();
        }
        return t;
    }
}
