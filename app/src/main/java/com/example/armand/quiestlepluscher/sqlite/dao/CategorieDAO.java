package com.example.armand.quiestlepluscher.sqlite.dao;

/**
 * Created by ulyss on 12/06/2018.
 */

public class CategorieDAO {
    public static String TABLE_NAME = "T_CATEGORIE";

    public static String id_categorie = "id_categorie";
    private static String nom_categorie = "nom_categorie";
    private static String description = "description";

    public static String sqlCreateTableCategorie = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_categorie + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            description + " VARCHAR," +
            nom_categorie + " VARCHAR );";

    private static String selectProducts = "SELECT * FROM "+TABLE_NAME+";";
    private static String selectProductsByCategory = "SELECT * FROM "+TABLE_NAME+";";


    public static String sqlInitDB = "INSERT INTO "+TABLE_NAME+" (" + id_categorie + "," + nom_categorie + "," + description + ") VALUES (1, \"LEGUMES\", \"les legumes\")," +
            "(2, \"VIANDE\", \"les viandes\")," +
            "(3, \"POISSON FRAIS\", \"les poissons frais\");";

}
