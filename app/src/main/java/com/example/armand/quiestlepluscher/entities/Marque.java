package com.example.armand.quiestlepluscher.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by ulyss on 12/06/2018.
 */
@Entity(tableName = "marque")
public class Marque  implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_marque")
    private long id_marque;
    @ColumnInfo(name = "nom_marque")
    private String nom_marque;
    @ColumnInfo(name = "loc_logo")
    private String loc_logo;
    @ColumnInfo(name = "description")
    private String description;

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
