package com.example.floodchasers.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;

public class SafetyActivity extends AppCompatActivity {
    private TextView username, TV_Em_response_hub;
    private ImageView settings, settings_IMV_Logo;
    private MaterialButton BTN_safety_inst,BTN_curr_loc,BTN_emergency_num;
    private EditText TV_display_location;
    private Footer footerView;

    private FusedLocationProviderClient fusedLocationClient;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety);
        findViews();
        barListeners();
        ClickListeners();
        footerView.updateTextColor(footerView.getSafety());

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    private void ClickListeners() {
        BTN_emergency_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SafetyActivity.this, EmergencyNumbersActivity.class);
                startActivity(intent);
            }
        });
        BTN_safety_inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SafetyActivity.this, EmergencyInfoActivity.class);
                startActivity(intent);
            }
        });
        BTN_curr_loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentLocation();
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SafetyActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
    }
    private void getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                double latitude = location.getLatitude();
                                double longitude = location.getLongitude();
                                sendLocation(latitude, longitude);
                            }
                        }
                    });
        }
    }

    private void sendLocation(double latitude, double longitude) {
        String locationMessage = "Latitude: " + latitude + ", Longitude: " + longitude;
        TV_display_location.setText(locationMessage);
        TV_display_location.setVisibility(View.VISIBLE);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            }
        }
    }

    private void barListeners() {
        footerView.setHomeButtonClickListener(v ->
                startActivity(new Intent(SafetyActivity.this, MainActivity.class))
        );

        footerView.setForumsButtonClickListener(v ->
                startActivity(new Intent(SafetyActivity.this, ForumActivity.class))
        );

        footerView.setSafetyButtonClickListener(v ->
                startActivity(new Intent(SafetyActivity.this, SafetyActivity.class))
        );

        footerView.setAlertsButtonClickListener(v ->
                startActivity(new Intent(SafetyActivity.this, AlertsActivity.class))
        );
        footerView.setProfileButtonClickListener(view ->
                startActivity(new Intent(SafetyActivity.this, UserProfileActivity.class))
        );
    }

    private void findViews() {
        TV_Em_response_hub = findViewById(R.id.TV_Em_response_hub);
        settings_IMV_Logo = findViewById(R.id.settings_IMV_Logo);
        BTN_safety_inst = findViewById(R.id.BTN_safety_inst);
        BTN_curr_loc = findViewById(R.id.BTN_curr_loc);
        BTN_emergency_num = findViewById(R.id.BTN_emergency_num);
        TV_display_location = findViewById(R.id.TV_display_location);

        //header and footer BTNs
        settings = findViewById(R.id.settings);
        username= findViewById(R.id.username);
        footerView = findViewById(R.id.footerView);
    }
}
