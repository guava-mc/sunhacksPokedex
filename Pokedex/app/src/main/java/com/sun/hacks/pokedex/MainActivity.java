package com.sun.hacks.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sun.hacks.pokedex.databinding.ActivityMainBinding;
import com.sun.hacks.pokedex.db.DatabaseClient;
import com.sun.hacks.pokedex.db.pokemonBase;
import com.sun.hacks.pokedex.pojo.PokemonBaseO;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    List<pokemonBase> pokeList; //would be in controller

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pokemonBase pokemon = new pokemonBase();
        pokemon.setBuddy(true);
        pokemon.setName("Pickachu");
        //adding to database
        DatabaseClient.getInstance(getApplicationContext()).insert(pokemon);

//        DatabaseClient.getInstance(getApplicationContext()).getAll();
        DatabaseClient.getInstance(getApplicationContext()).dao.getAll().observe(this, new Observer<List<pokemonBase>>() {
            @Override
            public void onChanged(List<pokemonBase> pokemonBases) {
                pokeList = pokemonBases;
                Log.d("observing", Arrays.deepToString(new List[]{pokeList}));
            }
        });

//        Gson gson = new GsonBuilder().setPrettyPrinting().create();

//        Type pokemonType = new TypeToken<ArrayList<PokemonBaseO>>(){}.getType();
//        List<PokemonBaseO> pokemonData = null;
//        try {
//            pokemonData = gson.fromJson(jsonToString(), pokemonType);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        Log.d("json", Arrays.deepToString(new List[]{pokemonList}));
//        try (FileWriter writer = new FileWriter(getFilesDir() + "save.json")) {
//            gson.toJson(pokemonData, writer);
//            Log.d("path", getFilesDir() + "save.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Type pokemonType2 = new TypeToken<ArrayList<PokemonBaseO>>(){}.getType();
//        try {
//            List<PokemonBaseO> pokemonData2 = gson.fromJson(jsonToString(), pokemonType);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        try {
//            Log.d("path", getFilesDir().toPath().toString() + "save.json");
//            gson.toJson(pokemon, new FileWriter(getFilesDir().toPath().toString() + "save.json"));
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.d("path", getFilesDir().toPath().toString() + "save.json");
//        } finally {


//        }

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        setContentView(R.layout.grid_layout);

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));

//        List<PokemonBaseO> finalPokemonData = pokemonData;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                pokemonBase pokemon = new pokemonBase();
                pokemon.setBuddy(true);
                pokemon.setName("Pickachu");
                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).insert(pokemon);
            }
        });

//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);
    }

//    private String jsonToString() throws FileNotFoundException {
//        FileInputStream fis = openFileInput(getFilesDir() + "save.json");
//        InputStreamReader inputStreamReader =
//                new InputStreamReader(fis, StandardCharsets.UTF_8);
//        StringBuilder stringBuilder = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
//            String line = reader.readLine();
//            while (line != null) {
//                stringBuilder.append(line).append('\n');
//                line = reader.readLine();
//            }
//        } catch (IOException e) {
//            // Error occurred when opening raw file for reading.
//        } finally {
//            return stringBuilder.toString();
//        }
//    }
}