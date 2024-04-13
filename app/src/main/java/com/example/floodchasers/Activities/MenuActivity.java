package com.example.floodchasers.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.Api.MenuApi;
import com.example.floodchasers.Api.UserApi;
import com.example.floodchasers.R;
import com.google.android.material.textview.MaterialTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuActivity extends AppCompatActivity {


    private TextView username;
    private ImageView settings;
    private MaterialTextView home, forums, alerts,safety, profile;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://My-IP:3001/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private MenuApi menuApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        menuApi = retrofit.create(MenuApi.class);
        barListeners();
    }

    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this,MainActivity.class));
            }
        });
//        forums.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(EmergencyNumbersActivity.this,));
//            }
//        });
//        alerts.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(EmergencyNumbersActivity.this,);
//            }
//        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, EmergencyNumbersActivity.class));
            }
        });
    }


    private void findViews() {
        username = findViewById(R.id.username);
        settings = findViewById(R.id.settings);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
    }
}
