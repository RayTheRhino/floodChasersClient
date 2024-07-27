package com.example.floodchasers.Api;

import com.example.floodchasers.Boundaries.Learn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearnApi {
    @GET("Articles/GetAllArticles")
    Call<List<Learn>> getArticles();
}
