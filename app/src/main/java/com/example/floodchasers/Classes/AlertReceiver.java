package com.example.floodchasers.Classes;

import static com.example.floodchasers.Objects.AppConfig.SERVER_URL;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.floodchasers.Activities.AlertsActivity;
import com.example.floodchasers.Adapter.AlertsAdapter;
import com.example.floodchasers.Api.AlertsApi;
import com.example.floodchasers.Objects.Alert;
import com.example.floodchasers.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlertReceiver extends BroadcastReceiver {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private AlertsApi alertApi;

    @Override
    public void onReceive(Context context, Intent intent) {
        alertApi = retrofit.create(AlertsApi.class);
        String location = intent.getStringExtra("location");

        GetAlertsForLocation(location, new AlertsCallback() {
            @Override
            public void onAlertsReceived(List<String> headlines) {
                for (String headline : headlines) {
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "FloodAlertsChannel")
                            .setSmallIcon(R.drawable.alert)
                            .setContentTitle("Flood Alerts for " + location)
                            .setContentText(headline)
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setAutoCancel(true);

                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    notificationManager.notify(2, builder.build());
                }
            }

            @Override
            public void onError(Throwable t) {
                Toast.makeText(context, "Failed to retrieve alerts: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void GetAlertsForLocation(String location, AlertsCallback callback) {
        alertApi.GetAlertsByArea(location).enqueue(new Callback<List<Alert>>() {
            @Override
            public void onResponse(Call<List<Alert>> call, Response<List<Alert>> response) {
                if (!response.isSuccessful()) {
                    callback.onError(new Exception("Failed to retrieve alerts"));
                    return;
                }

                List<Alert> alerts = response.body();
                List<String> headlines = new ArrayList<>();

                if (alerts != null) {
                    for (Alert alert : alerts) {
                        headlines.add(alert.getHeadline());
                    }
                }
                callback.onAlertsReceived(headlines);
            }

            @Override
            public void onFailure(Call<List<Alert>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    public interface AlertsCallback {
        void onAlertsReceived(List<String> headlines);
        void onError(Throwable t);
    }


}
