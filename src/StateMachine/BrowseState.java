/*******************************************************************
*   BrowseState.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package StateMachine;

import Model.Account;
import Model.DrinkSize;
import Model.ItemBase;
import Model.MenuItem;
import Model.MenuOption;
import Model.Order;
import Model.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * A specific implementation of State to browse a list of items
 * 
 */
public class BrowseState implements State{
    ObservableList<MenuItem> items;
    Store store;
    Order order;
    
    public BrowseState(Account account, Store store){
        items = FXCollections.observableArrayList();
        this.store = store;
        order = new Order(account, store);
    }
    
    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        
        Label lbl_Store = new Label ("Store: " + store.getName());
        
        VBox menuBox = new VBox();
        menuBox.setPadding(new Insets(5));
        menuBox.setSpacing(5);        
        
        ListView<MenuItem> lst_Items = new ListView(items);
    
        items.setAll(store.getActiveMenuItems());
        
        lst_Items.getSelectionModel().select(0);
        lst_Items.getSelectionModel().selectedItemProperty().addListener((observer, oldValue, newValue) ->{
            if(newValue != null){
                pane.setCenter(ItemDetails(newValue));
            }
        });
        
        menuBox.getChildren().add(lst_Items);
              
        HBox buttonBar = new HBox();
        buttonBar.setPadding(new Insets(5));
        buttonBar.setSpacing(5);
        
        Button btn_ViewOrder = new Button("View Order");
        btn_ViewOrder.setOnAction((event) -> {
            machine.pushState(new CartViewState(order));
        });
        buttonBar.getChildren().add(btn_ViewOrder);
        
        Button btn_Back = new Button("Change Store");
        btn_Back.setOnAction((event) -> {
            machine.popState();
        });
        buttonBar.getChildren().add(btn_Back);
        
        pane.setTop(lbl_Store);
        pane.setLeft(menuBox);
        pane.setCenter(ItemDetails(lst_Items.getSelectionModel().getSelectedItem()));
        pane.setBottom(buttonBar);
        
        return pane;
    }
    
    public Node ItemDetails(MenuItem item){
        BorderPane detailPane = new BorderPane();
        VBox detailBox = new VBox();
        detailBox.setSpacing(5);
        
        Label lbl_Item = new Label(item.toString());

        HBox sizeBox = new HBox();
        sizeBox.setPadding(new Insets(5));
        sizeBox.setSpacing(5);
        detailBox.getChildren().add(sizeBox);
        
        Label sizeLabel = new Label("Size: ");
        sizeLabel.setPrefHeight(25);
        sizeLabel.setAlignment(Pos.CENTER);
        
        ObservableList<DrinkSize> sizeList = FXCollections.observableArrayList(DrinkSize.values());
        ComboBox<DrinkSize> sizeSelector = new ComboBox(sizeList);
        sizeSelector.setValue(item.getSize());
        sizeSelector.getSelectionModel().selectedItemProperty().addListener((observer, oldValue, newValue) ->{
            item.setDrinkSize(newValue);
        });
        
        sizeBox.getChildren().addAll(sizeLabel, sizeSelector);
        
        for(MenuOption option : item.getOptions()){            
            CheckBox optionCheck = new CheckBox();
            optionCheck.setText(option.toString());
            optionCheck.setSelected(false);
            optionCheck.selectedProperty().addListener((observer, oldValue, newValue) ->{
               option.select(newValue);
            });

            detailBox.getChildren().add(optionCheck);
            if (!option.isAvailable()){
                optionCheck.setText(option.toString() + "-Out of Stock");
                optionCheck.setDisable(true);
            }
        }
        
        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(5));
        buttonBox.setSpacing(5);
        
        Label lbl_Status = new Label();
        
        Button btn_AddToOrder = new Button("Add to Order");
        btn_AddToOrder.setOnAction((event)->{
            ItemBase newItem = item.buildItem();
            order.addItem(newItem);
            lbl_Status.setText("Added " + newItem.getName() + " to Order.");
        });
        buttonBox.getChildren().addAll(btn_AddToOrder, lbl_Status);
        
        detailPane.setTop(lbl_Item);
        detailPane.setCenter(detailBox);
        detailPane.setBottom(buttonBox);
        
        if(!item.isAvailable()){
            lbl_Item.setText(item.toString() + "-Out of Stock");
            detailPane.setDisable(true);
        }
            
        return detailPane;
    }
}
