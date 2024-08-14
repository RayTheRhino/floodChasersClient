package com.example.floodchasers.Activities;

import static com.example.floodchasers.Objects.AppConfig.SERVER_URL;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Adapter.AlertsAdapter;
import com.example.floodchasers.Api.AlertsApi;
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

public class AlertNotificationActivity extends AppCompatActivity {
    private TextView username, alertsTitleTextView, TV_set_alert, TV_update_timing, tv_choose_alert;
    private ImageView settings;
    private EditText EDt_choose_alert;
    private ToggleButton TB_set_alert;
    private Spinner Sp_update_timing_spinner;
    private MaterialButton Enter_location_BTN;
    private MaterialTextView home,forums,alerts,safety,profile;
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
        setContentView(R.layout.activity_alerts_notifications);
        findViews();

        Intent intent = getIntent();
        String usernameValue = intent.getStringExtra("username");

        if (usernameValue != null) {
            username.setText(usernameValue);
        }

        alertApi = retrofit.create(AlertsApi.class);
        ClickListeners();

    }

    private void ClickListeners() {
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlertNotificationActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
        Enter_location_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void GetAlertsByLocation(String area){
        alertApi.GetAlertsByArea(area).enqueue(new Callback<List<Alert>>() {
            @Override
            public void onResponse(Call<List<Alert>> call, Response<List<Alert>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(AlertNotificationActivity.this, "response of area is not successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AlertNotificationActivity.this, "response of area is  successful", Toast.LENGTH_SHORT).show();
                    alertArray.addAll(response.body());
                    //TODO: ask or it might be needed to display on a different page
                    alertsAdapter = new AlertsAdapter(AlertNotificationActivity.this,alertArray);
                    alertsRecyclerView.setAdapter(alertsAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<Alert>> call, Throwable t) {
                Toast.makeText(AlertNotificationActivity.this, "request of area is bad!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findViews() {
        username = findViewById(R.id.username);
        home = findViewById(R.id.profile);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
        alertsTitleTextView = findViewById(R.id.alertsTitleTextView);
        TV_set_alert = findViewById(R.id.TV_set_alert);
        TV_update_timing = findViewById(R.id.TV_update_timing);
        tv_choose_alert = findViewById(R.id.tv_choose_alert);
        settings = findViewById(R.id.settings);
        EDt_choose_alert = findViewById(R.id.EDt_choose_alert);
        TB_set_alert = findViewById(R.id.TB_set_alert);
        Sp_update_timing_spinner = findViewById(R.id.Sp_update_timing_spinner);
        Enter_location_BTN = findViewById(R.id.Enter_location_BTN) ;
    }

    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertNotificationActivity.this,MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertNotificationActivity.this,ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertNotificationActivity.this,AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertNotificationActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertNotificationActivity.this, UserProfileActivity.class));
            }
        });
    }
}

