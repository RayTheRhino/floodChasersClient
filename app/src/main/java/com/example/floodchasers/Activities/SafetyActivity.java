package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.button.MaterialButton;

public class SafetyActivity extends AppCompatActivity {
    private TextView username, TV_Em_response_hub;
    private ImageView settings, settings_IMV_Logo;
    private MaterialButton BTN_safety_inst,BTN_curr_loc,BTN_emergency_num;
    private Footer footerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);
        findViews();
        barListeners();
        onClick();
        footerView.updateTextColor(footerView.getSafety());
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
        footerView.setHomeButtonClickListener(v ->
                startActivity(new Intent(SafetyActivity.this, MainActivity.class))
        );

        footerView.setForumsButtonClickListener(v ->
                startActivity(new Intent(SafetyActivity.this, ForumActivity.class))
        );

        footerView.setSafetyButtonClickListener(v ->
                startActivity(new Intent(SafetyActivity.this, SafetyActivity.class))
        );

        footerView.setAlertsButtonClickListener(v ->
                startActivity(new Intent(SafetyActivity.this, AlertsActivity.class))
        );
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
        footerView = findViewById(R.id.footerView);
    }
}
