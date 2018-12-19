package com.example.asus.cosmeticsapp.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.asus.cosmeticsapp.Model.Favourite;

@Database(entities = {Favourite.class}, version = 1, exportSchema = false)
public abstract class MyAppDatabase extends RoomDatabase {
    private static MyAppDatabase instance;

    public static synchronized MyAppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MyAppDatabase.class, "favourite_database")
                    .fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract FavouriteDao favouriteDao();

}
