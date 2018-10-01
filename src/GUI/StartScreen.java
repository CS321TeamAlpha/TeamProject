/*******************************************************************
*   StartScreen.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package GUI;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * A customized extention of a standard javafx GUI.  Used purely for organizing
 * GUI layouts.
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
