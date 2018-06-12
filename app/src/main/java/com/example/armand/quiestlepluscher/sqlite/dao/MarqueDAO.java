package com.example.armand.quiestlepluscher.sqlite.dao;

/**
 * Created by ulyss on 12/06/2018.
 */

public class MarqueDAO {
    public static String TABLE_NAME = "T_MARQUE";

    public static String id_marque = "id_marque";
    private static String nom_marque = "nom_marque";
    private static String loc_logo = "loc_logo";
    private static String description = "description";

    public static String sqlCreateTableMarque = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_marque + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            nom_marque + " VARCHAR," +
            loc_logo + " VARCHAR," +
            description + " VARCHAR );";

    public static String sqlInitDB = "INSERT INTO " + TABLE_NAME + " (" + id_marque + "," + nom_marque + "," + loc_logo + "," + description + ") VALUES ();";


}
