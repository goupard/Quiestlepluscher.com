package com.example.armand.quiestlepluscher.sqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.armand.quiestlepluscher.screen.Connexion;
import com.example.armand.quiestlepluscher.views.Welcome_Screen;
import com.example.armand.quiestlepluscher.sqlite.entities.Produit;

import java.util.ArrayList;

/**
 * Created by ulyss on 12/06/2018.
 */

public class ProduitDAO {
    public static String TABLE_NAME = "T_PRODUIT";

    public static String id_produit = "id_produit";
    private static String nom_produit = "nom_produit";
    private static String num_code_barres = "num_code_barres";
    private static String description = "description";
    private static String fk_type = "fk_type";
    private static String fk_marque = "fk_marque";

    private static String sqlGetAllProduits = "SELECT * FROM "+TABLE_NAME+";";

    public static String sqlCreateTableProduits = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( " +
            id_produit + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            nom_produit + " VARCHAR," +
            num_code_barres + " VARCHAR," +
            description + " VARCHAR," +
            fk_type + " INTEGER, " +
            fk_marque + " INTEGER,"
            +" FOREIGN KEY(" + fk_marque + ") REFERENCES " +MarqueDAO.TABLE_NAME + "(" + MarqueDAO.id_marque + ")," +
             " FOREIGN KEY(" + fk_type + ") REFERENCES " +TypeDAO.TABLE_NAME + "(" + TypeDAO.id_type + ")" +
            " );";

    public static Produit insertProduit(Produit produit){
        SQLiteDatabase bd = Connexion.getMysqlDatabase().getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(nom_produit,produit.getNom_produit());
        values.put(num_code_barres,produit.getNum_code_barres());
        values.put(description,produit.getDescription());
        values.put(fk_type,produit.getFk_type());
        values.put(fk_marque,produit.getFk_marque());
        long id = bd.insert(TABLE_NAME,null,values);
        if(id <= 0 ){
            Log.e("Error inserting player", "Impossible d'insérer le joueur : " + produit.toString());
        }else {
            produit.setId_produit(id);
        }
        bd.close();
        return produit;
    }

    public static String sqlInitDB = "INSERT INTO "+TABLE_NAME+" (" + id_produit + "," + nom_produit + "," + num_code_barres + "," + description + "," + fk_type + "," + fk_marque +") VALUES (1, \"AGRUM\", \"3124480002570\", \"Une boisson energisante pour les bonhommes\", 1, 1)," +
            "(2, \"Munchkin\", \"8435407602342\", \"Un jeu pour les bonhommes\", 2, 2);";

    public static String sqlFindProduitById(long par_id_produit){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + id_produit + "=" + par_id_produit +" ;";
    }

    public static String sqlFindProduitByNomProduit(String par_nom_produit){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + nom_produit + "=" + par_nom_produit +" ;";
    }

    public static String sqlFindProduitByNomProduitAndMarque(String par_nom_produit, long par_fk_marque){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + nom_produit + "=" + par_nom_produit +" and "+ fk_marque +" ="+ par_fk_marque + ";";
    }

    public static String sqlFindProduitByNumCodeBarres(String par_num_code_barres){
        return "SELECT * FROM " + TABLE_NAME + " WHERE " + num_code_barres + "=" + par_num_code_barres +" ;";
    }

    public static ArrayList<Produit> getProduits(String query){
        ArrayList<Produit> produits = new ArrayList<>();
        SQLiteDatabase bd = Connexion.getMysqlDatabase().getReadableDatabase();
        Cursor c = bd.rawQuery(query,null);
        if(c != null) {
            c.moveToFirst();
            do{
                Produit produit = new Produit();
                produit.setId_produit(Integer.parseInt(c.getString(c.getColumnIndex(id_produit))));
                produit.setFk_marque(Integer.parseInt(c.getString(c.getColumnIndex(fk_marque))));
                produit.setDescription(c.getString(c.getColumnIndex(description)));
                produit.setNom_produit(c.getString(c.getColumnIndex(nom_produit)));
                produit.setNum_code_barres(c.getString(c.getColumnIndex(num_code_barres)));
                produits.add(produit);
            }while(c.moveToNext());
            c.close();
        }else{
            Log.i("Requete SQL : ", " Aucune catégories trouvées.");
        }
        return produits;
    }


}
