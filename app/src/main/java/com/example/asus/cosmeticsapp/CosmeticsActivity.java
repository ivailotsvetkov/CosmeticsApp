package com.example.asus.cosmeticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CosmeticsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private CosmeticsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmetics);
        Intent intent = getIntent();
        String message = intent.getStringExtra("get");

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://makeup-api.herokuapp.com/api/v1/").addConverterFactory(GsonConverterFactory.create()).client(httpClient.build())
                .build();

        ICosmeticService service = retrofit.create(ICosmeticService.class);
        Call<List<Cosmetic>> call = service.getAllCosmetics();
//        List<Cosmetic> cosmeticsList1 = new ArrayList<>();
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("deeba","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("deeba","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("deeba","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("deeba","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("deeba","d","a","d"));
//        cosmeticsList1.add(new Cosmetic("d","d","a","d"));
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
//        mAdapter=new CosmeticsAdapter(cosmeticsList1);
        mRecyclerView.setAdapter(mAdapter);
        Toast.makeText(CosmeticsActivity.this, "Hi", Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<List<Cosmetic>>() {
            @Override
            public void onResponse(Call<List<Cosmetic>> call, Response<List<Cosmetic>> response) {
                List<Cosmetic> cosmeticsList = response.body();
                mAdapter = new CosmeticsAdapter(cosmeticsList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Cosmetic>> call, Throwable t) {

                Toast.makeText(CosmeticsActivity.this, "Unable to connect", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
