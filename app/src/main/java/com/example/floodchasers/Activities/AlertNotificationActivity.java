package com.example.floodchasers.Activities;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class AlertNotificationActivity extends AppCompatActivity {
    private TextView username, alertsTitleTextView, TV_set_alert, TV_update_timing, tv_choose_alert;
    private ImageView settings;
    private EditText EDt_choose_alert;
    private ToggleButton TB_set_alert;
    private Spinner Sp_update_timing_spinner;
    private MaterialButton signIn_login_BTN;
    private MaterialTextView home,forums,alerts,safety,profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts_notifications);
        findViews();
        Intent intent = getIntent();
        ClickListeners();

    }

    private void ClickListeners() {
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlertNotificationActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        username = findViewById(R.id.username);
        home = findViewById(R.id.profile);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
        alertsTitleTextView = findViewById(R.id.alertsTitleTextView);
        TV_set_alert = findViewById(R.id.TV_set_alert);
        TV_update_timing = findViewById(R.id.TV_update_timing);
        tv_choose_alert = findViewById(R.id.tv_choose_alert);
        settings = findViewById(R.id.settings);
        EDt_choose_alert = findViewById(R.id.EDt_choose_alert);
        TB_set_alert = findViewById(R.id.TB_set_alert);
        Sp_update_timing_spinner = findViewById(R.id.Sp_update_timing_spinner);
        signIn_login_BTN = findViewById(R.id.signIn_login_BTN) ;
    }

    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertNotificationActivity.this,MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertNotificationActivity.this,ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertNotificationActivity.this,AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlertNotificationActivity.this, SafetyActivity.class));
            }
        });
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(EmergencyInfoActivity.this, UserSettingsActivity.class));
//            }
//        });
    }
}

