package com.example.armand.quiestlepluscher.sqlite.entities;

/**
 * Created by ulyss on 12/06/2018.
 */

public class Marque {
    private long id_marque;
    private String nom_marque;
    private String loc_logo;
    private String description;

    public Marque() {
    }

    public Marque(int id_marque, String nom_marque, String loc_logo, String description) {
        this.id_marque = id_marque;
        this.nom_marque = nom_marque;
        this.loc_logo = loc_logo;
        this.description = description;
    }

    public long getId_marque() {
        return id_marque;
    }

    public void setId_marque(long id_marque) {
        this.id_marque = id_marque;
    }

    public String getNom_marque() {
        return nom_marque;
    }

    public void setNom_marque(String nom_marque) {
        this.nom_marque = nom_marque;
    }

    public String getLoc_logo() {
        return loc_logo;
    }

    public void setLoc_logo(String loc_logo) {
        this.loc_logo = loc_logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
