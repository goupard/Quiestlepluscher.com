package com.example.armand.quiestlepluscher.sqlite.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.Welcome_Screen;
import com.example.armand.quiestlepluscher.sqlite.entities.Utilisateur;

/**
 * Created by ulyss on 12/06/2018.
 */

public class UtilisateurDAO {
    public static String TABLE_NAME = "T_UTILISATEUR";

    public static String id_utilisateur = "id_utilisateur";
    private static String login = "login";
    private static String hashed_password = "hashed_password";

    public static String sqlCreateTableUsers = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_utilisateur + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            login + " VARCHAR," +
            hashed_password + " VARCHAR );";

    public static Utilisateur insertUtilisateur(Utilisateur u){
        SQLiteDatabase bd = Welcome_Screen.getMysqlDatabase().getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(login,u.getLogin());
        values.put(hashed_password,u.getHashed_password());
        long id = bd.insert(TABLE_NAME,null,values);
        if(id <= 0 ){
            Log.e("Error inserting player", "Impossible d'insérer le joueur : " + u.toString());
        }else {
            u.setId_utilisateur(id);
        }
        bd.close();
        return u;
    }


    //public static String sqlInitDB = "INSERT INTO "+TABLE_NAME+" (" + id_utilisateur + "," + login + "," + hashed_password +") VALUES ();";


}
