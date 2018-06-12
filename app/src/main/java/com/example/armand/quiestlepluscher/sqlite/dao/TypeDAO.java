package com.example.armand.quiestlepluscher.sqlite.dao;

/**
 * Created by ulyss on 12/06/2018.
 */

public class TypeDAO {
    public static String TABLE_NAME = "T_TYPE";

    public static String id_type = "id_type";
    private static String nom_type = "nom_type";
    private static String description = "description";
    private static String fk_categorie = "fk_categorie";

    public static String sqlCreateTableTypes = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_type + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            nom_type + " VARCHAR," +
            description + " VARCHAR," +
            fk_categorie + " INTEGER, FOREIGN KEY(fk_location) REFERENCES " +CategorieDAO.TABLE_NAME + "(" + CategorieDAO.id_categorie + ") );";


    public static String sqlInitDB = "INSERT INTO " + TABLE_NAME + "(" + id_type + "," + nom_type + "," + description + "," + fk_categorie + ") VALUES (1,\"TOMATE ALLONGEES\",\"tomates allongées\",1 );";
}
