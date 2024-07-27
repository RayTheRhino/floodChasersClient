package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Adapter.AlertsAdapter;
import com.example.floodchasers.Api.AlertsApi;
import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class AlertsActivity extends AppCompatActivity {
    private TextView username, alertsTitleTextView;
    private EditText ET_set_location;
    private MaterialButton BTN_enter_location;
    private MaterialTextView home, forums, alerts, safety, profile;
    private ImageView settings;
    private RecyclerView alertsRecyclerView;
    private AlertsAdapter alertsAdapter;
    private ArrayList<String> testArray;
    private AlertsApi alertApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        findViews();
        barListeners();
        ClickListeners();
//        alertApi = r
        testArray = new ArrayList<>();
        testArray.add("Banana");
        testArray.add("Apple");
        testArray.add("Olive");
        testArray.add("Orange");

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
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(EmergencyInfoActivity.this, UserSettingsActivity.class));
//            }
//        });
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
        alertsAdapter = new AlertsAdapter(AlertsActivity.this, testArray);
        alertsRecyclerView.setAdapter(alertsAdapter);
        alertsRecyclerView.setHasFixedSize(true);
    }
}