package com.example.floodchasers.Activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.Api.MenuApi;
import com.example.floodchasers.R;
import com.google.android.material.textview.MaterialTextView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity  extends AppCompatActivity {

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
