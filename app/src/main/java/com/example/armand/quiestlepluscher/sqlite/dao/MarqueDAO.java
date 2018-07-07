/*
package com.example.armand.quiestlepluscher.sqlite.dao;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.screen.Connexion;
import com.example.armand.quiestlepluscher.sqlite.MySQLDataBase;
import com.example.armand.quiestlepluscher.entities.Marque;

import java.util.ArrayList;

*/
/**
 * Created by ulyss on 12/06/2018.
 *//*


public class MarqueDAO {
    public static String TABLE_NAME = "T_MARQUE";

    public static String id_marque = "id_marque";
    public static String nom_marque = "nom_marque";
    public static String loc_logo = "loc_logo";
    public static String description = "description";

    private static String sqlGetAllMarques = "SELECT * FROM "+TABLE_NAME+";";

    public static String sqlCreateTableMarque = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_marque + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            nom_marque + " VARCHAR," +
            loc_logo + " VARCHAR," +
            description + " VARCHAR );";

    public static String[] sqlInitDB = {
            "INSERT INTO " + TABLE_NAME + " (" + id_marque + "," + nom_marque + "," + loc_logo + "," + description + ")" +
            " VALUES (1, \"Schweppes\", \"tttt\",\"schweppes\");",

            "INSERT INTO " + TABLE_NAME + " (" + id_marque + "," + nom_marque + "," + loc_logo + "," + description + ")" +
            " VALUES (2, \"EDGE\", \"tttt\",\"edge\");",

            "INSERT INTO " + TABLE_NAME + " (" + id_marque + "," + nom_marque + "," + loc_logo + "," + description + ")" +
            " VALUES (3, \"Ferrero\", \"no_logo\",\"malbouffe\");"
    };

    public static String sqlFindMarqueById(long par_id_marque){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + id_marque + "= '" + par_id_marque +"' ;";
    }

    public static String sqlFindMarqueByNomMarque(String par_nom_marque){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + nom_marque + "= '" + par_nom_marque +"' ;";
    }

    public static <T extends Activity> ArrayList<Marque> getMarques(T x,String query){
        ArrayList<Marque> marques = new ArrayList<>();
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
                    Marque marque = new Marque();
                    marque.setId_marque(Integer.parseInt(c.getString(c.getColumnIndex(id_marque))));
                    marque.setLoc_logo(c.getString(c.getColumnIndex(loc_logo)));
                    marque.setDescription(c.getString(c.getColumnIndex(description)));
                    marque.setNom_marque(c.getString(c.getColumnIndex(nom_marque)));
                    marques.add(marque);
                }
            }while(c.moveToNext());
            c.close();
        }else{
            Log.i("Requete SQL : ", " Aucune catégories trouvées.");
        }
        return marques;
    }


}
*/
