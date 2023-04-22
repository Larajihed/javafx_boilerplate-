package tn.esprit.pidev.gui;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.pidev.entities.Employee;
import tn.esprit.pidev.entities.Evaluation;
import tn.esprit.pidev.entities.Poste;
import tn.esprit.pidev.services.ServiceEmployee;
import tn.esprit.pidev.services.ServiceEvaluation;
import tn.esprit.pidev.services.ServicePoste;
//import your.package.name.UserService;

 public  class evaluationInsert implements Initializable {

    @FXML
private DatePicker datePicker;

    @FXML
    private TextField experienceField;

    @FXML
    private TextArea commentaireArea;


   

    @FXML
    private Label errorLabel;
    
    @FXML
    private ComboBox<Poste> posteComboBox;

   @FXML
    private ComboBox<Employee> employeeComboBox;

   
   @FXML
    private ComboBox<String> levelComboBox;
   
    ServiceEvaluation se = new ServiceEvaluation();

    @FXML
     private void handleInsert(ActionEvent event) {
        Poste selectedPoste = posteComboBox.getValue();
        int posteId = selectedPoste.getId();
        LocalDate selectedDate = datePicker.getValue();
        java.sql.Date date = java.sql.Date.valueOf(selectedDate);     
        String commentaire = commentaireArea.getText();
        String level = levelComboBox.getValue();
        int experience = Integer.parseInt(experienceField.getText());
        int employeeId = employeeComboBox.getValue().getId();

        try {
        

            Evaluation newEvaluation = new Evaluation();
            
newEvaluation.setDate(date);
            newEvaluation.setExperience(experience);
            newEvaluation.setCommentaire(commentaire);
            newEvaluation.setLevel(level);
ServicePoste servicePoste = new ServicePoste();
Poste poste = servicePoste.selectOne(posteId);
newEvaluation.setPoste(poste);


ServiceEmployee serviceEmployee = new ServiceEmployee();
Employee employee = serviceEmployee.selectOne(employeeId);
newEvaluation.setEmployee(employee);



            // Insert new evaluation into the database
            se.insertEvaluation(newEvaluation,5);
System.out.println("new" + employee);

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
           try {
        // Get the list of Postes from the service
        List<Poste> postes = new ServicePoste().selectAll();
        List<Employee> employees = new ServiceEmployee().selectAll();
        List<String> levels = new ArrayList<>();
        levels.add("Stagiaire");
        levels.add("Junior");
        levels.add("Mid-Level");
        levels.add("Senior");
        // Initialize the ComboBox with the list of Postes
posteComboBox.getItems().addAll(postes);
employeeComboBox.getItems().addAll(employees);
levelComboBox.getItems().addAll(levels);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }

}
