package com.example.armand.quiestlepluscher.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by ulyss on 12/06/2018.
 */
@Entity(tableName = "type",
        foreignKeys = {@ForeignKey(entity = Categorie.class, parentColumns = "id_categorie", childColumns = "fk_categorie", onDelete = CASCADE)})
public class Type  implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_type")
    private long id_type;
    @ColumnInfo(name = "nom_type")
    private String nom_type;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "fk_categorie")
    private int fk_categorie;

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
