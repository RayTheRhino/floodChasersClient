package com.example.floodchasers.Api;

import com.example.floodchasers.Boundaries.ForumBoundary;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ForumApi {
    @POST("Forums/CreateForum")
    Call<ForumBoundary> CreateForum(@Body ForumBoundary newPost);

    @GET("Forums/GetAllForums")
    Call<ForumBoundary> GetAllForums();

    @GET("Forums/GetForumById")
    Call<ForumBoundary> GetForumById(@Query("id") String forumId);

    @DELETE("Forums/DeleteForumById")
    Call<Void>DeleteForumById(@Query("id") String forumId);

    @PUT("Forums/UpdateForum")
    Call<ForumBoundary>UpdateForum(@Body ForumBoundary forumBoundaryUpdate);

    @DELETE("Forums/DeleteAllForums")
    Call<Void>DeleteAllForums();

}
