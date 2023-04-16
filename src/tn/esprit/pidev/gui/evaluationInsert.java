package tn.esprit.pidev.gui;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.pidev.entities.Employee;
import tn.esprit.pidev.entities.Evaluation;
import tn.esprit.pidev.entities.Poste;
import tn.esprit.pidev.services.ServiceEvaluation;
//import your.package.name.UserService;

public class evaluationInsert implements Initializable {

    @FXML
    private TextField dateField;

    @FXML
    private TextField experienceField;

    @FXML
    private TextArea commentaireArea;

    @FXML
    private TextField levelField;

    @FXML
    private TextField posteIdField;

    @FXML
    private TextField employeeIdField;

    @FXML
    private Label errorLabel;

    ServiceEvaluation se = new ServiceEvaluation();

    @FXML
    private void handleInsert(ActionEvent event) {
        try {
            // Parse input values
            String dateStr = dateField.getText();
            int experience = Integer.parseInt(experienceField.getText());
            String commentaire = commentaireArea.getText();
            String level = levelField.getText();
            int posteId = Integer.parseInt(posteIdField.getText());
            int employeeId = Integer.parseInt(employeeIdField.getText());

            // Create new evaluation object
            Evaluation newEvaluation = new Evaluation();
            newEvaluation.setDate(Date.valueOf(dateStr));
            newEvaluation.setExperience(experience);
            newEvaluation.setCommentaire(commentaire);
            newEvaluation.setLevel(level);
            newEvaluation.setPoste(new Poste(posteId));
            newEvaluation.setEmployee(new Employee(employeeId));

            // Insert new evaluation into the database
            se.insertEvaluation(newEvaluation,5);

            // Show success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Évaluation ajoutée");
            alert.setContentText("L'évaluation a été ajoutée avec succès.");
            alert.showAndWait();

            // Close the window
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            // Handle invalid input values
            errorLabel.setText("Veuillez saisir des valeurs numériques valides pour les champs Expérience, Poste ID et Employee ID.");
        } catch (SQLException e) {
            // Handle database errors
            errorLabel.setText("Erreur lors de l'insertion de l'évaluation.");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
