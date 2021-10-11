package com.sun.hacks.pokedex.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PokemonBaseO implements Serializable {
    private Integer id;
    private Map<String, String> name;
    private List<String> types;
    private Map<String, Integer> base;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, String> getNames() {
        return name;
    }

    public void setNames(Map<String, String> names) {
        this.name = names;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Map<String, Integer> getBase() {
        return base;
    }

    public void setBase(Map<String, Integer> base) {
        this.base = base;
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}

