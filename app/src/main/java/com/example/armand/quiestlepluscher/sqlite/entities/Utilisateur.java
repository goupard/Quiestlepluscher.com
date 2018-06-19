package com.example.armand.quiestlepluscher.sqlite.entities;

/**
 * Created by ulyss on 12/06/2018.
 */

public class Utilisateur {
    private long id_utilisateur;
    private String login;
    private String hashed_password;

    public Utilisateur() {
    }

    public Utilisateur(int id_utilisateur, String login, String hashed_password) {
        this.id_utilisateur = id_utilisateur;
        this.login = login;
        this.hashed_password = hashed_password;
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
}
