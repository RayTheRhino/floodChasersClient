package com.example.floodchasers.Api;

import com.example.floodchasers.Boundaries.ForumBoundary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ForumApi {
    @POST("Forums/GetAllForums")
    Call<ForumBoundary>GetForums();
}
