package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;

public class AlertsActivity extends AppCompatActivity {
    private ListView alertsListView;
    private Footer footerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        findViews();
        barListeners();
        footerView.updateTextColor(footerView.getAlerts());
    }

    private void barListeners() {
        String[] alerts = {"Location 1: Flood Alert", "Location 2: No Alert", "Location 3: Flood Alert"};
        ArrayAdapter<String> alertsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alerts);
        alertsListView.setAdapter(alertsAdapter);
        alertsListView.setOnItemClickListener((parent, view, position, id) -> {
            // Handle click on individual alert item if needed
            String selectedAlert = (String) parent.getItemAtPosition(position);
            Toast.makeText(AlertsActivity.this, "Selected: " + selectedAlert, Toast.LENGTH_SHORT).show();
        });

        footerView.setHomeButtonClickListener(v ->
                startActivity(new Intent(AlertsActivity.this, MainActivity.class))
        );
        footerView.setForumsButtonClickListener(v ->
                startActivity(new Intent(AlertsActivity.this, ForumActivity.class))
        );
        footerView.setSafetyButtonClickListener(v ->
                startActivity(new Intent(AlertsActivity.this, SafetyActivity.class))
        );
        footerView.setAlertsButtonClickListener(v ->
                startActivity(new Intent(AlertsActivity.this, AlertsActivity.class))
        );
    }

    private void findViews() {
        alertsListView = findViewById(R.id.alertsListView);
        footerView = findViewById(R.id.footerView);
    }
}