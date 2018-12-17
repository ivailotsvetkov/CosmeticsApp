package com.example.asus.cosmeticsapp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ICosmeticService {
@GET("products.json?")
    Call<List<Cosmetic>> getCosmeticByBrandOrProductType(@Query("brand") String brand,@Query("product_type") String productType);
}
