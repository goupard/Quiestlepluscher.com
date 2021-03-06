/*
package com.example.armand.quiestlepluscher.sqlite.dao;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.screen.Connexion;
import com.example.armand.quiestlepluscher.sqlite.MySQLDataBase;
import com.example.armand.quiestlepluscher.entities.Categorie;

import java.util.ArrayList;

*/
/**
 * Created by ulyss on 12/06/2018.
 *//*


public class CategorieDAO {
    public static String TABLE_NAME = "T_CATEGORIE";

    public static String id_categorie = "id_categorie";
    public static String nom_categorie = "nom_categorie";
    public static String description = "description";

    public static String sqlCreateTableCategorie = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_categorie + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            description + " VARCHAR," +
            nom_categorie + " VARCHAR );";

    public static String sqlGetAllCategories = "SELECT * FROM "+TABLE_NAME+";";

    public static String[] sqlInitDB = {
            "INSERT INTO "+TABLE_NAME+" (" + id_categorie + "," + nom_categorie + "," + description + ")" +
            " VALUES (1, \"Boisson\", \"boisson\");",

            "INSERT INTO "+TABLE_NAME+" (" + id_categorie + "," + nom_categorie + "," + description + ")" +
            " VALUES (2, \"JEU\", \"les jeux\");",

            "INSERT INTO "+TABLE_NAME+" (" + id_categorie + "," + nom_categorie + "," + description + ")" +
            " VALUES (3, \"POISSON FRAIS\", \"les poissons frais\");"
    };

    private static String sqlFindCategoryByName(String par_nom_categorie){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + nom_categorie + "= '" + par_nom_categorie +"' ;";
    }

    public static <T extends Activity> ArrayList<Categorie> getCategories(T x,String query){
        ArrayList<Categorie> categories = new ArrayList<>();
        SQLiteDatabase bd = null;
        if(Connexion.getMysqlDatabase() != null) {
            bd = Connexion.getMysqlDatabase().getReadableDatabase();
        }
        else{
            bd = new MySQLDataBase(x).getReadableDatabase();
        }        Cursor c = bd.rawQuery(query,null);
        if(c != null) {
            c.moveToFirst();
            do{
                if(! c.isAfterLast()) {
                    Categorie categorie = new Categorie();
                    categorie.setId_categorie(Integer.parseInt(c.getString(c.getColumnIndex(id_categorie))));
                    categorie.setNom_categorie(c.getString(c.getColumnIndex(nom_categorie)));
                    categorie.setDescription(c.getString(c.getColumnIndex(description)));
                    categories.add(categorie);
                }
            }while(c.moveToNext());
            c.close();
        }else{
            Log.i("Requete SQL : ", " Aucune catégories trouvées.");
        }
        return categories;
    }



}
*/
