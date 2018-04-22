/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_final;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ddaar
 */
public class Controleur {

    private Modele model;

    public Controleur(Modele model) {
        this.model = model;
    }

    public void afficherPremier() {
        model.premier();
    }

    public void afficherDernier() {
        model.dernier();
    }

    public void afficherSuivant() {
        model.suivant();
    }

    public void afficherPrecedent() {
        model.precedent();
    }

    public void modifierCurent(String a, String b, String c, String d) {
        model.modifier(a, b, c, d);
    }

    public void supprimerCurent() {
        model.supprimer();
    }

    public void saveCurrentRow() {
        model.CurrentRow();
    }
    public void AjouterRow(String a, String b, String c, String d) {
        model.ajouter(a, b, c, d);
    }
    
    public String getCode(){
        return model.getCode();
    }
    
    public String getDesignation(){
        return model.getDesignation();
    }
    
    public String getCodeCategorie(){
        return model.getCodeCategorie();
    }
    
    public String getPrix(){
        return model.getPrix();
    }
    
    public String getMessage(){
        return model.getMessage();
    }
    
    public void annulerAjout(){
        model.annulerAjout();
    }
}
