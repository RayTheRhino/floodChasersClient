package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.button.MaterialButton;

public class UserProfileActivity extends AppCompatActivity {
    private TextView username,TV_profile_username, Tv_profile_status, home,forums,alerts,safety,profile;
    private ImageView settings,profile_IMV_user_profile;
    private EditText EDT_profile_status;
    private MaterialButton Add_Meta_BTN, Add_status_BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_settings);
        findViews();
        BarListeners();
    }

    private void findViews() {
        EDT_profile_status = findViewById(R.id.EDT_profile_status);
        username = findViewById(R.id.username);
        TV_profile_username= findViewById(R.id.TV_profile_username);
        settings = findViewById(R.id.settings);
        profile_IMV_user_profile = findViewById(R.id.profile_IMV_user_profile);
        Add_Meta_BTN = findViewById(R.id.Add_Meta_BTN);
        Add_status_BTN = findViewById(R.id.Add_status_BTN);
        Tv_profile_status = findViewById(R.id.Tv_profile_status);
        home = findViewById(R.id.home);
        forums= findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
    }
    private void BarListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this,MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this,ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this,AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this, UserProfileActivity.class));
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

}
