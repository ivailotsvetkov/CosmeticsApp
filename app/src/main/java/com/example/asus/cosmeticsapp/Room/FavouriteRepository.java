package com.example.asus.cosmeticsapp.Room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.asus.cosmeticsapp.Model.Favourite;

import java.util.List;

public class FavouriteRepository {
    private FavouriteDao favouriteDao;
    private LiveData<List<Favourite>> favouritesList;

    public FavouriteRepository(Application application) {
        MyAppDatabase database = MyAppDatabase.getInstance(application);
        favouriteDao = database.favouriteDao();
        favouritesList = favouriteDao.getAllFavourites();
    }

    public LiveData<List<Favourite>> getFavouritesList() {
        return favouritesList;
    }

    public void insert(Favourite favourite) {
        new InsertFavouriteAsyncTask(favouriteDao).execute(favourite);
    }

    public void delete(Favourite favourite) {
        new DeleteFavouriteAsyncTask(favouriteDao).execute(favourite);
    }

    private static class InsertFavouriteAsyncTask extends AsyncTask<Favourite, Void, Void> {
        private FavouriteDao favouriteDao;

        private InsertFavouriteAsyncTask(FavouriteDao favouriteDao) {
            this.favouriteDao = favouriteDao;
        }

        @Override
        protected Void doInBackground(Favourite... favourites) {
            favouriteDao.insert(favourites[0]);
            return null;
        }
    }

    private static class DeleteFavouriteAsyncTask extends AsyncTask<Favourite, Void, Void> {
        private FavouriteDao favouriteDao;

        private DeleteFavouriteAsyncTask(FavouriteDao favouriteDao) {
            this.favouriteDao = favouriteDao;
        }

        @Override
        protected Void doInBackground(Favourite... favourites) {
            favouriteDao.delete(favourites[0]);
            return null;
        }
    }
}
