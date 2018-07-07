package com.example.armand.quiestlepluscher.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.armand.quiestlepluscher.entities.Enregistrement;
import com.example.armand.quiestlepluscher.entities.Magasin;

import java.util.List;

/**
 * Created by ulyss on 07/07/2018.
 */
@Dao
public interface MagasinDao {
    /*public static final String TABLE_NAME = "magasin";
    public static final String id_magasin = "id_magasin";
    public static final String nom_magasin = "nom_magasin";
    public static final String localisation = "localisation";
    public static final String description = "description";
    public static final String nom_franchise = "nom_franchise";*/

    @Query("SELECT * FROM magasin")
    List<Magasin> getAll();

    @Query("SELECT * FROM magasin where nom_magasin LIKE  :nom")
    Magasin findByNom(String nom);

    @Insert
    void insertAll(Magasin... magasins);

    @Delete
    void delete(Magasin magasin);

}
