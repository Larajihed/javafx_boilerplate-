/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.pidev.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import tn.esprit.pidev.entities.Competence;
import tn.esprit.pidev.entities.Poste;
import tn.esprit.pidev.services.ServiceCompetence;
import tn.esprit.pidev.services.ServicePoste;

/**
 * @author conta
 */
public class Dashboard  implements Initializable {
    
        private Stage showCompetencesStage;

       @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
   // Navigation 
    
      @FXML
    private void showCompetences(ActionEvent event) {
    try {
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
    private void showPostes(ActionEvent event) {
    try {
        System.out.println("working here");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/showPostes.fxml"));
        Parent root = loader.load();
        // Get the ListView from the FXML file
        ListView<Poste> listView = (ListView<Poste>) root.lookup("#PostesList");
        // Retrieve the list of competences
        ServicePoste cp = new ServicePoste();
        List<Poste> postes = cp.selectAll();
        // Set the items of the ListView
        ObservableList<Poste> items = FXCollections.observableArrayList(postes);
        listView.setItems(items);
        Scene scene = new Scene(root);
        Stage st = new Stage();
        st.setTitle("Liste des Postes");
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
    private void showEvaluations(ActionEvent event) {
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

    
    
    
}
