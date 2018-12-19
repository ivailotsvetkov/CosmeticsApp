package com.example.asus.cosmeticsapp.Views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.asus.cosmeticsapp.Adapters.FavouriteAdapter;
import com.example.asus.cosmeticsapp.ViewModel.FavouriteViewModel;
import com.example.asus.cosmeticsapp.Model.Favourite;
import com.example.asus.cosmeticsapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FavouritesActivity extends AppCompatActivity {
    @BindView(R.id.listView)
    ListView listViewFavourites;


    private FavouriteViewModel favouriteViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        //Can't manage to run the line bellow
      //  favouriteViewModel = ViewModelProvider.of(this).get(FavouriteViewModel.class);
        favouriteViewModel.getFavListLiveData().observe(this, new Observer<List<Favourite>>() {
            ArrayList<Favourite> favourites=new ArrayList<>();
            FavouriteAdapter mAdapter=new FavouriteAdapter(FavouritesActivity.this,favourites);
            @Override
            public void onChanged(@Nullable List<Favourite> favourites) {
                mAdapter.addAll(favourites);
            }
        });
    }
}

