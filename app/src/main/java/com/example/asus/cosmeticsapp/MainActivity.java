package com.example.asus.cosmeticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editBrand;
    private EditText editProductType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editBrand = (EditText) findViewById(R.id.editTextBrand);
        editProductType = (EditText) findViewById(R.id.editTextType);

    }

    public void clickGetAll(View view) {
        Intent intent = new Intent(this, CosmeticsActivity.class);
        intent.putExtra(Intent.EXTRA_COMPONENT_NAME, "GetAll");
        startActivity(intent);
    }


    public void clickSearch(View view) {

            Intent intent = new Intent(this, CosmeticsActivity.class);
            intent.putExtra(Intent.EXTRA_COMPONENT_NAME, "Search");
            startActivity(intent);

    }
}
