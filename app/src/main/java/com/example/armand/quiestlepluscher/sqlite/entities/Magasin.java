package com.example.armand.quiestlepluscher.sqlite.entities;

/**
 * Created by ulyss on 12/06/2018.
 */

public class Magasin {
    private long id_magasin;
    private String nom_magasin;
    private String localisation;
    private String description;
    private String nom_franchise;

    public Magasin() {
    }

    public Magasin(int id_magasin, String nom_magasin, String localisation, String description, String nom_franchise) {
        this.id_magasin = id_magasin;
        this.nom_magasin = nom_magasin;
        this.localisation = localisation;
        this.description = description;
        this.nom_franchise = nom_franchise;
    }

    public long getId_magasin() {
        return id_magasin;
    }

    public void setId_magasin(long id_magasin) {
        this.id_magasin = id_magasin;
    }

    public String getNom_magasin() {
        return nom_magasin;
    }

    public void setNom_magasin(String nom_magasin) {
        this.nom_magasin = nom_magasin;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom_franchise() {
        return nom_franchise;
    }

    public void setNom_franchise(String nom_franchise) {
        this.nom_franchise = nom_franchise;
    }
}
