package com.sun.hacks.pokedex.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PokemonBaseDao {
    @Insert
    void insert(pokemonBase pokemon);

    @Update
    void update(pokemonBase... pokemon);

    @Query("UPDATE pokemonBase SET modified_at = DATE('now') WHERE id = :id")
    void updateModifiedAt(int id);

    @Query("SELECT * FROM pokemonBase")
    public LiveData<List<pokemonBase>> getAll();


    @Query("SELECT * FROM pokemonBase WHERE type LIKE :type")
    List<pokemonBase> pokemonWithType(String type);

}
