package com.example.floodchasers.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;

public class AlertLocationActivity extends AppCompatActivity {
    private TextView alertTitle;
    private  TextView alertDetails;
    private Footer footerView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_location_alert);
            findViews();
            footerListener();
            footerView.updateTextColor(footerView.getAlerts());
            Intent intent = getIntent();

            String alertDetails_text = intent.getStringExtra("alertDetails");
            alertDetails.setText(alertDetails_text);

            String alertTitle_text = intent.getStringExtra("alertTitle");
            alertTitle.setText(alertTitle_text);
        }

    private void findViews() {
        alertTitle = findViewById(R.id.alertTitle);
        alertDetails = findViewById(R.id.alertDetails);
        footerView = findViewById(R.id.footerView);
    }
    private void footerListener() {
        footerView.setHomeButtonClickListener(v ->
                startActivity(new Intent(AlertLocationActivity.this, MainActivity.class))
        );
        footerView.setForumsButtonClickListener(v ->
                startActivity(new Intent(AlertLocationActivity.this, ForumActivity.class))
        );
        footerView.setSafetyButtonClickListener(v ->
                startActivity(new Intent(AlertLocationActivity.this, SafetyActivity.class))
        );
        footerView.setAlertsButtonClickListener(v ->
                startActivity(new Intent(AlertLocationActivity.this, AlertsActivity.class))
        );
    }
}

