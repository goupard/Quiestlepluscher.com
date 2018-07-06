package com.example.armand.quiestlepluscher.sqlite.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.views.Welcome_Screen;
import com.example.armand.quiestlepluscher.sqlite.entities.Type;

import java.util.ArrayList;

/**
 * Created by ulyss on 12/06/2018.
 */

public class TypeDAO {
    public static String TABLE_NAME = "T_TYPE";

    public static String id_type = "id_type";
    private static String nom_type = "nom_type";
    private static String description = "description";
    private static String fk_categorie = "fk_categorie";

    public static String sqlGetAllTypes = "SELECT * FROM "+TABLE_NAME+";";


    public static String sqlCreateTableTypes = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_type + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            nom_type + " VARCHAR," +
            description + " VARCHAR," +
            fk_categorie + " INTEGER, FOREIGN KEY(fk_location) REFERENCES " +CategorieDAO.TABLE_NAME + "(" + CategorieDAO.id_categorie + ") );";

    public static String sqlFindProduitById(long par_id_type){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + id_type + "=" + par_id_type +" ;";
    }


    public static String sqlInitDB = "INSERT INTO " + TABLE_NAME + "(" + id_type + "," + nom_type + "," + description + "," + fk_categorie + ") VALUES (1,\"TOMATE ALLONGEES\",\"tomates allongées\",1 );";


    public static ArrayList<Type> getTypes(String query){
        ArrayList<Type> types = new ArrayList<>();
        SQLiteDatabase bd = Welcome_Screen.getMysqlDatabase().getReadableDatabase();
        Cursor c = bd.rawQuery(query,null);
        if(c != null) {
            c.moveToFirst();
            do{
                Type type = new Type();
                type.setId_type(Integer.parseInt(c.getString(c.getColumnIndex(id_type))));
                type.setFk_categorie(Integer.parseInt(c.getString(c.getColumnIndex(fk_categorie))));
                type.setDescription(c.getString(c.getColumnIndex(description)));
                type.setNom_type(c.getString(c.getColumnIndex(nom_type)));
                types.add(type);
            }while(c.moveToNext());
            c.close();
        }else{
            Log.i("Requete SQL : ", " Aucune catégories trouvées.");
        }
        return types;
    }
}
