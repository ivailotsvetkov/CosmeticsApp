package com.example.asus.cosmeticsapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.asus.cosmeticsapp.Model.Favourite;
import com.example.asus.cosmeticsapp.Room.FavouriteRepository;

import java.util.List;

public class FavouriteViewModel extends AndroidViewModel {
    private FavouriteRepository favouriteRepository;
    private LiveData<List<Favourite>> favListLiveData;
    public FavouriteViewModel(@NonNull Application application) {
        super(application);
        favouriteRepository=new FavouriteRepository(application);
        favListLiveData=favouriteRepository.getFavouritesList();
    }
    public void insert(Favourite favourite){
        favouriteRepository.insert(favourite);
    }
    public void delete(Favourite favourite){
        favouriteRepository.delete(favourite);
    }
    public LiveData<List<Favourite>> getFavListLiveData(){
        return  favListLiveData;
    }
}
