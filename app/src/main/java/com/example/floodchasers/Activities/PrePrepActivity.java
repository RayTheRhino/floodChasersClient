package com.example.floodchasers.Activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.google.android.material.button.MaterialButton;

public class PrePrepActivity extends AppCompatActivity {
    private TextView username, TV_pre_prep, Tv_pre_prep_info;
    private ImageView settings, IMV_pre_prep_im;
    private MaterialButton home, forums, alerts, safety, profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_pre_prep);
        findViews();
        onClick();
    }

    private void onClick() {
    }

    private void findViews() {
        username = findViewById(R.id.username);
        settings = findViewById(R.id.settings);
        TV_pre_prep = findViewById(R.id.TV_pre_prep);
        IMV_pre_prep_im = findViewById(R.id.IMV_pre_prep_im);
        Tv_pre_prep_info = findViewById(R.id.Tv_pre_prep_info);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
    }
}
