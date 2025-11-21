package com.example.gamespinn;

import java.util.ArrayList;
import java.util.List;
public class ItemDataProvider {

    public static List<ItemEntity> getAllItems() {

        List<ItemEntity> items = new ArrayList<>();

        //dragon
        items.add(new ItemEntity("Gothic Mountain", "Epic", R.drawable.gothic_mountain));
        items.add(new ItemEntity("Dragon", "Legendary", R.drawable.dragon));
        items.add(new ItemEntity("Gothic Frame", "Rare", R.drawable.gothic_frame));
        items.add(new ItemEntity("Salt", "Common", R.drawable.salt));
        items.add(new ItemEntity("Coastal_port", "Epic", R.drawable.coastal_port));
        items.add(new ItemEntity("Floating Castel", "Epic", R.drawable.floating_castle));
        items.add(new ItemEntity("Hidden Forest", "Epic", R.drawable.hidden_forest));
        items.add(new ItemEntity("Owl", "Legendary", R.drawable.owl));
        items.add(new ItemEntity("Niffler", "Legendary", R.drawable.niffler));
        items.add(new ItemEntity("Pygmy Puff", "Legendary", R.drawable.pygmy_puff));
        items.add(new ItemEntity("Hidden Frame", "Rare", R.drawable.gothic_frame));
        items.add(new ItemEntity("Floating Frame", "Rare", R.drawable.gothic_frame));
        items.add(new ItemEntity("Coastal Frame", "Rare", R.drawable.gothic_frame));

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
