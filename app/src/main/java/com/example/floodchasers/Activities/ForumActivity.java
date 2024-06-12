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

import com.example.floodchasers.Adapter.PostAdapter;
import com.example.floodchasers.Api.PostApi;
import com.example.floodchasers.Boundaries.PostBoundary;
import com.example.floodchasers.Objects.Post;
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
    private PostAdapter postAdapter;
    private ArrayList<PostBoundary> forumBoundaries;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private PostApi postApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        findViews();
        barListeners();
        ClickListeners();
//        CretePostReq();


        forumBoundaries = new ArrayList<PostBoundary>();
        RV_forum.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        postAdapter = new PostAdapter(ForumActivity.this,forumBoundaries);
        RV_forum.setAdapter(postAdapter);
        RV_forum.setHasFixedSize(true);



//        adapter.setOnItemClickListener(new ForumAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Contact contact) {
//                Intent intent = new Intent(ForumActivity.this, AddEditContactActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    private void ClickListeners() {

    }

//    private void CretePostReq() {
//        postApi = retrofit.create(PostApi.class);
//        Post CreatePostRequest= new Post();
//        CreatePostRequest.setId();
//        CreatePostRequest.setBody();
//        CreatePostRequest.setTimeCreated();
//        CreatePostRequest.setTitle();
//    }

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
