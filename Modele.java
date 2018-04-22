/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_final;

import java.sql.*;
import java.util.Observable;


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
    int currRow = 0;

    public int getCurrRow() {
        return currRow;
    }
    
    

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

    public Utilitaire getUtilitaire() {
        return utilitaire;
    }

    public String getCode() {
        try {
            return result.getString(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    public String getDesignation() {
        try {
            return result.getString(2);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    public String getCodeCategorie() {
        try {
            return result.getString(3);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    public String getPrix() {
        try {
            return result.getString(4);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "";
        }
    }

    public void select_query() {
        try {
            result = statement.executeQuery(my_query);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
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

    public void premier() {
        try {

            if (result.isFirst()) {
                message = "Premier enregistrement";
            } else {
                result.first();
                message = "";
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        setChanged();
        notifyObservers();
    }

    public void dernier() {
        try {
            if (result.isLast()) {
                message = "Dernier enregistrement";
            } else {
                result.last();
                message = "";
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        setChanged();
        notifyObservers();
    }

    public void modifier(String a, String b, String c, String d) {
        try {
            result.moveToCurrentRow();

            result.updateString(1, a);
            result.updateString(2, b);
            result.updateString(3, c);
            result.updateDouble(4, Double.parseDouble(d));

            result.updateRow();
            message = "La modification etait effectue";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        setChanged();
        notifyObservers();
    }

    public void supprimer() {
        try {
            result.deleteRow();
            result.close();
            
            select_query();
            premier();
            
            message = "La suppression etait effectue";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        setChanged();
        notifyObservers();
    }
    public void CurrentRow(){
        try {
            currRow = result.getRow();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
     public void ajouter(String a, String b, String c, String d){
        try {
            result.moveToInsertRow();
            
            result.updateString("CODE", a);
            result.updateString("DESIGNATION", b);
            result.updateString("CODE_CATEGORIE", c);
            result.updateDouble("PRIX", Double.parseDouble(d));
            
            result.insertRow();

            select_query();
            premier();
            
            message = "L'ajout etait effectue";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        setChanged();
        notifyObservers();
    }
     
    public void annulerAjout(){
        try {
            result.absolute(currRow);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        setChanged();
        notifyObservers();
    }

}
