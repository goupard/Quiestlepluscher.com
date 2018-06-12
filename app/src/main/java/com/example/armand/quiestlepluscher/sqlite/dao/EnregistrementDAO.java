package com.example.armand.quiestlepluscher.sqlite.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.Welcome_Screen;
import com.example.armand.quiestlepluscher.sqlite.entities.Enregistrement;

/**
 * Created by ulyss on 12/06/2018.
 */

public class EnregistrementDAO {
    public static String TABLE_NAME = "T_ENREGISTREMENTS";

    public static String id_enregistrement = "id_enregistrement";
    private static String date = "date";
    private static String prix = "prix";
    private static String fk_produit = "fk_produit";
    private static String fk_utilisateur = "fk_utilisateur";


    public static String sqlCreateTableEnregistrements = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_enregistrement + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            fk_produit + " INTEGER, FOREIGN KEY(" + fk_produit + ") REFERENCES " +ProduitDAO.TABLE_NAME + "(" + ProduitDAO.id_produit + ")," +
            date + " DATE," +
            prix + " INTEGER," +
            fk_utilisateur + " INTEGER, FOREIGN KEY(" + fk_utilisateur + ") REFERENCES " +UtilisateurDAO.TABLE_NAME + "(" + UtilisateurDAO.id_utilisateur+ ") );";


    public static Enregistrement insertEnregistrement(Enregistrement enregistrement){
        SQLiteDatabase bd = Welcome_Screen.getMysqlDatabase().getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(date,enregistrement.getDate().toString());
        values.put(prix,enregistrement.getPrix());
        values.put(fk_produit,enregistrement.getFk_produit());
        values.put(fk_utilisateur,enregistrement.getFk_utilisateur());
        long id = bd.insert(TABLE_NAME,null,values);
        if(id <= 0 ){
            Log.e("Error inserting player", "Impossible d'insérer le joueur : " + enregistrement.toString());
        }else {
            enregistrement.setId_enregistrement(id);
        }
        bd.close();
        return enregistrement;
    }

    //public static String sqlInitDB = "INSERT INTO "+TABLE_NAME+" (" + id_enregistrement + "," + date + "," + prix + "," + fk_produit + "," + fk_utilisateur + ") VALUES ();";


}
