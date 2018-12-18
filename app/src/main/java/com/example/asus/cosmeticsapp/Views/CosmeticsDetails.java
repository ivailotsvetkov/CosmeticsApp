package com.example.asus.cosmeticsapp.Views;

import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.cosmeticsapp.Adapters.CosmeticsAdapter;
import com.example.asus.cosmeticsapp.Model.Cosmetic;
import com.example.asus.cosmeticsapp.Model.Favourite;
import com.example.asus.cosmeticsapp.Room.MyAppDatabase;
import com.example.asus.cosmeticsapp.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CosmeticsDetails extends AppCompatActivity {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.brand)
    TextView brand;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.switchForFavourites)
    Switch aSwitch;

    private MyAppDatabase db;
    private Favourite newFav = new Favourite("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        if (db == null) {
            db = Room.databaseBuilder(getApplicationContext(),
                    MyAppDatabase.class, "Room").build();
        }
        SharedPreferences sharedPrefs = getSharedPreferences("editor", MODE_PRIVATE);
        aSwitch.setChecked(sharedPrefs.getBoolean("isChecked", false));

        final Cosmetic cosmetic = (Cosmetic) getIntent().getSerializableExtra(CosmeticsAdapter.COSMETIC);

        Toast.makeText(CosmeticsDetails.this, "" + cosmetic.getImageLink(), Toast.LENGTH_SHORT).show();

        Picasso.get()
                .load(cosmetic.getImageLink())
                .resize(150, 150)
                .centerCrop()
                .into(image);
        brand.setText("Brand: " + cosmetic.getBrand());
        name.setText("Name: " + cosmetic.getName());
        price.setText("Price: " + cosmetic.getPrice());
        description.setText(cosmetic.getDescription());
        newFav.setName(cosmetic.getName());

    }

    public void onClick(View v) {
        if (!aSwitch.isChecked()) {
            db.favouriteDao().insert(newFav);
            SharedPreferences.Editor editor = getSharedPreferences("editor", MODE_PRIVATE).edit();
            editor.putBoolean("isChecked", false);
            editor.commit();
        } else {
            db.favouriteDao().delete(newFav);
            SharedPreferences.Editor editor = getSharedPreferences("editor", MODE_PRIVATE).edit();
            editor.putBoolean("isChecked", true);
            editor.commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
