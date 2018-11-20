/*******************************************************************
*   EditStoreState.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package StateMachine;

import Model.MenuItem;
import Model.MenuOption;
import Model.Store;
import Model.StoreManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * A State providing edit abilities to Stores and their menus
 */
public class EditStoreState implements State{
    private final ObservableList<Store> storeList;
    /**
     * Constructor which primes the list of Stores to display
     */
    public EditStoreState(){
        storeList = FXCollections.observableArrayList();
        storeList.setAll(StoreManager.get().getItems());
    }
    
    /**
     * Creates the GUI for this State
     * @param machine the State Machine handling this State
     * @return a javaFX node (any GUI component)
     */
    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        Pane listPane = new Pane();
        
        ListView<Store> lst_Stores = new ListView(storeList);
        HBox buttonBar = new HBox();
        Button btn_Return = new Button("Return to Management Menu");
        
        listPane.setPadding(new Insets(5));
        listPane.getChildren().add(lst_Stores);
        
        lst_Stores.setPrefHeight(300);
        lst_Stores.getSelectionModel().select(0);
        lst_Stores.getFocusModel().focus(0);
        lst_Stores.getSelectionModel().selectedItemProperty().addListener((observer, oldValue, newValue) ->{
                if (newValue != null){
                    pane.setCenter(buildDetail(newValue));
                }   
        });
        
        buttonBar.setPadding(new Insets(5));
        buttonBar.setSpacing(5);
        buttonBar.getChildren().add(btn_Return);
        
        btn_Return.setOnAction((event) ->{
            machine.popState();
        });
        
        pane.setLeft(listPane);
        pane.setCenter(buildDetail(storeList.get(0)));
        pane.setBottom(buttonBar);
        
        return pane;
    }
    
    private BorderPane buildDetail(Store selectedStore){
        BorderPane detailPane = new BorderPane();
        detailPane.setPadding(new Insets(5));

        VBox detailHeader = new VBox();
        detailHeader.setSpacing(5);

        TextField fld_StoreName = new TextField(selectedStore.getName());
        fld_StoreName.textProperty().addListener((nameObs, oldName, newName) ->{
            selectedStore.setName(newName);
            storeList.setAll(StoreManager.get().getItems());
        });
        detailHeader.getChildren().add(fld_StoreName);

        VBox itemBox = new VBox();
        itemBox.setSpacing(5);
        itemBox.setPadding(new Insets(5));
        for (MenuItem item : selectedStore.getActiveMenuItems()){
            CheckBox chk_Available = new CheckBox(item.getName());
            chk_Available.setSelected(item.isAvailable());
            chk_Available.setPrefWidth(150);
            chk_Available.selectedProperty().addListener((obs, prevValue, curValue) ->{
                item.setAvailable(curValue);
            });
            itemBox.getChildren().add(chk_Available);
        }

        VBox optionBox = new VBox();
        optionBox.setSpacing(5);
        optionBox.setPadding(new Insets(5));
        for (MenuOption option : selectedStore.getActiveMenuOptions()){
            CheckBox chk_Available = new CheckBox(option.getName());
            chk_Available.setSelected(option.isAvailable());
            chk_Available.setPrefWidth(150);
            chk_Available.selectedProperty().addListener((obs, prevValue, curValue) ->{
                option.setAvailable(curValue);
            });
            optionBox.getChildren().add(chk_Available);
        }
        detailPane.setTop(fld_StoreName);
        detailPane.setLeft(itemBox);
        detailPane.setCenter(optionBox);

        return detailPane;
    }
}
