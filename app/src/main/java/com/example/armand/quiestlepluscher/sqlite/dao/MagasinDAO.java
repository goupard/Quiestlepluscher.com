/*
package com.example.armand.quiestlepluscher.sqlite.dao;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.screen.Connexion;
import com.example.armand.quiestlepluscher.sqlite.MySQLDataBase;
import com.example.armand.quiestlepluscher.entities.Magasin;

import java.util.ArrayList;

*/
/**
 * Created by ulyss on 12/06/2018.
 *//*


public class MagasinDAO {
    public static String TABLE_NAME = "T_MAGASIN";

    public static String id_magasin = "id_magasin";
    public static String nom_magasin = "nom_magasin";
    public static String localisation = "localisation";
    public static String description = "description";
    public static String nom_franchise = "nom_franchise";

    private static String sqlGetAllMagasins = "SELECT * FROM "+TABLE_NAME+";";


    public static String sqlCreateTableMagasin = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_magasin + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            nom_magasin + " VARCHAR," +
            localisation + " VARCHAR," +
            description + " VARCHAR," +
            nom_franchise + " VARCHAR );";

    //public static String sqlInitDB = "INSERT INTO "+TABLE_NAME+" (" + id_magasin + "," + nom_magasin + "," + localisation + "," + description + "," + nom_franchise + ") VALUES ();";

    public static String sqlFindMagasinById(long par_id_magasin){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + id_magasin + "= '" + par_id_magasin +"' ;";
    }

    public static String sqlFindMagasinByNomMagasin(String par_nom_magasin){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + nom_magasin + "= '" + par_nom_magasin +"' ;";
    }

  public static String sqlFindMagasinByLocalisation(String par_localisation){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + localisation + "= '" + par_localisation +"' ;";
    }

  public static String sqlFindMagasinByDescription(String par_description){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + description + "= '" + par_description +"' ;";
    }

  public static String sqlFindMagasinByNomFranchise(String par_nom_franchise){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + nom_franchise + "= '" + par_nom_franchise +"' ;";
    }

    public static <T extends Activity> ArrayList<Magasin> getMagasins(T x,String query){
        ArrayList<Magasin> magasins = new ArrayList<>();
        SQLiteDatabase bd = null;
        if(Connexion.getMysqlDatabase() != null) {
            bd = Connexion.getMysqlDatabase().getReadableDatabase();
        }
        else{
            bd = new MySQLDataBase(x).getReadableDatabase();
        }        Cursor c = bd.rawQuery(query,null);
        if(c != null) {
            c.moveToFirst();
            do {
                if(! c.isAfterLast()) {

                    Magasin magasin = new Magasin();
                    magasin.setId_magasin(Integer.parseInt(c.getString(c.getColumnIndex(id_magasin))));
                    magasin.setLocalisation(c.getString(c.getColumnIndex(localisation)));
                    magasin.setDescription(c.getString(c.getColumnIndex(description)));
                    magasin.setNom_franchise(c.getString(c.getColumnIndex(nom_franchise)));
                    magasin.setNom_magasin(c.getString(c.getColumnIndex(nom_magasin)));
                    magasins.add(magasin);
                }
            }while(c.moveToNext());
            c.close();
        }else{
            Log.i("Requete SQL : ", " Aucune catégories trouvées.");
        }
        return magasins;
    }

}
*/
