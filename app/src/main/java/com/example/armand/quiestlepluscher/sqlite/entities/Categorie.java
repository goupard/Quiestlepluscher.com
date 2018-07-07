package com.example.armand.quiestlepluscher.sqlite.entities;

import java.io.Serializable;

/**
 * Created by ulyss on 12/06/2018.
 */

public class Categorie  implements Serializable {

    private long id_categorie;
    private String nom_categorie;
    private String description;

    public Categorie() {
    }

    public Categorie(int id_categorie, String nom_categorie, String description) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.description = description;
    }

    public long getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(long id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
