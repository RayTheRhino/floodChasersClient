package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class EmergencyInfoActivity extends AppCompatActivity {
    private TextView username,TV_emergency_instructions;
    private ImageView settings, IMV_safety;
    private MaterialButton BTN_gen_info,BTN_pre_prep,BTN_strong_water,BTN_in_water;
    private MaterialTextView home,profile,safety,alerts,forums;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_info);
        findViews();

        Intent intent = getIntent();
        String usernameValue = intent.getStringExtra("username");

        if (usernameValue != null) {
            username.setText(usernameValue);
        }

        barListeners();
        ClickListeners();
    }

    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmergencyInfoActivity.this,MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmergencyInfoActivity.this,ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmergencyInfoActivity.this,AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmergencyInfoActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmergencyInfoActivity.this, UserProfileActivity.class));
            }
        });
    }

    private void ClickListeners() {
        BTN_gen_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmergencyInfoActivity.this,GenPrepActivity.class);
                startActivity(intent);
            }
        });
        BTN_pre_prep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmergencyInfoActivity.this,PrePrepActivity.class);
                startActivity(intent);
            }
        });
        BTN_strong_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmergencyInfoActivity.this,StrongWaterActivity.class);
                startActivity(intent);
            }
        });
        BTN_in_water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmergencyInfoActivity.this,InWaterActivity.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmergencyInfoActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });

    }


    private void findViews() {
        username = findViewById(R.id.username);
        settings = findViewById(R.id.settings);
        TV_emergency_instructions = findViewById(R.id.TV_emergency_instructions);
        IMV_safety= findViewById(R.id.IMV_safety);
        BTN_gen_info = findViewById(R.id.BTN_gen_info);
        BTN_pre_prep = findViewById(R.id.BTN_pre_prep);
        BTN_strong_water = findViewById(R.id.BTN_strong_water);
        BTN_in_water = findViewById(R.id.BTN_in_water);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
    }
}
