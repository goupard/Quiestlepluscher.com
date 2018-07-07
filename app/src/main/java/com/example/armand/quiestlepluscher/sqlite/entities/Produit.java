package com.example.armand.quiestlepluscher.sqlite.entities;

import java.io.Serializable;

/**
 * Created by ulyss on 12/06/2018.
 */

public class Produit implements Serializable {
    private long id_produit;
    private String nom_produit;
    private String num_code_barres;
    private String description;
    private int fk_type;
    private int fk_marque;

    public Produit() {
    }

    public Produit(int id_produit, String nom_produit, String num_code_barres, String description, int fk_type, int fk_marque) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.num_code_barres = num_code_barres;
        this.description = description;
        this.fk_type = fk_type;
        this.fk_marque = fk_marque;
    }

    public long getId_produit() {
        return id_produit;
    }

    public void setId_produit(long id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getNum_code_barres() {
        return num_code_barres;
    }

    public void setNum_code_barres(String num_code_barres) {
        this.num_code_barres = num_code_barres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFk_type() {
        return fk_type;
    }

    public void setFk_type(int fk_type) {
        this.fk_type = fk_type;
    }

    public int getFk_marque() {
        return fk_marque;
    }

    public void setFk_marque(int fk_marque) {
        this.fk_marque = fk_marque;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id_produit=" + id_produit +
                ", nom_produit='" + nom_produit + '\'' +
                ", num_code_barres='" + num_code_barres + '\'' +
                ", description='" + description + '\'' +
                ", fk_type=" + fk_type +
                ", fk_marque=" + fk_marque +
                '}';
    }
}
