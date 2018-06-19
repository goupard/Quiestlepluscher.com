package com.example.armand.quiestlepluscher.sqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.Welcome_Screen;
import com.example.armand.quiestlepluscher.sqlite.entities.Type;
import com.example.armand.quiestlepluscher.sqlite.entities.Utilisateur;

import java.util.ArrayList;

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

    public static String sqlFindUserByLogin(String par_login){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + login + "=" + par_login +" ;";
    }

    public static String sqlGetAllUsers = "SELECT * FROM "+TABLE_NAME+";";


    //public static String sqlInitDB = "INSERT INTO "+TABLE_NAME+" (" + id_utilisateur + "," + login + "," + hashed_password +") VALUES ();";


    public static ArrayList<Utilisateur> getTypes(String query){
        ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
        SQLiteDatabase bd = Welcome_Screen.getMysqlDatabase().getReadableDatabase();
        Cursor c = bd.rawQuery(query,null);
        if(c != null) {
            c.moveToFirst();
            do{
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId_utilisateur(Integer.parseInt(c.getString(c.getColumnIndex(id_utilisateur))));
                utilisateur.setLogin(c.getString(c.getColumnIndex(login)));
                utilisateur.setHashed_password(c.getString(c.getColumnIndex(hashed_password)));
                utilisateurs.add(utilisateur);
            }while(c.moveToNext());
            c.close();
        }else{
            Log.i("Requete SQL : ", " Aucune catégories trouvées.");
        }
        return utilisateurs;
    }

}
