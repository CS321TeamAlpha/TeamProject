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
import Model.MenuItem;
import Model.Order;
import Model.Store;
import Utilities.Utilities;
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
 * A specific implementation of State to browse a list of items
 * 
 */
public class BrowseState implements State{
    //ObservableList<Store> stores;
    ObservableList<MenuItem> items;
    Store store;
    Order order;
    //MenuItem currentItem;
    
    public BrowseState(Account account, Store store){
        //stores = FXCollections.observableArrayList();
        items = FXCollections.observableArrayList();
        this.store = store;
        order = new Order(account, store);
        //currentItem = null;
    }
    
    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        
        VBox menuBox = new VBox();
        menuBox.setPadding(new Insets(5));
        menuBox.setSpacing(5);        
        
//        ComboBox<Store> cbo_Stores = new ComboBox(stores);
        ListView<MenuItem> lst_Items = new ListView(items);
        
//        stores.setAll(StoreManager.get().getItems());
//        
//        cbo_Stores.setValue(stores.get(0));
//        cbo_Stores.getSelectionModel().selectedItemProperty().addListener((observer, oldValue, newValue) ->{
//            items.setAll(newValue.getActiveMenuItems());
//            lst_Items.getSelectionModel().select(0);
//        });
//                
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
        
        pane.setLeft(menuBox);
        pane.setCenter(ItemDetails(lst_Items.getSelectionModel().getSelectedItem()));
        pane.setBottom(buttonBar);
        
        return pane;
    }
    
    public Node ItemDetails(MenuItem item){
        BorderPane detailPane = new BorderPane();
        
        HBox detailBox = new HBox();
        detailBox.setPadding(new Insets(5));
        detailBox.setSpacing(5);
        
        TextField detailName = new TextField();
        detailName.setText(item.getName());
        detailName.setEditable(false);
        
        TextField detailPrice = new TextField();
        detailPrice.setText(Utilities.intToCurrencyString(item.getPrice()));
        detailPrice.setEditable(false);
        
        detailBox.getChildren().addAll(detailName, detailPrice);
        
        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(5));
        buttonBox.setSpacing(5);
        
        Button btn_AddToOrder = new Button("Add to Order");
        btn_AddToOrder.setOnAction((event)->{
            order.addItem(item.getItemBase());
        });
        buttonBox.getChildren().addAll(btn_AddToOrder);
        
        detailPane.setTop(detailBox);
        detailPane.setBottom(buttonBox);
        
        return detailPane;
    }
}
