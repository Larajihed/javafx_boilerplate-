/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pidev.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.esprit.pidev.entities.Person;
import tn.esprit.pidev.services.ServicePerson;

/**
 * FXML Controller class
 *
 * @author FGH
 */
public class AjouterPersonFXMLController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfAge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void restFields(ActionEvent event) {
        tfNom.setText("");
        tfPrenom.setText("");
        tfAge.setText("");
    }

    @FXML
    private void afficherListPersons(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/AfficherListPersonFXML.fxml"));
            Parent root = loader.load();
            AfficherListPersonFXMLController alpController = loader.getController();
            
            ServicePerson sp = new ServicePerson();
            String listP = sp.selectAll().toString();
            
            alpController.setLbAffiche(listP);
            
            Scene scene = new Scene(root, 300, 250);
            
            Stage st = new Stage();
            st.setTitle("Affichage des personnes");
            st.setScene(scene);
            st.show();
            
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    private void ajouterPerson(ActionEvent event) {
        if (tfNom.getText().isEmpty() || tfPrenom.getText().isEmpty() || tfAge.getText().isEmpty()) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Controle de saisie");
            al.setContentText("Veuillez remplir tout les champs !!");
            al.show();
        }else{
            try {
                Person p = new Person(Integer.parseInt(tfAge.getText()), tfNom.getText(), tfPrenom.getText());
                
                ServicePerson sp = new ServicePerson();
                
                sp.insertOne(p);
                
                Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                al.setTitle("person ajouté");
                al.setContentText("La person est ajouté avec success !!");
                al.show();
                
            } catch (NumberFormatException e) {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setTitle("Controle de saisie");
                al.setContentText("Le champ age doit etre numerique !!");
                al.show();
            } catch (SQLException ex) {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setTitle("Controle de saisie");
                al.setContentText(ex.getMessage());
                al.show();
            }
        }
    }
    
}
