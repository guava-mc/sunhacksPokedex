package com.sun.hacks.pokedex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.hacks.pokedex.pojo.PokemonBaseO;

public class FullImageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_image);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        PokemonBaseO pokemon = (PokemonBaseO) i.getExtras().getSerializable("pokemon");
        Log.d("poke", pokemon.toString());
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);

        TextView title = findViewById(R.id.textView);
        TextView data = findViewById(R.id.textView2);

        title.setText(pokemon.getNames().get("english"));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        data.setText(gson.toJson(pokemon.getBase()).toString());
    }

}