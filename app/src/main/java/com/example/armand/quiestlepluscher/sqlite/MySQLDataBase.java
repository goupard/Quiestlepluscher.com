package com.example.armand.quiestlepluscher.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.armand.quiestlepluscher.sqlite.dao.CategorieDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.EnregistrementDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.MagasinDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.MarqueDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.ProduitDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.TypeDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.UtilisateurDAO;

/**
 * Created by ulyss on 06/06/2017.
 */

public class MySQLDataBase extends SQLiteOpenHelper {

    private static final String NOM_BD = "QuiEstLeMoinsCher.db";
    private static final int NUM_VERSION = 1;

    public MySQLDataBase(Context context) {
        super(context, NOM_BD, null, NUM_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("DB", "Initializing DB");
        db.execSQL(CategorieDAO.sqlCreateTableCategorie);
        db.execSQL(UtilisateurDAO.sqlCreateTableUsers);
        db.execSQL(MagasinDAO.sqlCreateTableMagasin);
        db.execSQL(MarqueDAO.sqlCreateTableMarque);
        db.execSQL(TypeDAO.sqlCreateTableTypes);
        db.execSQL(ProduitDAO.sqlCreateTableProduits);
        db.execSQL(EnregistrementDAO.sqlCreateTableEnregistrements);


        for (String query : MarqueDAO.sqlInitDB) {
            db.execSQL(query);
        }
        for (String query : CategorieDAO.sqlInitDB) {
            db.execSQL(query);
        }
        for (String query : TypeDAO.sqlInitDB) {
            db.execSQL(query);
        }
        for (String query : UtilisateurDAO.sqlInitDB) {
            db.execSQL(query);
        }
        for (String query : ProduitDAO.sqlInitDB) {
            db.execSQL(query);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
