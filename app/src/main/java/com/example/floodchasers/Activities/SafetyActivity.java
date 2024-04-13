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

public class SafetyActivity extends AppCompatActivity {
    private TextView username, TV_Em_response_hub;
    private ImageView settings, settings_IMV_Logo;
    private MaterialButton BTN_safety_inst,BTN_curr_loc,BTN_emergency_num;
    private MaterialTextView home,forums,alerts,safety,profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);
        findViews();
        barListeners();
        onClick();
    }

    private void onClick() {
        BTN_emergency_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SafetyActivity.this, EmergencyNumbersActivity.class);
                startActivity(intent);
            }
        });
    }

    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SafetyActivity.this,MainActivity.class));
            }
        });
//        forums.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(EmergencyNumbersActivity.this,));
//            }
//        });
//        alerts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(EmergencyNumbersActivity.this,);
//            }
//        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SafetyActivity.this, SafetyActivity.class));
            }
        });
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(EmergencyNumbersActivity.this,);
//            }
//        });
    }

    private void findViews() {
        TV_Em_response_hub = findViewById(R.id.TV_Em_response_hub);
        settings_IMV_Logo = findViewById(R.id.settings_IMV_Logo);
        BTN_safety_inst = findViewById(R.id.BTN_safety_inst);
        BTN_curr_loc = findViewById(R.id.BTN_curr_loc);
        BTN_emergency_num = findViewById(R.id.BTN_emergency_num);

        //header and footer BTNs
        settings = findViewById(R.id.settings);
        username= findViewById(R.id.username);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
    }
}
