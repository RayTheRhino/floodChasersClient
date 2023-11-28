package com.example.floodchasers.Api;

import com.example.floodchasers.SignUp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("user/register")
    Call<Void> CreateNewUser(@Body SignUp signUp);
}
