package com.sun.hacks.pokedex.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
import java.util.Map;

@Entity
public class pokemonBase {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "buddy")
    private boolean buddy;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "imgSrc")
    private String imgSrc;

    @ColumnInfo(name = "created_at") private long createdAt = System.currentTimeMillis();
    @ColumnInfo(name = "modified_at") private long modifiedAt = System.currentTimeMillis();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBuddy() {
        return buddy;
    }

    public void setBuddy(boolean buddy) {
        this.buddy = buddy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(long modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String toString() {
        return id + " " + createdAt;
    }

}
