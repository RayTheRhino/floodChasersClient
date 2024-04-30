package com.example.floodchasers.Activities;

import static com.example.floodchasers.Objects.AppConfig.SERVER_URL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Adapter.ForumAdapter;
import com.example.floodchasers.Api.ForumApi;
import com.example.floodchasers.Boundaries.ForumBoundary;
import com.example.floodchasers.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForumActivity extends AppCompatActivity {
    private TextView username;
    private ImageView settings;
    private MaterialTextView home, forums, alerts,safety, profile;
    private RecyclerView RV_forum;
    private  ForumAdapter forumAdapter;
    private ArrayList<ForumBoundary> forumBoundaries;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private ForumApi forumApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        findViews();
        barListeners();

        forumBoundaries = new ArrayList<ForumBoundary>();
        RV_forum.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        forumAdapter = new ForumAdapter(ForumActivity.this,forumBoundaries);
        RV_forum.setAdapter(forumAdapter);
        RV_forum.setHasFixedSize(true);



//        adapter.setOnItemClickListener(new ForumAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Contact contact) {
//                Intent intent = new Intent(ForumActivity.this, AddEditContactActivity.class);
//                startActivity(intent);
//            }
//        });

    }
    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForumActivity.this,MainActivity.class));
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
                startActivity(new Intent(ForumActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForumActivity.this, EmergencyNumbersActivity.class));
            }
        });
    }


    private void findViews() {
        RV_forum = findViewById(R.id.RV_forum);
        username = findViewById(R.id.username);
        settings = findViewById(R.id.settings);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
    }


}
