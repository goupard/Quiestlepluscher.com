package com.example.armand.quiestlepluscher.sqlite.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.Welcome_Screen;
import com.example.armand.quiestlepluscher.sqlite.entities.Marque;

import java.util.ArrayList;

/**
 * Created by ulyss on 12/06/2018.
 */

public class MarqueDAO {
    public static String TABLE_NAME = "T_MARQUE";

    public static String id_marque = "id_marque";
    private static String nom_marque = "nom_marque";
    private static String loc_logo = "loc_logo";
    private static String description = "description";

    private static String sqlGetAllMarques = "SELECT * FROM "+TABLE_NAME+";";

    public static String sqlCreateTableMarque = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_marque + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            nom_marque + " VARCHAR," +
            loc_logo + " VARCHAR," +
            description + " VARCHAR );";

    //public static String sqlInitDB = "INSERT INTO " + TABLE_NAME + " (" + id_marque + "," + nom_marque + "," + loc_logo + "," + description + ") VALUES ();";

    public static String sqlFindMagasinById(long par_id_marque){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + id_marque + "=" + par_id_marque +" ;";
    }

    public static String sqlFindMagasinByNomMarque(String par_nom_marque){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + nom_marque + "=" + par_nom_marque +" ;";
    }

    public static ArrayList<Marque> getMarques(String query){
        ArrayList<Marque> marques = new ArrayList<>();
        SQLiteDatabase bd = Welcome_Screen.getMysqlDatabase().getReadableDatabase();
        Cursor c = bd.rawQuery(query,null);
        if(c != null) {
            c.moveToFirst();
            do{
                Marque marque = new Marque();
                marque.setId_marque(Integer.parseInt(c.getString(c.getColumnIndex(id_marque))));
                marque.setLoc_logo(c.getString(c.getColumnIndex(loc_logo)));
                marque.setDescription(c.getString(c.getColumnIndex(description)));
                marque.setNom_marque(c.getString(c.getColumnIndex(nom_marque)));
                marques.add(marque);
            }while(c.moveToNext());
            c.close();
        }else{
            Log.i("Requete SQL : ", " Aucune catégories trouvées.");
        }
        return marques;
    }


}
