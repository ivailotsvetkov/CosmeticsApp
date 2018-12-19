package com.example.asus.cosmeticsapp.Room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.asus.cosmeticsapp.Model.Favourite;

import java.util.List;


@Dao
public interface FavouriteDao {
    @Query("SELECT * FROM favourite")
    LiveData<List<Favourite>> getAllFavourites();
    @Insert
    void  insert(Favourite favourite);
    @Delete
    void  delete(Favourite favourite);

}
