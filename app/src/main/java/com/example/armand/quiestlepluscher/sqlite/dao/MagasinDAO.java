package com.example.armand.quiestlepluscher.sqlite.dao;

/**
 * Created by ulyss on 12/06/2018.
 */

public class MagasinDAO {
    public static String TABLE_NAME = "T_MAGASIN";

    public static String id_magasin = "id_magasin";
    private static String nom_magasin = "nom_magasin";
    private static String localisation = "localisation";
    private static String description = "description";
    private static String nom_franchise = "nom_franchise";

    public static String sqlCreateTableMagasin = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_magasin + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            nom_magasin + " VARCHAR," +
            localisation + " VARCHAR," +
            description + " VARCHAR," +
            nom_franchise + " VARCHAR );";

    //public static String sqlInitDB = "INSERT INTO "+TABLE_NAME+" (" + id_magasin + "," + nom_magasin + "," + localisation + "," + description + "," + nom_franchise + ") VALUES ();";

}
