package com.example.podgotovka66;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface RetrofitAPI {

    @GET("Movies")
    Call<List<Model>> getmodel();
}
