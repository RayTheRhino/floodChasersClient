package com.example.floodchasers.Activities;

import static com.example.floodchasers.Objects.AppConfig.SERVER_URL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Adapter.AlertsAdapter;
import com.example.floodchasers.Api.AlertsApi;
import com.example.floodchasers.Boundaries.Comment;
import com.example.floodchasers.Objects.Alert;
import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlertsActivity extends AppCompatActivity {
    private TextView username, alertsTitleTextView;
    private EditText ET_set_location;
    private MaterialButton BTN_enter_location;
    private MaterialTextView home, forums, alerts, safety, profile;
    private ImageView settings;
    private RecyclerView alertsRecyclerView;
    private AlertsAdapter alertsAdapter;
    private ArrayList<Alert> alertArray = new ArrayList<>();
    private AlertsApi alertApi;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        alertApi = retrofit.create(AlertsApi.class);
        findViews();
        barListeners();
        ClickListeners();
        GetAllAlert();

    }

    private void ClickListeners() {
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlertsActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertsActivity.this, MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertsActivity.this, ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertsActivity.this, AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertsActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertsActivity.this, UserProfileActivity.class));
            }
        });
    }

    private void GetAllAlert() {
        alertApi.GetAllAlerts().enqueue(new Callback<List<Alert>>() {
            @Override
            public void onResponse(Call<List<Alert>> call, Response<List<Alert>> response) {
                if (!response.isSuccessful()) {

                    Toast.makeText(AlertsActivity.this, "Api dosnt Work!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AlertsActivity.this, "Api  Work!", Toast.LENGTH_SHORT).show();
                    alertArray.addAll(response.body());
                    alertsAdapter = new AlertsAdapter(AlertsActivity.this,alertArray);
                    alertsRecyclerView.setAdapter(alertsAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Alert>> call, Throwable t) {
                Toast.makeText(AlertsActivity.this, "Cent get posts!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void findViews() {
        profile = findViewById(R.id.profile);
        safety = findViewById(R.id.safety);
        alerts = findViewById(R.id.alerts);
        forums = findViewById(R.id.forums);
        username = findViewById(R.id.username);
        home = findViewById(R.id.home);
        alertsTitleTextView = findViewById(R.id.alertsTitleTextView);
        ET_set_location = findViewById(R.id.ET_set_location);
        alertsRecyclerView = findViewById(R.id.alertsRecyclerView);
        settings = findViewById(R.id.settings);
        BTN_enter_location = findViewById(R.id.BTN_enter_location);
        alertsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        alertsAdapter = new AlertsAdapter(AlertsActivity.this, alertArray);
        alertsRecyclerView.setAdapter(alertsAdapter);
        alertsRecyclerView.setHasFixedSize(true);
    }
}