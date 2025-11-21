package com.example.gamespinn;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert
    void insert(ItemEntity item);

    @Insert
    void insertAll(List<ItemEntity> items);

    @Query("SELECT * FROM item_pool")
    List<ItemEntity> getAllItems();

    @Query("SELECT COUNT(*) FROM item_pool")
    int getItemCount();

    // ⭐ สำคัญ: ใช้ลบข้อมูลเก่าทั้งหมด เมื่อต้องอัปเดตรายการ item
    @Query("DELETE FROM item_pool")
    void deleteAll();
}
