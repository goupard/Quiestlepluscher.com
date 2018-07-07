/*
package com.example.armand.quiestlepluscher.sqlite.dao;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.screen.Connexion;
import com.example.armand.quiestlepluscher.sqlite.MySQLDataBase;
import com.example.armand.quiestlepluscher.entities.Type;

import java.util.ArrayList;

*/
/**
 * Created by ulyss on 12/06/2018.
 *//*


public class TypeDAO {
    public static String TABLE_NAME = "T_TYPE";

    public static String id_type = "id_type";
    public static String nom_type = "nom_type";
    public static String description = "description";
    public static String fk_categorie = "fk_categorie";

    public static String sqlGetAllTypes = "SELECT * FROM "+TABLE_NAME+";";


    public static String sqlCreateTableTypes = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_type + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            nom_type + " VARCHAR," +
            description + " VARCHAR," +
            fk_categorie + " INTEGER, FOREIGN KEY("+fk_categorie+") REFERENCES " +CategorieDAO.TABLE_NAME + "(" + CategorieDAO.id_categorie + ") );";

    public static String sqlFindTypeById(long par_id_type){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + id_type + "= '" + par_id_type +"' ;";
    }


    public static String[] sqlInitDB = {
            "INSERT INTO " + TABLE_NAME + "(" + id_type + "," + nom_type + "," + description + "," + fk_categorie + ")" +
            " VALUES (1,\"Soda\",\"soda\",1 );",

            "INSERT INTO " + TABLE_NAME + "(" + id_type + "," + nom_type + "," + description + "," + fk_categorie + ")" +
            " VALUES (2,\"Jeux de societe\",\"jeu de societe\",2 );"
    };


    public static <T extends Activity> ArrayList<Type> getTypes(T x,String query){
        ArrayList<Type> types = new ArrayList<>();
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

                    Type type = new Type();

                    int queried_id_type = Integer.parseInt(c.getString(c.getColumnIndex(id_type)));
                    type.setId_type(queried_id_type);

                    int queried_fk_categorie = Integer.parseInt(c.getString(c.getColumnIndex(fk_categorie)));
                    type.setFk_categorie(queried_fk_categorie);

                    type.setDescription(c.getString(c.getColumnIndex(description)));
                    type.setNom_type(c.getString(c.getColumnIndex(nom_type)));
                    types.add(type);
                }
            }while(c.moveToNext());
            c.close();
        }else{
            Log.i("Requete SQL : ", " Aucune catégories trouvées.");
        }
        return types;
    }
}
*/
