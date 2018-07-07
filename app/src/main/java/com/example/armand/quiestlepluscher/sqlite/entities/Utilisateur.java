package com.example.armand.quiestlepluscher.sqlite.entities;

import java.io.Serializable;

/**
 * Created by ulyss on 12/06/2018.
 */

public class Utilisateur implements Serializable{
    private long id_utilisateur;
    private String login;
    private String nom;
    private String prenom;
    private String hashed_password;
    private String email;

    public Utilisateur() {
    }

    public Utilisateur(int id_utilisateur, String login, String hashed_password, String email, String nom, String prenom) {
        this.id_utilisateur = id_utilisateur;
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.hashed_password = hashed_password;
        this.email = email;
    }

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
