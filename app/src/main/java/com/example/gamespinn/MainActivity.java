package com.example.gamespinn;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private ItemDao itemDao;
    private List<ItemEntity> allItems = new ArrayList<>();
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ⭐ สร้าง DB + Dao
        db = AppDatabase.getInstance(this);
        itemDao = db.itemDao();

        // ⭐ โหลดรายการ item จาก provider ล่าสุด
        List<ItemEntity> providerItems = ItemDataProvider.getAllItems();
        int expectedCount = providerItems.size();

        // ⭐ sync database ให้ตรงกับ provider
        new Thread(() -> {
            int currentCount = itemDao.getItemCount();

            if (currentCount != expectedCount) {
                itemDao.deleteAll();
                itemDao.insertAll(providerItems);
            }

            // โหลดรายการทั้งหมดจาก DB มาเก็บใน allItems
            allItems = itemDao.getAllItems();
        }).start();

        // ⭐ ตั้งค่าให้ปุ่มทำงาน
        setupButtons();
    }

    // ตั้งค่าให้ปุ่ม SPIN x1 / x4 ทำงาน
    private void setupButtons() {
        FrameLayout btnSpin1 = findViewById(R.id.btnSpin1);
        FrameLayout btnSpin4 = findViewById(R.id.btnSpin4);

        // SPIN x1 → สุ่ม 1 ชิ้น
        btnSpin1.setOnClickListener(v -> {
            ItemEntity result = getRandomItem();
            if (result == null) {
                Toast.makeText(this,
                        "กำลังโหลดไอเท็มอยู่ ลองกดอีกครั้งนะ",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String msg = result.name + " (" + result.rarity + ")";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

            // 🔜 ขั้นต่อไปเราจะเปลี่ยนจาก Toast → เปิดหน้า Result สวย ๆ
        });

        // SPIN x4 (ตอนนี้ยังให้ขึ้นข้อความไว้เฉย ๆ ก่อน)
        btnSpin4.setOnClickListener(v -> {
            Toast.makeText(this,
                    "เดี๋ยวค่อยทำ SPIN x4 ทีหลังนะ ;)",
                    Toast.LENGTH_SHORT).show();
        });
    }

    // สุ่ม item จาก allItems โดยใช้ weight จาก rarity
    private ItemEntity getRandomItem() {
        if (allItems == null || allItems.isEmpty()) {
            return null;
        }

        List<ItemEntity> weightedList = new ArrayList<>();

        for (ItemEntity item : allItems) {
            int weight;
            // ตรง rarity String ให้ตรงกับที่ใส่ใน ItemDataProvider
            switch (item.rarity) {
                case "Legendary":
                    weight = 1;   // โอกาสน้อยสุด
                    break;
                case "Epic":
                    weight = 3;
                    break;
                case "Rare":
                    weight = 6;
                    break;
                case "Common":
                default:
                    weight = 10;  // โอกาสมากสุด
                    break;
            }

            for (int i = 0; i < weight; i++) {
                weightedList.add(item);
            }
        }

        int index = random.nextInt(weightedList.size());
        return weightedList.get(index);
    }
}
