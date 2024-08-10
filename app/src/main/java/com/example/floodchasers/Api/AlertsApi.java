package com.example.floodchasers.Api;

import com.example.floodchasers.Objects.Alert;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AlertsApi {

    @GET("Alerts/GetAllAlerts")
    Call<List<Alert>> GetAllAlerts();

    @GET("/Alerts/GetAlertsByArea")
    Call<List<Alert>>GetAlertsByArea(@Query("area") String area);

}
