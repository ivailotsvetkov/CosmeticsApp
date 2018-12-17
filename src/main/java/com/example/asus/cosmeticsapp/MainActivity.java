package com.example.asus.cosmeticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.internal.Utils;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.brand)
    Spinner brand;
    @BindView(R.id.editTextType)
    EditText editTextType;
    @BindView(R.id.buttonSearch)
    Button buttonSearch;
    public static final String BRAND = "brand";
    public static final String PRODUCT_TYPE = "product_type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        String [] brands = new String[]{
                "almay",
                "alva",
                "anna sui",
                "annabellen",
                "benefit",
                "boosh",
                "burt's bees",
                "butter london",
                "c'est moi",
                "cargo cosmetics",
                "china glaze",
                "clinique",
                "coastal classic creation",
                "colourpop",
                "covergirl",
                "dalish",
                "deciem",
                "dior",
                "dr. hauschka",
                "e.l.f.",
                "essie",
                "fenty",
                "glossier",
                "green people",
                "iman",
                "l'oreal",
                "lotus cosmetics usa",
                "maia's mineral galaxy",
                "marcelle",
                "marienatie",
                "maybelline",
                "milani",
                "mineral fusion",
                "misa",
                "mistura",
                "moov",
                "nudus",
                "nyx",
                "orly",
                "pacifica",
                "penny lane organics",
                "physicians formula",
                "piggy paint",
                "pure anada",
                "rejuva minerals",
                "revlon",
                "sally b's skin yummies",
                "salon perfect",
                "sante",
                "sinful colours",
                "smashbox",
                "stila",
                "suncoat",
                "w3llpeople",
                "wet n wild",
                "zorah",
                "zorah biocosmetiques"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, brands);
        brand.setAdapter(adapter);
    }

    @OnClick({R.id.buttonSearch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonSearch:
                Intent search = new Intent(this, CosmeticsActivity.class);
                search.putExtra(BRAND, brand.getSelectedItem().toString());
                search.putExtra(PRODUCT_TYPE, editTextType.getText().toString());
                startActivity(search);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.favorites:
                // star clicked
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
