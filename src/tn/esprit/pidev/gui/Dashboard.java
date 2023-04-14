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
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.esprit.pidev.entities.Competence;
import tn.esprit.pidev.entities.Evaluation;
import tn.esprit.pidev.entities.Poste;
import tn.esprit.pidev.services.ServiceCompetence;
import tn.esprit.pidev.services.ServiceEvaluation;
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
        // Set the cell factory to use custom cell rendering
        listView.setCellFactory(param -> new CompetenceCell());
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/showPostes.fxml"));
        Parent root = loader.load();
        
        ListView<Poste> listView = (ListView<Poste>) root.lookup("#PostesList");
        ServicePoste cp = new ServicePoste();
        List<Poste> postes = cp.selectAll();
        
        listView.setCellFactory(param -> new ListCell<Poste>() {
            @Override
            protected void updateItem(Poste poste, boolean empty) {
                super.updateItem(poste, empty);
                
                if (empty || poste == null) {
                    setText(null);
                } else {
                    String text = String.format("%s\n%s\n%s\n%s - %s\nCompétences: %s",
                            poste.getNom(), poste.getMissions(), poste.getDescription(), 
                            poste.getSalaireMin(), poste.getSalaireMax(), poste.getCompetences());
                    setText(text);
                }
            }
        });
        
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/showEvaluations.fxml"));
        Parent root = loader.load();
        // Get the ListView from the FXML file
        ListView<Evaluation> listView = (ListView<Evaluation>) root.lookup("#evaluationsList");
        // Retrieve the list of competences
        ServiceEvaluation se = new ServiceEvaluation();
        List<Evaluation> evaluations = se.selectAll();
        // Set the items of the ListView
        ObservableList<Evaluation> items = FXCollections.observableArrayList(evaluations);
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

    
    public class CompetenceCell extends ListCell<Competence> {
    
    @Override
    protected void updateItem(Competence competence, boolean empty) {
        super.updateItem(competence, empty);
        
        if (empty || competence == null) {
            setText(null);
            setGraphic(null);
        } else {
            VBox vbox = new VBox();
            vbox.setSpacing(5);
            
            Label nomLabel = new Label("Nom: " + competence.getNom());
            Label descriptionLabel = new Label("Description: " + competence.getDescription());
            
            vbox.getChildren().addAll(nomLabel, descriptionLabel);
            setGraphic(vbox);
        }
    }
    
}
    
}
