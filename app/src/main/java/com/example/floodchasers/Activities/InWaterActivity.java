package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.textview.MaterialTextView;

public class InWaterActivity  extends AppCompatActivity {
    private TextView username,TV_in_water_prep,TV_prep_instoctions_water;
    private ImageView settings, main_IMV_appLogo;
    private MaterialTextView home,profile,safety,alerts,forums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_in_water);
        findViews();
        ClickListeners();
    }


    private void ClickListeners() {
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InWaterActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        username = findViewById(R.id.username);
        settings = findViewById(R.id.settings);
        TV_in_water_prep = findViewById(R.id.TV_in_water_prep);
        main_IMV_appLogo = findViewById(R.id.main_IMV_appLogo);
        TV_prep_instoctions_water= findViewById(R.id.TV_prep_instoctions_water);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
    }

}
