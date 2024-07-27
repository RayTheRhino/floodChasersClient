package com.example.floodchasers.Api;
import com.example.floodchasers.Boundaries.Comment;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface CommentApi {

    @POST("Comments/CreateComment")
    Call<Comment>CreateComment(@Body Comment newComment);

    @POST("Comments/AddCommentToComment")
    Call<Comment> AddCommentToComment(@Body Comment newComment, @Query("id") String commentParentId);
    @GET("Comments/GetAllComments")
    Call<List<Comment>> GetAllComments();

    @PUT("Comments/UpdateComment")
    Call<Comment> GetCommentById(@Body Comment commentUpdate);

    @DELETE("Comments/DeleteCommentById")
    Call<Void>DeleteCommentById(@Query("id") String CommentId);

    @DELETE("Comments/DeleteAllComments")
    Call<Void> DeleteAllComments();
}
