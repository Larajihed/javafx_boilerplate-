package tn.esprit.pidev.tests;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/competenceInsert.fxml")) ;
            Scene scene = new Scene(root,1000,500);
            primaryStage.setTitle("JAVAFX WORKSHOP");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
