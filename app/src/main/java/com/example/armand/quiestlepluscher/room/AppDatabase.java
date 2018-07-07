package com.example.armand.quiestlepluscher.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.armand.quiestlepluscher.entities.Categorie;
import com.example.armand.quiestlepluscher.entities.Enregistrement;
import com.example.armand.quiestlepluscher.entities.Magasin;
import com.example.armand.quiestlepluscher.entities.Marque;
import com.example.armand.quiestlepluscher.entities.Produit;
import com.example.armand.quiestlepluscher.entities.Type;
import com.example.armand.quiestlepluscher.entities.Utilisateur;
import com.example.armand.quiestlepluscher.room.daos.CategorieDao;
import com.example.armand.quiestlepluscher.room.daos.EnregistrementDao;
import com.example.armand.quiestlepluscher.room.daos.MagasinDao;
import com.example.armand.quiestlepluscher.room.daos.MarqueDao;
import com.example.armand.quiestlepluscher.room.daos.ProduitDao;
import com.example.armand.quiestlepluscher.room.daos.TypeDao;
import com.example.armand.quiestlepluscher.room.daos.UtilisateurDao;

/**
 * Created by ulyss on 07/07/2018.
 */
@Database(entities = {Categorie.class,
        Enregistrement.class,
        Magasin.class,
        Marque.class,
        Produit.class,
        Type.class,
        Utilisateur.class
        }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract CategorieDao categorieDao();
    public abstract EnregistrementDao enregistrementDao();
    public abstract MagasinDao magasinDao();
    public abstract MarqueDao marqueDao();
    public abstract ProduitDao produitDao();
    public abstract TypeDao typeDao();
    public abstract UtilisateurDao userDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();

        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
