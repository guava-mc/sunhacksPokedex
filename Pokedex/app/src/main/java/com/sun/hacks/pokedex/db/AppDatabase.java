package com.sun.hacks.pokedex.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {pokemonBase.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PokemonBaseDao pokemonBaseDao();
}
