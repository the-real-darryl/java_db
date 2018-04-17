/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_final;

import java.sql.*;

/**
 *
 * @author ddaar
 */
//cette classe gere la connexion  a la base de donne
public class Utilitaire {

    Connection connection = null;
    String data_base_path = null;//"jdbc:derby://localhost:1527/evaluation_finale";
    String username =  null;//"darryl";
    String password =  null;//"dd";
    /**
     *
     * @throws SQLException
     */
    Utilitaire(String data_base_path, String username, String password) {
        this.data_base_path = data_base_path;
        this.username = username;
        this.password = password;
    }

    Utilitaire() {
        this.data_base_path = System.in.toString();
        this.username = System.in.toString();
        this.password = System.in.toString();
    }

    public void connection_() throws SQLException {
        connection = DriverManager.getConnection(data_base_path, username, password);
    }

    public void deconnection_() throws SQLException {
        connection.close();
    }
}
