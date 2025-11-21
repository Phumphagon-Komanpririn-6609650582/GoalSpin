package com.example.gamespinn;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_pool")
public class ItemEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String rarity;
    public int imageRes;

    public ItemEntity(String name, String rarity, int imageRes) {
        this.name = name;
        this.rarity = rarity;
        this.imageRes = imageRes;
    }
}
