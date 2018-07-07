package com.example.armand.quiestlepluscher.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.armand.quiestlepluscher.entities.Produit;

import java.util.List;

/**
 * Created by ulyss on 07/07/2018.
 */
@Dao
public interface ProduitDao {
   /* public static final String TABLE_NAME = "produit";
    public static final String id_produit = "id_produit";
    public static final String nom_produit = "nom_produit";
    public static final String num_code_barres = "num_code_barres";
    public static final String description = "description";
    public static final String fk_type = "fk_type";
    public static final String fk_marque = "fk_marque";*/

    @Query("SELECT * FROM produit")
    List<Produit> getAll();

    @Query("SELECT * FROM produit where nom_produit LIKE  :nom")
    Produit findByNom(String nom);

    @Query("SELECT * FROM produit where num_code_barres LIKE  :num_code_barres")
    Produit findByNumCodeBarres(String num_code_barres);

    @Insert
    void insertAll(Produit... produits);

    @Delete
    void delete(Produit produit);
}
