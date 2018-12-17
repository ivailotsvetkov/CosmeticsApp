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
                "Almay",
                "Alva",
                "Anna sui",
                "Annabellen",
                "Benefit",
                "Boosh",
                "Burt's bees",
                "Butter london",
                "C'est moi",
                "Cargo cosmetics",
                "China glaze",
                "Clinique",
                "Coastal classic creation",
                "Colourpop",
                "Covergirl",
                "Calish",
                "Deciem",
                "Dior",
                "Dr. hauschka",
                "E.L.F.",
                "Essie",
                "Fenty",
                "Glossier",
                "Green people",
                "Iman",
                "L'oreal",
                "Lotus cosmetics usa",
                "Maia's mineral galaxy",
                "Marcelle",
                "Marienatie",
                "Maybelline",
                "Milani",
                "Mineral fusion",
                "Misa",
                "Mistura",
                "Moov",
                "Nudus",
                "Nyx",
                "Orly",
                "Pacifica",
                "Penny lane organics",
                "Physicians formula",
                "Piggy paint",
                "Pure anada",
                "Rejuva minerals",
                "Revlon",
                "Sally b's skin yummies",
                "Salon perfect",
                "Sante",
                "Sinful colours",
                "Smashbox",
                "Stila",
                "Suncoat",
                "w3llpeople",
                "Wet n Wild",
                "Zorah",
                "Zorah biocosmetiques"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, brands);
        brand.setAdapter(adapter);
    }

    @OnClick({R.id.buttonSearch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonSearch:
                Intent search = new Intent(this, CosmeticsActivity.class);
                search.putExtra(BRAND, brand.getSelectedItem().toString().toLowerCase());
                search.putExtra(PRODUCT_TYPE, editTextType.getText().toString().toLowerCase());
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
