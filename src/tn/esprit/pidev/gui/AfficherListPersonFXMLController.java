/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pidev.gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import tn.esprit.pidev.services.ServicePerson;

/**
 * FXML Controller class
 *
 * @author FGH
 */
public class AfficherListPersonFXMLController implements Initializable {

    @FXML
    private Label lbAffiche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        ServicePerson sp = new ServicePerson();
//        try {
//            lbAffiche.setText(sp.selectAll().toString());
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
        
    }    

    public String getLbAffiche() {
        return lbAffiche.getText();
    }

    public void setLbAffiche(String value) {
        this.lbAffiche.setText(value);
    }
    
}