package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.floodchasers.Fragment.MapsFragment;
import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.textview.MaterialTextView;

public class MapActivity extends AppCompatActivity {
    private FrameLayout frame_layout;
    private MaterialTextView home, forums, alerts, safety, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        findViews();
        barListeners();
        Fragment fragment = new MapsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

    private void findViews() {
        frame_layout = findViewById(R.id.frame_layout);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts= findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);

    }
    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapActivity.this, MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapActivity.this, ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapActivity.this, AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapActivity.this, SafetyActivity.class));
            }
        });
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MapActivity.this, EmergencyNumbersActivity.class));
//            }
//        });
    }

}
