package com.example.asus.cosmeticsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Details extends AppCompatActivity {
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
    Cosmetic cosmetic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        cosmetic = (Cosmetic) getIntent().getSerializableExtra(CosmeticsAdapter.PARAM);

        Toast.makeText(Details.this, ""+cosmetic.getImageLink(), Toast.LENGTH_SHORT).show();

        Picasso.get()
          .load(cosmetic.getImageLink())
          .resize(150, 150)
          .centerCrop()
          .into(image);
        brand.setText("Brand: "+cosmetic.getBrand());
        name.setText("Name: "+cosmetic.getName());
        price.setText("Price: "+cosmetic.getPrice());
        description.setText(cosmetic.getDescription());
    }
}
