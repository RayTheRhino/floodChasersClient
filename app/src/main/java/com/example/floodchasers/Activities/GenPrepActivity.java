package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.google.android.material.textview.MaterialTextView;

public class GenPrepActivity extends AppCompatActivity {
    private TextView username, TV_gen_prep, Tv_prep_info;
    private ImageView settings, IMV_gen_prep;
    private MaterialTextView home,profile,safety,alerts,forums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_gen_prep);
        findViews();
        ClickListeners();
    }

    private void ClickListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GenPrepActivity.this,MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GenPrepActivity.this,ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GenPrepActivity.this,AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GenPrepActivity.this, SafetyActivity.class));
            }
        });
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(CommentActivity.this, EmergencyNumbersActivity.class));
//            }
//        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GenPrepActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        username = findViewById(R.id.username);
        settings = findViewById(R.id.settings);
        TV_gen_prep = findViewById(R.id.TV_gen_prep);
        IMV_gen_prep = findViewById(R.id.IMV_gen_prep);
        Tv_prep_info = findViewById(R.id.Tv_prep_info);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
    }
}
