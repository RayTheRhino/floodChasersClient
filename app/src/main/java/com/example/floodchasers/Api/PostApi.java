package com.example.floodchasers.Api;

import com.example.floodchasers.Objects.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface PostApi {
    @GET("/Posts/GetAllPosts")
    Call<List<Post>>GetPosts();

    @GET
    Call<Post>GetPostById(@Query("postId")String postId);

    @POST("/Posts/CreatePost")
    Call<Post>CreatePost(@Body Post request);

    @POST("/Posts/AddCommentToPost")
    Call<Post>AddCommentToPost(@Query("postId")String postId);

    @PUT("/Posts/UpdatePost")
    Call<Post>UpdatePost(@Body Post updatedBody);

    @DELETE
    Call<Void>DeletePostById(@Query("id")String postId);

    @DELETE
    Call<Void>DeleteAllPosts();




}
