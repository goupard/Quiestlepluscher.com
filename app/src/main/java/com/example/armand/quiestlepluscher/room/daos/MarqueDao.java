package com.example.armand.quiestlepluscher.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.armand.quiestlepluscher.entities.Marque;

import java.util.List;

/**
 * Created by ulyss on 07/07/2018.
 */
@Dao
public interface MarqueDao {
    /*public static final String TABLE_NAME = "marque";

    public static final String id_marque = "id_marque";
    public static final String nom_marque = "nom_marque";
    public static final String loc_logo = "loc_logo";
    public static final String description = "description";*/

    @Query("SELECT * FROM marque")
    List<Marque> getAll();

    @Query("SELECT * FROM marque where nom_marque LIKE  :nom")
    Marque findByNom(String nom);

    @Query("SELECT * FROM marque where id_marque LIKE  :id")
    Marque findById(String id);

    @Insert
    void insertAll(Marque... marques);

    @Delete
    void delete(Marque marque);

}
