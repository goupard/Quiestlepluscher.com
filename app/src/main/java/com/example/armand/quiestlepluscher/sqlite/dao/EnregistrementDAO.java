package com.example.armand.quiestlepluscher.sqlite.dao;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.screen.Connexion;
import com.example.armand.quiestlepluscher.sqlite.MySQLDataBase;
import com.example.armand.quiestlepluscher.views.Welcome_Screen;
import com.example.armand.quiestlepluscher.sqlite.entities.Enregistrement;

import java.util.ArrayList;

/**
 * Created by ulyss on 12/06/2018.
 */

public class EnregistrementDAO {
    public static String TABLE_NAME = "T_ENREGISTREMENTS";

    public static String id_enregistrement = "id_enregistrement";
    private static String date = "date";
    private static String prix = "prix";
    private static String fk_produit = "fk_produit";
    private static String fk_utilisateur = "fk_utilisateur";

    private static String sqlGetAllEnregistrements = "SELECT * FROM "+TABLE_NAME+";";

    public static String sqlCreateTableEnregistrements = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_enregistrement + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            fk_produit + " INTEGER," +
            date + " DATE," +
            prix + " INTEGER," +
            fk_utilisateur + " INTEGER,"+
            " FOREIGN KEY(" + fk_utilisateur + ") REFERENCES " +UtilisateurDAO.TABLE_NAME + " (" + UtilisateurDAO.id_utilisateur+ ")," +
            " FOREIGN KEY(" + fk_produit + ") REFERENCES " +ProduitDAO.TABLE_NAME + " (" + ProduitDAO.id_produit + ")" +
            " );";


    public static Enregistrement insertEnregistrement(Enregistrement enregistrement){
        SQLiteDatabase bd = Connexion.getMysqlDatabase().getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(date,enregistrement.getDate().toString());
        values.put(prix,enregistrement.getPrix());
        values.put(fk_produit,enregistrement.getFk_produit());
        values.put(fk_utilisateur,enregistrement.getFk_utilisateur());
        long id = bd.insert(TABLE_NAME,null,values);
        if(id <= 0 ){
            Log.e("Error inserting player", "Impossible d'insérer le joueur : " + enregistrement.toString());
        }else {
            enregistrement.setId_enregistrement(id);
        }
        bd.close();
        return enregistrement;
    }

    //public static String sqlInitDB = "INSERT INTO "+TABLE_NAME+" (" + id_enregistrement + "," + date + "," + prix + "," + fk_produit + "," + fk_utilisateur + ") VALUES ();";

    public static String sqlFindEnregistrementsByProduit(long par_fk_produit){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + fk_produit + "= '" + par_fk_produit +"' ;";
    }

    public static String sqlFindEnregistrementsByProduit(String par_fk_produit){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + fk_produit + "= '" + par_fk_produit +"' ;";
    }

    public static String sqlFindEnregistrementsByUtilisateur(String par_fk_utilisateur){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + fk_utilisateur + "= '" + par_fk_utilisateur +"' ;";
    }

    public static <T extends Activity> ArrayList<Enregistrement> getEnregistrements(T x,String query){
        ArrayList<Enregistrement> enregistrements = new ArrayList<>();
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
                    Enregistrement enregistrement = new Enregistrement();
                    enregistrement.setId_enregistrement(Integer.parseInt(c.getString(c.getColumnIndex(id_enregistrement))));
                    enregistrement.setDate(Utils.getDateFromString(c.getString(c.getColumnIndex(date))));
                    enregistrement.setPrix(c.getColumnIndex(prix));
                    enregistrement.setFk_produit(c.getColumnIndex(fk_produit));
                    enregistrement.setFk_utilisateur(c.getColumnIndex(fk_utilisateur));
                    enregistrements.add(enregistrement);
                }
            }while(c.moveToNext());
            c.close();
        }else{
            Log.i("Requete SQL : ", " Aucune catégories trouvées.");
        }
        return enregistrements;
    }
}
