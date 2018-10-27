/*******************************************************************
*   LoginState.java
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
import Model.Item;
import Model.ItemManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Specific State to handle the editing of purchasable items
 * 
 */
public class EditItemsState implements State{
    ObservableList<Item> items;
    
    public EditItemsState(){
        items = FXCollections.observableArrayList();
        items.setAll(ItemManager.get().getItems());
    }
    
    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        
        VBox itemBox = new VBox();
        itemBox.setPadding(new Insets(5));
        itemBox.setSpacing(5);        
        
        ListView<Item> lst_Items = new ListView(items);        
        lst_Items.getSelectionModel().select(0);
        lst_Items.getSelectionModel().selectedItemProperty().addListener((observer, oldValue, newValue) ->{
            if(newValue != null){
                pane.setCenter(ItemDetails(newValue));
            }
        });
        
        itemBox.getChildren().add(lst_Items);
        
        HBox buttonBar = new HBox();
        buttonBar.setPadding(new Insets(5));
        buttonBar.setSpacing(5);
        
        Button btn_AddItem = new Button("Add Item");
        btn_AddItem.setOnAction((event) -> {
            
        });
        buttonBar.getChildren().add(btn_AddItem);
        
        Button btn_DeleteItem = new Button("Delete Item");
        btn_DeleteItem.setOnAction((event) -> {
            
        });
        buttonBar.getChildren().add(btn_DeleteItem);
        
        Button btn_Back = new Button("Return to Management");
        btn_Back.setOnAction((event) -> {
            machine.popState();
        });
        buttonBar.getChildren().add(btn_Back);
        
        pane.setLeft(itemBox);
        pane.setCenter(ItemDetails(lst_Items.getSelectionModel().getSelectedItem()));
        pane.setBottom(buttonBar);
        return pane;
    }
    
    public Node ItemDetails(Item item){
        BorderPane detailPane = new BorderPane();
        
        HBox detailBox = new HBox();
        detailBox.setPadding(new Insets(5));
        detailBox.setSpacing(5);
        
        TextField detailName = new TextField();
        detailName.setText(item.getName());
        detailName.textProperty().addListener((observer, oldValue, newValue) -> {
            item.setName(newValue);
        });
        
        CurrencyField detailPrice = new CurrencyField();
        detailPrice.setText(String.format("$%3.2f", item.getPrice()));
        detailPrice.textProperty().addListener((observer, oldValue, newValue) -> {
            if (newValue.matches("[$]?[0-9]{0,3}([.][0-9]{0,2})?")){
                detailPrice.setText(newValue);
                item.setPrice(Item.stringToDouble(newValue));
                items.setAll(ItemManager.get().getItems());
            } else {
                detailPrice.setText(oldValue);
            }            
        });

        detailBox.getChildren().addAll(detailName, detailPrice);
        
        detailPane.setCenter(detailBox);
        
        return detailPane;
    }
}
