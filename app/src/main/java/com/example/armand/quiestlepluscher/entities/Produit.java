package com.example.armand.quiestlepluscher.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by ulyss on 12/06/2018.
 */
@Entity(tableName = "produit" /*, foreignKeys = {@ForeignKey(entity = Type.class, parentColumns = "id_type", childColumns = "fk_type", onDelete = CASCADE),
                                               @ForeignKey(entity = Marque.class, parentColumns = "id_marque", childColumns = "fk_marque", onDelete = CASCADE)}*/)
public class Produit implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_produit")
    private long id_produit;
    @ColumnInfo(name = "nom_produit")
    private String nom_produit;
    @ColumnInfo(name = "num_code_barres")
    private String num_code_barres;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "fk_type")
    private int fk_type;
    @ColumnInfo(name = "fk_marque")
    private int fk_marque;

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
