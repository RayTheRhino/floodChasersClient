package com.example.floodchasers;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.Api.MenuApi;
import com.example.floodchasers.Api.UserApi;
import com.google.android.material.textview.MaterialTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuActivity extends AppCompatActivity {


    private TextView username;
    private ImageView settings;
    private MaterialTextView home, forums, alerts,learn, profile;
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
        learn = findViewById(R.id.learn);
        profile = findViewById(R.id.profile);

    }
}
