package com.example.armand.quiestlepluscher.sqlite.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.Welcome_Screen;
import com.example.armand.quiestlepluscher.sqlite.entities.Produit;

/**
 * Created by ulyss on 12/06/2018.
 */

public class ProduitDAO {
    public static String TABLE_NAME = "T_PRODUIT";

    public static String id_produit = "id_produit";
    private static String nom_produit = "nom_produit";
    private static String num_code_barres = "num_code_barres";
    private static String description = "description";
    private static String fk_type = "fk_type";
    private static String fk_marque = "fk_marque";

    public static String sqlCreateTableProduits = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_produit + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            nom_produit + " VARCHAR," +
            num_code_barres + " VARCHAR," +
            description + " VARCHAR," +
            fk_type + " INTEGER, FOREIGN KEY(" + fk_type + ") REFERENCES " +TypeDAO.TABLE_NAME + "(" + TypeDAO.id_type + "), " +
            fk_marque + " INTEGER, FOREIGN KEY(" + fk_marque + ") REFERENCES " +MarqueDAO.TABLE_NAME + "(" + MarqueDAO.id_marque + ") );";

    public static Produit insertProduit(Produit produit){
        SQLiteDatabase bd = Welcome_Screen.getMysqlDatabase().getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(nom_produit,produit.getNom_produit());
        values.put(num_code_barres,produit.getNum_code_barres());
        values.put(description,produit.getDescription());
        values.put(fk_type,produit.getFk_type());
        values.put(fk_marque,produit.getFk_marque());
        long id = bd.insert(TABLE_NAME,null,values);
        if(id <= 0 ){
            Log.e("Error inserting player", "Impossible d'insérer le joueur : " + produit.toString());
        }else {
            produit.setId_produit(id);
        }
        bd.close();
        return produit;
    }

    //public static String sqlInitDB = "INSERT INTO "+TABLE_NAME+" (" + id_produit + "," + nom_produit + "," + num_code_barres + "," + description + "," + fk_type + "," + fk_marque +") VALUES ();";


}
