/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_final;

import java.sql.*;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ddaar
 */
public class Modele extends Observable {
    
    private Statement statement;
    private ResultSet result;
    private Utilitaire utilitaire = null;
    private final String my_query;
    private String message;

    public String getMessage() {
        return message;
    }
    
    
    Modele() throws SQLException {
        this.my_query = "SELECT * FROM ARTICLE";
        this.utilitaire = new Utilitaire("jdbc:derby://localhost:1527/evaluation", "niki", "niki");
        this.utilitaire.connection_();
        setStatement(utilitaire.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));
    }
    
   
    
    public Statement getStatement() {
        return statement;
    }
    
    public void setStatement(Statement statement) {
        this.statement = statement;
    }
    
    public ResultSet getResult() {
        return result;
    }
    
    public void setResult(ResultSet result) {
        this.result = result;
    }
    
    public Utilitaire getUtilitaire(){
        return utilitaire;
    }
    
    public String getCode(){
        try {
            return result.getString(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    public String getDesignation(){
        try {
            return result.getString(2);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    public String getCodeCategorie(){
        try {
            return result.getString(3);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    public String getPrix(){
        try {
            return result.getString(4);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    
    public void select_query() throws SQLException {
        result = statement.executeQuery(my_query);
    }
    
    public void suivant() {
        try {            
            if (result.next()) {
               message = "";
            } else {
                result.last();
               message = "Dernier enregistrement";
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        setChanged();
        notifyObservers();
    }

    
    public void precedent() {
        try {            
            if (result.previous()) {
               message = "";
            } else {
                result.first();
               message = "Premier enregistrement";
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        setChanged();
        notifyObservers();
    }

    
    public void premier(){
        try {            
            if (result.first()) {
               message = "";
            } else {
                result.first();
               message = "There are no rows in the table";
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        setChanged();
        notifyObservers();
    }
    
    public void dernier(){
        try {            
            if (result.last()) {
               message = "";
            } else {
                result.first();
               message = "There are no rows in the table";
            }
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        setChanged();
        notifyObservers();
    }
    
    public void modifier(String a,String b, String c, String d){
        try {    
            result.moveToCurrentRow();
            result.updateString(1, a);
            result.updateString(2, b);
            result.updateString(3, c);
            result.updateString(4, d);
            
            result.updateRow();
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimer(){
        try {
            result.deleteRow();
        } catch (SQLException ex) {
            Logger.getLogger(Modele.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    
    
    
    
}
