package tn.esprit.pidev.gui;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
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


public class EvaluationCard extends Pane {
    
    @FXML
    private Label dataLabel;
 
    private Evaluation evaluation;
    
    public EvaluationCard(Evaluation evaluation) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/EvaluationCard.fxml"));
        try {
            loader.setController(this);
            loader.load();
            System.out.println("FXML file loaded successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.evaluation = evaluation;
        initialize();
    }

    private void initialize() {
        setData(evaluation);
    }

    private void showDetails() {
        // Add code to show the evaluation details
    }

    public void setData(Evaluation evaluation) {
        this.evaluation = evaluation;
        dataLabel.setText("Date: " + evaluation.getDate() + " | Comment: " + evaluation.getCommentaire()
                + " | Experience: " + evaluation.getExperience() + " | Level: " + evaluation.getLevel());
    }

}

