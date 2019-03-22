package com.example.cryptorate;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CryptoServices {

    @GET("/api/v1/coinlist")
    Call<JsonElement> getAllCrypto(@Query("key") String key,
                                   @Query("pref") String pref, @Query("page") int page, @Query("order") String order);

}
