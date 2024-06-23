package com.example.floodchasers.Api;
import com.example.floodchasers.Boundaries.CommentBoundary;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface CommentApi {

    @POST("Comments/CreateComment")
    Call<CommentBoundary>CreateComment(@Body CommentBoundary newCommentBoundary);

    @POST("Comments/AddCommentToComment")
    Call<CommentBoundary> AddCommentToComment(@Body CommentBoundary newCommentBoundary, @Query("id") String commentParentId);
    @GET("Comments/GetAllComments")
    Call<CommentBoundary> GetAllComments();

    @PUT("Comments/UpdateComment")
    Call<CommentBoundary> GetCommentById(@Body CommentBoundary commentBoundaryUpdate);

    @DELETE("Comments/DeleteCommentById")
    Call<Void>DeleteCommentById(@Query("id") String CommentId);

    @DELETE("Comments/DeleteAllComments")
    Call<Void> DeleteAllComments();
}
