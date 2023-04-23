package tn.esprit.pidev.gui;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import tn.esprit.pidev.gui.CompetenceDetails;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tn.esprit.pidev.entities.Competence;
import tn.esprit.pidev.entities.Evaluation;
import tn.esprit.pidev.entities.Poste;
import tn.esprit.pidev.services.ServiceCompetence;
import tn.esprit.pidev.services.ServiceEvaluation;
import tn.esprit.pidev.services.ServicePerson;
import tn.esprit.pidev.services.ServicePoste;


/**
 * FXML Controller class
 *
 * @author Jihed
 */



public class showEvaluations implements Initializable  {

    @FXML
    private TextField nomField;
    
    @FXML
    private TextField descriptionField;

    @FXML
    private ListView<Evaluation> evaluationsList;

      /**
     * Initializes the controller class.
     */
    
    
    // Create a new KeyCodeCombination for the "Ctrl + S" shortcut

// Add a listener to the scene to detect when the shortcut is pressed

    
      
    @FXML
    private DatePicker dateFromPicker;

    @FXML
    private DatePicker dateToPicker;

    // ...

    @FXML
    private void filterEvaluations(ActionEvent event) throws SQLException {
        ServiceEvaluation se = new ServiceEvaluation();
        LocalDate fromDate = dateFromPicker.getValue();
        LocalDate toDate = dateToPicker.getValue();
        if (fromDate != null && toDate != null) {
            List<Evaluation> filteredEvaluations = se.selectByDate(fromDate, toDate);
            ObservableList<Evaluation> items = FXCollections.observableArrayList(filteredEvaluations);
            evaluationsList.setItems(items);
        }   
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  
       evaluationsList.setOnMouseClicked(event -> {
    try {
        handleCompetenceClick(event);
    } catch (IOException ex) {
        System.err.println(ex.getMessage());
        ex.printStackTrace();
    }
    
     // Create a KeyCodeCombination for the "N" shortcut
    KeyCodeCombination nShortcut = new KeyCodeCombination(KeyCode.N,KeyCombination.CONTROL_DOWN);

      // Add a listener to the scene to detect when the "N" key is pressed
    Scene scene = evaluationsList.getScene();
    scene.setOnKeyPressed(keyEvent -> {
        if (nShortcut.match(keyEvent)) {
            // Call the showAddPoste() method when the "N" key is pressed
            showAddPosteUsingShortcut();
            keyEvent.consume(); // Prevent the event from being processed further
        }
    });
});

    }    

    @FXML
private void handleCompetenceClick(MouseEvent event) throws IOException {

}

    
    @FXML
    private void showAddPoste(ActionEvent event) {
        
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/evaluationInsert.fxml"));
        Parent root = loader.load();
        // Get the ListView from the FXML file
        ServicePoste sp = new ServicePoste();
        List<Poste> postes = sp.selectAll();
        
    
        
        Scene scene = new Scene(root);
        Stage st = new Stage();
        st.setTitle("Liste des postes");
        st.setScene(scene);
        st.show();
    } catch (IOException ex) {
        System.err.println(ex.getMessage());
        ex.printStackTrace();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
        ex.printStackTrace();
    }

}

    private void showAddPoste() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void showAddPosteUsingShortcut() {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/evaluationInsert.fxml"));
        Parent root = loader.load();
        // Get the ListView from the FXML file
        ServicePoste sp = new ServicePoste();
        List<Poste> postes = sp.selectAll();
        
    
        
        Scene scene = new Scene(root);
        Stage st = new Stage();
        st.setTitle("Liste des postes");
        st.setScene(scene);
        st.show();
    } catch (IOException ex) {
        System.err.println(ex.getMessage());
        ex.printStackTrace();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
        ex.printStackTrace();
    }
        
        
    }
    
    


}
