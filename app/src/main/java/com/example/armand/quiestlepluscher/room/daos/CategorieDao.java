package com.example.armand.quiestlepluscher.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.armand.quiestlepluscher.entities.Categorie;

import java.util.List;

/**
 * Created by ulyss on 07/07/2018.
 */

@Dao
public interface CategorieDao {
/*
    public static final String TABLE_NAME = "categorie";

    public static final String id_categorie = "id_categorie";
    public static final String nom_categorie = "nom_categorie";
    public static final String description = "description";*/

    @Query("SELECT * FROM categorie")
    List<Categorie> getAll();

    @Query("SELECT * FROM categorie where nom_categorie LIKE  :nom")
    Categorie findByNom(String nom);

    @Insert
    void insertAll(Categorie... categories);

    @Delete
    void delete(Categorie categorie);
}
