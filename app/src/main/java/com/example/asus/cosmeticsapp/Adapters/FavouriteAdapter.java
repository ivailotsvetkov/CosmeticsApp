package com.example.asus.cosmeticsapp.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.asus.cosmeticsapp.Model.Favourite;
import com.example.asus.cosmeticsapp.R;

import java.util.ArrayList;

/**
 * Created by Asus on 6.11.2017 г..
 */

public class FavouriteAdapter extends ArrayAdapter<Favourite> {
    public FavouriteAdapter(Activity content, ArrayList<Favourite> favourites) {
        super(content, 0, favourites);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_favourites, parent, false);
        }

        Favourite currentFavourite = getItem(position);
        TextView name = (TextView) listItemView.findViewById(R.id.favorite);
        name.setText(currentFavourite.getName());
        return listItemView;
    }


}

