package com.sun.hacks.pokedex.db;

import android.os.AsyncTask;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import java.util.List;

public class DatabaseClient {

    private Context mCtx;
    private static DatabaseClient mInstance;
    public PokemonBaseDao dao;

    //our app database object
    private AppDatabase appDatabase;

    private DatabaseClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "pokemonDb").fallbackToDestructiveMigration().build();
        dao = appDatabase.pokemonBaseDao();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    // creating a method to insert the data to our database.
    public void insert(pokemonBase model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }

    // creating a method to insert the data to our database.
//    public LiveData<List<pokemonBase>> getAll() {
//        return dao.getAll().observe(this, new Observer<List<pokemonBase>>() {
//            @Override
//            public void onChanged(List<pokemonBase> pokemonBases) {
//                pokeList = pokemonBases;
//            }
//        });
//    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    // we are creating a async task method to insert new course.
    private static class InsertCourseAsyncTask extends AsyncTask<pokemonBase, Void, Void> {
        private PokemonBaseDao dao;

        private InsertCourseAsyncTask(PokemonBaseDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(pokemonBase... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }
}
