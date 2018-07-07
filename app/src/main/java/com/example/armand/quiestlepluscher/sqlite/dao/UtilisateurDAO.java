package com.example.armand.quiestlepluscher.sqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.screen.Connexion;
import com.example.armand.quiestlepluscher.views.Welcome_Screen;
import com.example.armand.quiestlepluscher.sqlite.entities.Utilisateur;

import java.util.ArrayList;

/**
 * Created by ulyss on 12/06/2018.
 */

public class UtilisateurDAO {
    public static String TABLE_NAME = "T_UTILISATEUR";

    public static String id_utilisateur = "id_utilisateur";
    private static String login = "login";
    private static String nom = "nom";
    private static String prenom = "prenom";
    private static String hashed_password = "hashed_password";
    private static String email = "email";

    public static String sqlCreateTableUsers = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_utilisateur + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            login + " VARCHAR," +
            nom + " VARCHAR," +
            prenom + " VARCHAR," +
            hashed_password + " VARCHAR," +
            email + " VARCHAR );";

    public static Utilisateur insertUtilisateur(Utilisateur u){
        SQLiteDatabase bd = Connexion.getMysqlDatabase().getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(login,u.getLogin());
        values.put(nom,u.getNom());
        values.put(prenom,u.getPrenom());
        values.put(hashed_password,u.getHashed_password());
        values.put(email,u.getEmail());
        long id = bd.insert(TABLE_NAME,null,values);
        if(id <= 0 ){
            Log.e("Error inserting player", "Impossible d'insérer le joueur : " + u.toString());
        }else {
            u.setId_utilisateur(id);
        }
        bd.close();
        return u;
    }

    public static String sqlFindUserByLogin(String par_login){
        return "SELECT * FROM " + TABLE_NAME + " WHERE TRIM(" + login + ") = '" + par_login.trim() +"'";
    }

    public static String sqlGetAllUsers = "SELECT * FROM "+TABLE_NAME+";";


    public static String sqlInitDB = "INSERT INTO "+TABLE_NAME+" (" + id_utilisateur + "," + login + "," + nom + "," + prenom + "," + email + "," + hashed_password +")" +
            " VALUES (800,'admin@gmail.com','root','uid0','admin@gmail.com','cc175b9c0f1b6a831c399e269772661');"; // Ligne en dur pour ajouter un administrateur


    public static ArrayList<Utilisateur> getUtilisateurs(String query){
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        SQLiteDatabase bd = Connexion.getMysqlDatabase().getReadableDatabase();
        Cursor c = bd.rawQuery(query,null);
        if(c != null) {
            c.moveToFirst();
            do{
                if(! c.isAfterLast()) {
                    Utilisateur utilisateur = new Utilisateur();
                    utilisateur.setId_utilisateur(Integer.parseInt(c.getString(c.getColumnIndex(id_utilisateur))));
                    utilisateur.setLogin(c.getString(c.getColumnIndex(login)));
                    utilisateur.setNom(c.getString(c.getColumnIndex(nom)));
                    utilisateur.setPrenom(c.getString(c.getColumnIndex(prenom)));
                    utilisateur.setEmail(c.getString(c.getColumnIndex(email)));
                    utilisateur.setHashed_password(c.getString(c.getColumnIndex(hashed_password)));
                    utilisateurs.add(utilisateur);
                }
            }while(c.moveToNext());
            c.close();
        }else{
            Log.i("Requete SQL : ", " Aucune catégories trouvées.");
        }
        return utilisateurs;
    }

}
