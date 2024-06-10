package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.floodchasers.Objects.Alert;
import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        // Dummy Data TEMPORARY
        List<Alert> alertList = new ArrayList<>(Arrays.asList(
                new Alert("Location 1", "Flood alert description for location 1", "2024-06-07", "10:00 AM", "High", "Flash Flood Warning"),
                new Alert("Location 2", "Flood alert description for location 2", "2024-06-07", "11:00 AM", "Medium", "Flood Advisory"),
                new Alert("Location 3", "Flood alert description for location 3", "2024-06-07", "12:00 PM", "Low", "Flood Watch")
        ));
        onClickAlertLocationListener(alertList);
        footerListener();
    }

    private void onClickAlertLocationListener(List<Alert> alertList) {
        List<String> alertLocations = new ArrayList<>();
        for (Alert alert : alertList) {
            alertLocations.add(alert.getLocation());
        }
        ArrayAdapter<String> alertLocationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alertLocations);
        alertsListView.setAdapter(alertLocationAdapter);
        alertsListView.setOnItemClickListener((parent, view, position, id) -> {
            Alert selectedAlert = alertList.get(position);
            Toast.makeText(AlertsActivity.this, "Selected: " + selectedAlert.getLocation(), Toast.LENGTH_SHORT).show();

            String alertDetails = "Severity: " + selectedAlert.getSeverity() + " | Date: " + selectedAlert.getDate() +
                    " | Time: " + selectedAlert.getTime() + " | Tags: " + selectedAlert.getTags();

            Intent intent = new Intent(AlertsActivity.this, AlertLocationActivity.class);
            intent.putExtra("alertTitle", selectedAlert.getLocation());
            intent.putExtra("alertDetails", alertDetails);
            startActivity(intent);
        });
    }

    private void footerListener() {
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