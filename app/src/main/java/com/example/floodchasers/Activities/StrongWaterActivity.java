package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.google.android.material.textview.MaterialTextView;

public class StrongWaterActivity extends AppCompatActivity {
    private TextView username, TV_strong_water,TV_strong_water_prep;
    private ImageView settings, main_IMV_appLogo;
    private MaterialTextView home,profile,safety,alerts,forums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_strong_water);
        findViews();
        ClickListeners();
        barListeners();
    }

    private void ClickListeners() {
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StrongWaterActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        TV_strong_water = findViewById(R.id.TV_strong_water);
        username = findViewById(R.id.username);
        settings = findViewById(R.id.settings);
        main_IMV_appLogo = findViewById(R.id.main_IMV_appLogo);
        TV_strong_water_prep = findViewById(R.id.TV_strong_water_prep);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
    }
    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StrongWaterActivity.this,MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StrongWaterActivity.this,ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StrongWaterActivity.this,AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StrongWaterActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StrongWaterActivity.this, UserProfileActivity.class));
            }
        });
    }
}
