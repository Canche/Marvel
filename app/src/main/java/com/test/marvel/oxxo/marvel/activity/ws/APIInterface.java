package com.test.marvel.oxxo.marvel.activity.ws;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("/v1/public/characters")
    Call<Object> marvel(@Query("ts") String ts, @Query("apikey") String apikey, @Query("hash") String hash);
}