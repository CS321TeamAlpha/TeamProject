/*******************************************************************
*   FileManager.java
*   CS321 Group Project: Cafe Kiosk
*   Team: Alpha
*       Angela Allison
*       Adam McFry
*       Mitchell Whitehead
*       Bernard Sabatini
*   Date: Oct 2018
*******************************************************************/
package cafekiosk;

import GUI.StartScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Bernard
 */
public class CafeKiosk extends Application {
    
    @Override
    public void start(Stage primaryStage) {    
        StackPane root = new StackPane();
        Pane startScreen = new StartScreen();
        
        root.getChildren().add(startScreen);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Cafe Kiosk");
        primaryStage.setScene(scene);
        primaryStage.show();   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
