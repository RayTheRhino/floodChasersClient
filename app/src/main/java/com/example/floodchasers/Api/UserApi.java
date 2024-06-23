package com.example.floodchasers.Api;

import com.example.floodchasers.Objects.User;
import com.example.floodchasers.SignUp;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface UserApi {
    @FormUrlEncoded
    @POST("Users/CreateUser")
    Call<Void> CreateNewUser(@Field("JsonData") String signUpData, @Field("Image") byte[] image);

    @GET("Users/GetUserById")
    Call<User>GetUserById(@Query("userId") String userId);

    @GET("Users/GetAllUsers")
    Call<JsonArray> GetAllUsers();

    @PUT("Users/UpdateUser")
    Call<JsonObject> UpdateUser(@Body JsonObject userJson);

    @DELETE("Users/DeleteUserById")
    Call<Void> DeleteUserById(@Query("userId") String userId);

    @DELETE("Users/DeleteAllUsers")
    Call<Void> DeleteAllUsers();

    @GET("Users/Login")
    Call<User>LoggedInUser(@Query("email") String email, @Query("password")String password);
}
