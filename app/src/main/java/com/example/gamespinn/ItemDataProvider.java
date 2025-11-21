package com.example.gamespinn;

import java.util.ArrayList;
import java.util.List;
public class ItemDataProvider {

    public static List<ItemEntity> getAllItems() {

        List<ItemEntity> items = new ArrayList<>();

        //dragon
        items.add(new ItemEntity("Gothic Mountain", "Legendary", R.drawable.gothic_mountain));
        items.add(new ItemEntity("Dragon", "Legendary", R.drawable.dragon));
        items.add(new ItemEntity("Salt", "Common", R.drawable.salt));
        items.add(new ItemEntity("Dark Witch", "Epic", R.drawable.gothic_frame));
        /*
        items.add(new ItemEntity("Gothic Mountain", "Legendary", R.drawable.gothic_mountain));
        items.add(new ItemEntity("Dragon", "Legendary", R.drawable.dragon));
        items.add(new ItemEntity("Salt", "Common", R.drawable.salt));
        items.add(new ItemEntity("Dark Witch", "Epic", R.drawable.gothic_frame));
        items.add(new ItemEntity("Gothic Mountain", "Legendary", R.drawable.gothic_mountain));
        items.add(new ItemEntity("Dragon", "Legendary", R.drawable.dragon));
        items.add(new ItemEntity("Salt", "Common", R.drawable.salt));
        items.add(new ItemEntity("Dark Witch", "Epic", R.drawable.gothic_frame));
        */

        return items;
    }
}
