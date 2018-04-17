/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_final;

import java.sql.SQLException;

/**
 *
 * @author ddaar
 */
public class Controleur {

    private Modele model;
    private Interface_db inetrfaca_db;

    public Controleur(Modele model, Interface_db inetrfaca_db) {
        this.model = model;
        this.inetrfaca_db = inetrfaca_db;

    }

    void updateView() throws SQLException {
        //inetrfaca_db.actualiserTextbox(model.getResult().getString("CODE"), model.getResult().getString("DESIGNATION"), model.getResult().getString("CODE_CATEGORIE"), Double.toString(model.getResult().getDouble("PRIX")));

    }

    void afficherPremier() throws SQLException {
        model.select_query();
        model.getResult().first();
        //inetrfaca_db.actualiserTextbox(model.getResult().getString("CODE"), model.getResult().getString("DESIGNATION"), model.getResult().getString("CODE_CATEGORIE"), Double.toString(model.getResult().getDouble("PRIX")));
    }

}
