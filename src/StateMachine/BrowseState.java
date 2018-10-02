/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StateMachine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Bernard
 */
public class BrowseState implements State{

    @Override
    public Node getGUI(FSM machine) {
        BorderPane pane = new BorderPane();
        
        ObservableList<String> products = FXCollections.observableArrayList();
        products.add("Item 1");
        products.add("Item 2");
        products.add("Item 3");
        
        ListView menuList = new ListView(products);
        
        Button btn_Cancel = new Button("Cancel");
        btn_Cancel.setOnAction((event) -> {
            machine.popState();
        });
        
        pane.setLeft(menuList);
        pane.setBottom(btn_Cancel);
        
        return pane;
    }
    
        
    @Override
    public String toString(){
        return "Browse State";
    }
}
