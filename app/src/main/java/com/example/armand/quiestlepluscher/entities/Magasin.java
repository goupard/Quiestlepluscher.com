package com.example.armand.quiestlepluscher.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by ulyss on 12/06/2018.
 */
@Entity(tableName = "magasin")
public class Magasin  implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_magasin")
    private long id_magasin;
    @ColumnInfo(name = "nom_magasin")
    private String nom_magasin;
    @ColumnInfo(name = "localisation")
    private String localisation;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "nom_franchise")
    private String nom_franchise;

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
