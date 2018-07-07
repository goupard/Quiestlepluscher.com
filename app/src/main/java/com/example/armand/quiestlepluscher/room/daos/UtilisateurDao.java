package com.example.armand.quiestlepluscher.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.armand.quiestlepluscher.entities.Utilisateur;

import java.util.List;

/**
 * Created by ulyss on 07/07/2018.
 */
@Dao
public interface UtilisateurDao {

/*    public static final String TABLE_NAME = "utilisateur";
    public static final String id_utilisateur = "id_utilisateur";
    public static final String login = "login";
    public static final String nom = "nom";
    public static final String prenom = "prenom";
    public static final String hashed_password = "hashed_password";
    public static final String email = "email";*/


    @Query("SELECT * FROM utilisateur")
    List<Utilisateur> getAll();

    @Query("SELECT * FROM utilisateur where login LIKE  :login")
    Utilisateur findByLogin(String login);

    @Query("SELECT COUNT(*) from utilisateur")
    int countUsers();

    @Insert
    void insertAll(Utilisateur... users);

    @Delete
    void delete(Utilisateur user);
}
