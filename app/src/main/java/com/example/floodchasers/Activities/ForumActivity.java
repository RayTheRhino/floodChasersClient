package com.example.floodchasers.Activities;

import static com.example.floodchasers.Objects.AppConfig.SERVER_URL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Adapter.ForumAdapter;
import com.example.floodchasers.Api.PostApi;
import com.example.floodchasers.Boundaries.PostBoundary;
import com.example.floodchasers.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForumActivity extends AppCompatActivity {
    private TextView username, TV_Forums, add_comment_LBL, comment_title_LBL,comment_body_LBL;
    private ImageView settings, Edit_Comment_IV;
    private EditText comment_title_EDT, comment_body_Edt;
    private LinearLayout lay_add_forum_topic;
    private MaterialTextView home, forums, alerts,safety, profile;
    private RecyclerView RV_forum;
    private MaterialButton Add_Meta_BTN,Add_Comment_BTN;
    private Button BTN_add_topic;
    private ForumAdapter forumAdapter;
    private ArrayList<PostBoundary> forumBoundaries;
    private ArrayList<String> testArray;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private PostApi postApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forums);
        findViews();
        barListeners();
        ClickListeners();
//        CretePostReq();

        testArray = new ArrayList<>();
        testArray.add("Banana");
        testArray.add("Apple");
        testArray.add("Olive");
        testArray.add("Orange");
        RV_forum.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        forumAdapter = new ForumAdapter(ForumActivity.this,testArray);
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
        add_comment_LBL = findViewById(R.id.add_comment_LBL);
        username = findViewById(R.id.username);
        TV_Forums = findViewById(R.id.TV_Forums);
        settings = findViewById(R.id.settings);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
        Edit_Comment_IV = findViewById(R.id.Edit_Comment_IV);
        comment_title_LBL = findViewById(R.id.comment_title_LBL);
        comment_title_EDT = findViewById(R.id.comment_title_EDT);
        comment_body_LBL = findViewById(R.id.comment_body_LBL);
        comment_body_Edt = findViewById(R.id.comment_body_Edt);
        Add_Meta_BTN = findViewById(R.id.Add_Meta_BTN);
        BTN_add_topic = findViewById(R.id.BTN_add_topic);
        Add_Comment_BTN = findViewById(R.id.Add_Comment_BTN);
        lay_add_forum_topic = findViewById(R.id.lay_add_forum_topic);
        lay_add_forum_topic.setVisibility(View.GONE);

    }


}
