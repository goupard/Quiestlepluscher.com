package com.example.armand.quiestlepluscher.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by ulyss on 12/06/2018.
 */
@Entity(tableName = "categorie")
public class Categorie  implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_categorie")
    private long id_categorie;
    @ColumnInfo(name = "nom_categorie")
    private String nom_categorie;
    @ColumnInfo(name = "description")
    private String description;

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
