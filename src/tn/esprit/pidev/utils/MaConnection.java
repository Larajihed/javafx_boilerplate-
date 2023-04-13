/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pidev.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FGH
 */
public class MaConnection {
    
    private final String url = "jdbc:mysql://localhost:3306/pidev";
    private final String login = "root";
    private final String password = "";
    
    private Connection cnx;

    //2 STEP
    private static MaConnection instance;
    
    //1 STEP
    private MaConnection() {
        try {
            cnx = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion etablie !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    //3 STEP
    public static MaConnection getInstance(){
        if (instance == null) {
            instance = new MaConnection();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
