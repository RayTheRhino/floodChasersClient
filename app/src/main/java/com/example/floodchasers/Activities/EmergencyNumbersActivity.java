package com.example.floodchasers.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class EmergencyNumbersActivity extends AppCompatActivity {
    private MaterialButton BTN_Nature_Auth_num,BTN_Firefighting_num,BTN_MDA_num,BTN_Police_num;
    private MaterialTextView home,forums,alerts, safety,profile;
    private TextView username, TV_emergency_nums;
    private ImageView settings, IMV_emnum_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_numbers);
        findViews();
        barListeners();
        DialActions();
    }

    private void DialActions() {
        BTN_Nature_Auth_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:*3639"));
                startActivity(intent);
            }
        });
        BTN_Firefighting_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:*102"));
                startActivity(intent);
            }
        });
        BTN_MDA_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:*101"));
                startActivity(intent);
            }
        });
        BTN_Police_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:*100"));
                startActivity(intent);
            }
        });

    }

    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmergencyNumbersActivity.this,MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmergencyNumbersActivity.this,ForumActivity.class));
            }
        });
//        alerts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(EmergencyNumbersActivity.this,);
//            }
//        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmergencyNumbersActivity.this, SafetyActivity.class));
            }
        });
//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(EmergencyNumbersActivity.this,);
//            }
//        });
    }


    private void findViews() {
        BTN_Nature_Auth_num = findViewById(R.id.BTN_Nature_Auth_num);
        BTN_Firefighting_num = findViewById(R.id.BTN_Firefighting_num);
        BTN_MDA_num = findViewById(R.id.BTN_MDA_num);
        BTN_Police_num = findViewById(R.id.BTN_Police_num);
        TV_emergency_nums = findViewById(R.id.TV_emergency_nums);
        IMV_emnum_logo = findViewById(R.id.IMV_emnum_logo);

        //header and footer BTNs
        settings = findViewById(R.id.settings);
        username= findViewById(R.id.username);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);

    }
}
