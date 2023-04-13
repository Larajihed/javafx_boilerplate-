package tn.esprit.pidev.gui;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.pidev.entities.Competence;
import tn.esprit.pidev.services.ServiceCompetence;
import tn.esprit.pidev.services.ServicePerson;


/**
 * FXML Controller class
 *
 * @author Jihed
 */



public class CompetenceInsertController implements Initializable  {

    @FXML
    private TextField nomField;
    
    @FXML
    private TextField descriptionField;
    
    
      /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void showCompetences(ActionEvent event) {
    try {
        System.out.println("working here");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/showCompetences.fxml"));
        Parent root = loader.load();
        // Get the ListView from the FXML file
        ListView<Competence> listView = (ListView<Competence>) root.lookup("#competencesList");
        // Retrieve the list of competences
        ServiceCompetence cp = new ServiceCompetence();
        List<Competence> competences = cp.selectAll();
        // Set the items of the ListView
        ObservableList<Competence> items = FXCollections.observableArrayList(competences);
        listView.setItems(items);
        Scene scene = new Scene(root);
        Stage st = new Stage();
        st.setTitle("Liste des Competences");
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

    @FXML
    private void handleInsert(ActionEvent event) {
        
         String nom = nomField.getText();
    String description = descriptionField.getText();
        
     if (nom.isEmpty()) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Controle de saisie");
            al.setContentText("Veuillez remplir tout les champs !!");
            al.show();
            return;
        }    
   
    ServiceCompetence cp = new ServiceCompetence();

    Competence newCompetence = new Competence(nom, description);
    
    try {
        cp.insertOne(newCompetence);
        System.out.println("Competence inserted: " + newCompetence);
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erreur lors de l'insertion de la competence");
    }

}

    
    
  

}
