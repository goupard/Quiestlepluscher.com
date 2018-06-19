package com.example.armand.quiestlepluscher.sqlite.entities;

import java.util.Date;

/**
 * Created by ulyss on 12/06/2018.
 */

public class Enregistrement {

    private long id_enregistrement;
    private Date date;
    private int prix;
    private int fk_produit;
    private int fk_utilisateur;

    public Enregistrement() {
    }

    public Enregistrement(int id_enregistrement, Date date, int prix, int fk_produit, int fk_utilisateur) {
        this.id_enregistrement = id_enregistrement;
        this.date = date;
        this.prix = prix;
        this.fk_produit = fk_produit;
        this.fk_utilisateur = fk_utilisateur;
    }

    public long getId_enregistrement() {
        return id_enregistrement;
    }

    public void setId_enregistrement(long id_enregistrement) {
        this.id_enregistrement = id_enregistrement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getFk_produit() {
        return fk_produit;
    }

    public void setFk_produit(int fk_produit) {
        this.fk_produit = fk_produit;
    }

    public int getFk_utilisateur() {
        return fk_utilisateur;
    }

    public void setFk_utilisateur(int fk_utilisateur) {
        this.fk_utilisateur = fk_utilisateur;
    }
}
