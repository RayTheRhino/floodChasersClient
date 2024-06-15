package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Adapter.AlertsAdapter;
import com.example.floodchasers.Adapter.ForumAdapter;
import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;

import java.util.ArrayList;

public class AlertsActivity extends AppCompatActivity {
    private Footer footerView;
    private RecyclerView alertsRecyclerView;
    private AlertsAdapter alertsAdapter;
    private ArrayList<String> testArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        testArray = new ArrayList<>();
        testArray.add("Banana");
        testArray.add("Apple");
        testArray.add("Olive");
        testArray.add("Orange");
        findViews();
        barListeners();
        footerView.updateTextColor(footerView.getAlerts());
    }

    private void barListeners() {
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
        alertsRecyclerView = findViewById(R.id.alertsRcView);
        footerView = findViewById(R.id.footerView);
        alertsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        alertsAdapter = new AlertsAdapter(AlertsActivity.this, testArray);
        alertsRecyclerView.setAdapter(alertsAdapter);
        alertsRecyclerView.setHasFixedSize(true);
    }
}