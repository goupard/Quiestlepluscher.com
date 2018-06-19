package com.example.armand.quiestlepluscher.sqlite.entities;

/**
 * Created by ulyss on 12/06/2018.
 */

public class Type {
    private long id_type;
    private String nom_type;
    private String description;
    private int fk_categorie;

    public Type() {
    }

    public Type(int id_type, String nom_type, String description, int fk_categorie) {
        this.id_type = id_type;
        this.nom_type = nom_type;
        this.description = description;
        this.fk_categorie = fk_categorie;
    }

    public long getId_type() {
        return id_type;
    }

    public void setId_type(long id_type) {
        this.id_type = id_type;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFk_categorie() {
        return fk_categorie;
    }

    public void setFk_categorie(int fk_categorie) {
        this.fk_categorie = fk_categorie;
    }
}
