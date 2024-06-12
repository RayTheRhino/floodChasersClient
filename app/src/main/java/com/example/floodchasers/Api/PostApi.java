package com.example.floodchasers.Api;

import com.example.floodchasers.Boundaries.PostBoundary;
import com.example.floodchasers.Objects.Post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostApi {
    @POST("Posts/GetAllPosts")
    Call<PostBoundary>GetPosts();

    @POST("Forums/CreatePost")
    Call<Void>createPost(@Body Post request);
}
