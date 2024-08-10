package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class UserSettingsActivity extends AppCompatActivity {
    private TextView username;
    private EditText EDT_profile_status;
    private ImageView settings;
    private Footer footerView;
    private Spinner Sp_update_timing_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts_notifications);
        findViews();
        footerListener();
        initSpinner();
        footerView.updateTextColor(footerView.getAlerts());
        onClick();


    }

    private void onClick() {
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserSettingsActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findViews() {
        username = findViewById(R.id.username);
        settings = findViewById(R.id.settings);
        footerView = findViewById(R.id.footerView);
        Sp_update_timing_spinner = findViewById(R.id.Sp_update_timing_spinner);
    }

    private void initSpinner() {
        ArrayList<String> datesRange = new ArrayList<>();
        datesRange.add("day");
        datesRange.add("week");
        datesRange.add("month");
        Sp_update_timing_spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datesRange));
        String hey = Sp_update_timing_spinner.getSelectedItem().toString();  //get pick from user (like if user pick month it will be month)
    }

    private void footerListener() {
        footerView.setHomeButtonClickListener(v ->
                startActivity(new Intent(UserSettingsActivity.this, MainActivity.class))
        );
        footerView.setForumsButtonClickListener(v ->
                startActivity(new Intent(UserSettingsActivity.this, ForumActivity.class))
        );
        footerView.setSafetyButtonClickListener(v ->
                startActivity(new Intent(UserSettingsActivity.this, SafetyActivity.class))
        );
        footerView.setAlertsButtonClickListener(v ->
                startActivity(new Intent(UserSettingsActivity.this, AlertsActivity.class))
        );
        footerView.setProfileButtonClickListener(v->
                startActivity(new Intent(UserSettingsActivity.this, UserProfileActivity.class))
        );
    }

}
