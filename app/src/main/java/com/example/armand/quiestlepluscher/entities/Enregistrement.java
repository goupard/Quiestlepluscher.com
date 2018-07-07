package com.example.armand.quiestlepluscher.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;


/**
 * Created by ulyss on 12/06/2018.
 */
@Entity(tableName = "enregistrement"/*, foreignKeys = {@ForeignKey(entity = Produit.class, parentColumns = "id_produit", childColumns = "fk_produit", onDelete = CASCADE),
                                                     @ForeignKey(entity = Utilisateur.class, parentColumns = "id_utilisateur", childColumns = "fk_utilisateurs", onDelete = CASCADE)}*/)


public class Enregistrement  implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_enregistrement")
    private long id_enregistrement;
    @ColumnInfo(name = "date")
    private int date;
    @ColumnInfo(name = "prix")
    private int prix;
    @ColumnInfo(name = "fk_produit")
    private int fk_produit;
    @ColumnInfo(name = "fk_utilisateurs")
    private int fk_utilisateur;

    public long getId_enregistrement() {
        return id_enregistrement;
    }

    public void setId_enregistrement(long id_enregistrement) {
        this.id_enregistrement = id_enregistrement;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getFk_produit() {
        return fk_produit;
    }

    public void setFk_produit(int fk_produit) {
        this.fk_produit = fk_produit;
    }

    public int getFk_utilisateur() {
        return fk_utilisateur;
    }

    public void setFk_utilisateur(int fk_utilisateur) {
        this.fk_utilisateur = fk_utilisateur;
    }

    @Override
    public String toString() {
        return "Enregistrement{" +
                "id_enregistrement=" + id_enregistrement +
                ", date=" + date +
                ", prix=" + prix +
                ", fk_produit=" + fk_produit +
                ", fk_utilisateur=" + fk_utilisateur +
                '}';
    }
}
