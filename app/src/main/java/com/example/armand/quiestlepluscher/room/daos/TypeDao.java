package com.example.armand.quiestlepluscher.room.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.armand.quiestlepluscher.entities.Type;

import java.util.List;

/**
 * Created by ulyss on 07/07/2018.
 */
@Dao
public interface TypeDao {
/*    public static final  String TABLE_NAME = "type";
    public static final  String id_type = "id_type";
    public static final  String nom_type = "nom_type";
    public static final  String description = "description";
    public static final  String fk_categorie = "fk_categorie";*/

    @Query("SELECT * FROM type")
    List<Type> getAll();

    @Query("SELECT * FROM type where id_type LIKE  :id")
    Type findById(String id);

    @Insert
    void insertAll(Type... types);

    @Delete
    void delete(Type type);

}
