package com.example.asus.cosmeticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CosmeticsActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private CosmeticsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmetics);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String brand = intent.getStringExtra(MainActivity.BRAND);
        String type = intent.getStringExtra(MainActivity.PRODUCT_TYPE);
        search(brand, type);
    }

    private void search(String brand, String type) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://makeup-api.herokuapp.com/api/v1/").addConverterFactory(GsonConverterFactory.create()).client(httpClient.build())
                .build();
        ICosmeticService service = retrofit.create(ICosmeticService.class);
        Call<List<Cosmetic>> call = service.getCosmeticByBrandOrProductType(brand, type);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter(mAdapter);
        progressBar.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<List<Cosmetic>>() {
            @Override
            public void onResponse(Call<List<Cosmetic>> call, Response<List<Cosmetic>> response) {
                progressBar.setVisibility(View.GONE);
                List<Cosmetic> cosmeticsList = response.body();
                Toast.makeText(CosmeticsActivity.this, ""+cosmeticsList.get(0).getWebsiteLink(), Toast.LENGTH_SHORT).show();
                mAdapter = new CosmeticsAdapter(cosmeticsList, CosmeticsActivity.this);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Cosmetic>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(CosmeticsActivity.this, "Unable to connect", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
