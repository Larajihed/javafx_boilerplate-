package tn.esprit.pidev.tests;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainClass extends Application {
 private Stage primaryStage;

 @Override
    public void start(Stage primaryStage) {
        
          this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Car Manager");

        // Prevent the window resizing
        this.primaryStage.setResizable(false);

        showDashboard();
    }
        public void showDashboard() {
        try {
            // Load login page
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("../gui/Dashboard.fxml"));
            AnchorPane dashboard = (AnchorPane) loader.load();

            // Set the scene containing the login page
            Scene scene = new Scene(dashboard);
            primaryStage.setScene(scene);


            // Show the scene
            primaryStage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    

       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
