/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Bernard
 */
public class StartScreen extends GridPane{    
    
    public StartScreen(){
        Initialize();
    }
    
    private void Initialize(){
        this.setAlignment(Pos.CENTER);
        
        VBox buttonStack = new VBox();
        buttonStack.setAlignment(Pos.CENTER);
        buttonStack.setSpacing(10);
        
        Button btn_BrowseMenu = new Button("Browse Menu");
        Button btn_Login = new Button("Log in");
        
        buttonStack.getChildren().addAll(btn_BrowseMenu, btn_Login);
        
        this.getChildren().add(buttonStack);
    }
}
