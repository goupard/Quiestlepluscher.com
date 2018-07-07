package com.example.armand.quiestlepluscher.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.armand.quiestlepluscher.entities.Enregistrement;

import java.util.List;

/**
 * Created by ulyss on 07/07/2018.
 */
@Dao
public interface EnregistrementDao {

/*    public static final String TABLE_NAME = "enregistrement";

    public static final String id_enregistrement = "id_enregistrement";
    public static final String date = "date";
    public static final String prix = "prix";
    public static final String fk_produit = "fk_produit";
    public static final String fk_utilisateur = "fk_utilisateur";*/

    @Query("SELECT * FROM enregistrement")
    List<Enregistrement> getAll();

    @Query("SELECT * FROM enregistrement where id_enregistrement LIKE  :id_enregistrement")
    Enregistrement findById(String id_enregistrement);

    @Insert
    void insertAll(Enregistrement... enregistrements);

    @Delete
    void delete(Enregistrement enregistrement);

}
