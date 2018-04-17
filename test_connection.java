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
public class test_connection {

    Utilitaire notre_connexion = new Utilitaire("jdbc:derby://localhost:1527/evaluation", "niki", "niki");

    public void read_databes() {
        Statement statement = null;
        ResultSet result = null;

        try {
            notre_connexion.connection_();
            statement = notre_connexion.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String my_query = "select arcticle.code, arcticle.designation, prix, arcticle.code_categorie"
                    + " from arcticle,categorie where arcticle.code_categorie = categorie.code";
            result = statement.executeQuery(my_query);
            while (result.next()) {
                System.out.print("code arcticle : " + result.getString("ARCTICLE.CODE"));
                System.out.print("arctcicle designation : " + result.getString("ARCTICLE.DESIGNATION"));
                System.out.print("prix arcticle : " + result.getString("ARCTICLE.PRIX"));
                System.out.print("code categorie : " + result.getString("ARCTICLE.CODE_CATEGORIE"));
                System.out.println("");

            }
        } catch (SQLException ex) {
            System.out.println("une erreur est survenue !!!!");
            ex.printStackTrace();
        } finally {
            try {
                result.close();
                notre_connexion.deconnection_();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("une erreur est survenue lors de la fermeture!!!!");
                ex.printStackTrace();
            }
        }
    }

    public void insert_data(String code, String designation, String code_categorie, double prix) {
        Statement statement = null;
        ResultSet result = null;

        try {
            notre_connexion.connection_();
            statement = notre_connexion.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String my_query = "select code, designation, prix, code_categorie"
                    + " from arcticle";
            result = statement.executeQuery(my_query);

            result.moveToInsertRow();

            result.updateString("CODE", code);
            result.updateString("DESIGNATION", designation);
            result.updateString("CODE_CATEGORIE", code_categorie);
            result.updateDouble("PRIX", prix);
            result.insertRow();
            for (short i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                System.out.println(result.getMetaData().getColumnType(i));
            }

            //result.insertRow();
        } catch (SQLException ex) {
            System.out.println("une erreur est survenue !!!!");
            ex.printStackTrace();
        } finally {
            try {
                result.close();
                notre_connexion.deconnection_();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("une erreur est survenue lors de la fermeture!!!!");
                ex.printStackTrace();
            }
        }
    }

    public void update_database(String[] column, String[] tables, String where, String[] updatable_field, String[] value) {
        Statement statement = null;
        ResultSet result = null;

        try {
            notre_connexion.connection_();
            statement = notre_connexion.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String my_query = "select ";

            for (short i = 0; i < column.length - 1; i++) {
                my_query += column[i] + ", ";
            }
            my_query += column[column.length - 1] + " from ";

            for (short i = 0; i < tables.length - 1; i++) {
                my_query += tables[i] + ", ";
            }
            my_query += tables[tables.length - 1] + " where ";

            my_query += where;

            result = statement.executeQuery(my_query);
            result.next();
            for (short i = 0; i < updatable_field.length; i++) {
                result.updateString(updatable_field[i], value[i]);
            }
            result.insertRow();
        } catch (SQLException ex) {
            System.out.println("une erreur est survenue !!!!");
            ex.printStackTrace();
        } finally {
            try {
                result.close();
                notre_connexion.deconnection_();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("une erreur est survenue lors de la fermeture!!!!");
                ex.printStackTrace();
            }
        }
    }

    public void delete_row(String[] column, String[] tables, String where) {
        Statement statement = null;
        ResultSet result = null;

        try {
            notre_connexion.connection_();
            statement = notre_connexion.connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String my_query = "select ";

            for (short i = 0; i < column.length - 1; i++) {
                my_query += column[i] + ", ";
            }
            my_query += column[column.length - 1] + " from ";

            for (short i = 0; i < tables.length - 1; i++) {
                my_query += tables[i] + ", ";
            }
            my_query += tables[tables.length - 1] + " where ";

            my_query += where;

            result = statement.executeQuery(my_query);
            result.next();
            result.deleteRow();

        } catch (SQLException ex) {
            System.out.println("une erreur est survenue !!!!");
            ex.printStackTrace();
        } finally {
            try {
                result.close();
                notre_connexion.deconnection_();
                statement.close();
            } catch (SQLException ex) {
                System.out.println("une erreur est survenue lors de la fermeture!!!!");
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws SQLException {
        test_connection une_connection = new test_connection();
        une_connection.insert_data("HAHAHA", "TRAIN", "T1", 10000);
        Modele m = new Modele();

        String[] column = new String[1];
        column[0] = "PRIX";
        String[] valeurs = new String[1];
        valeurs[0] = "2000";
       // m.modification("ARCTICLE", column, valeurs, "PRIX = 1000000");
        //read_databes();
    }
}
