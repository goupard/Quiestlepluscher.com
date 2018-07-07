package com.example.armand.quiestlepluscher.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by ulyss on 12/06/2018.
 */

@Entity(tableName = "utilisateur")
public class Utilisateur implements Serializable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_utilisateur")
    private long id_utilisateur;
    @ColumnInfo(name = "login")
    private String login;
    @ColumnInfo(name = "nom")
    private String nom;
    @ColumnInfo(name = "prenom")
    private String prenom;
    @ColumnInfo(name = "hashed_password")
    private String hashed_password;
    @ColumnInfo(name = "email")
    private String email;

    public long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashed_password() {
        return hashed_password;
    }

    public void setHashed_password(String hashed_password) {
        this.hashed_password = hashed_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
