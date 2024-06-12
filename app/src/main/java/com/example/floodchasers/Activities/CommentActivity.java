package com.example.floodchasers.Activities;

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

import com.example.floodchasers.Adapter.ComentAdapter;
import com.example.floodchasers.Adapter.ForumAdapter;
import com.example.floodchasers.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class CommentActivity extends AppCompatActivity {
    private TextView username, add_comment_LBL, comment_title_LBL, comment_body_LBL;
    private ImageView settings;
    private MaterialTextView TV_comment, home, forums, alerts, safety, profile;
    private RecyclerView recyclerView;
    private Button BTN_add_comment;
    private EditText comment_title_EDT;
    private MaterialButton Add_Meta_BTN, Add_Comment_BTN;
    private LinearLayout lay_add_comment;
    private ArrayList<String> testArray;
    private ComentAdapter ComentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        findViews();
        barListeners();


        testArray = new ArrayList<>();
        testArray.add("Banana");
        testArray.add("Apple");
        testArray.add("Olive");
        testArray.add("Orange");
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ComentAdapter = new ComentAdapter(CommentActivity.this,testArray);
        recyclerView.setAdapter(ComentAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void findViews() {
        username = findViewById(R.id.username);
        settings = findViewById(R.id.settings);
        TV_comment = findViewById(R.id.TV_comment);
        recyclerView = findViewById(R.id.recyclerView);
        add_comment_LBL = findViewById(R.id.add_comment_LBL);
        comment_title_LBL = findViewById(R.id.comment_title_LBL);
        comment_title_EDT = findViewById(R.id.comment_title_EDT);
        comment_body_LBL = findViewById(R.id.comment_body_LBL);
        Add_Meta_BTN = findViewById(R.id.Add_Meta_BTN);
        Add_Comment_BTN = findViewById(R.id.Add_Comment_BTN);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
        BTN_add_comment= findViewById(R.id.BTN_add_comment);
        lay_add_comment = findViewById(R.id.lay_add_comment);
        lay_add_comment.setVisibility(View.GONE);
    }
    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommentActivity.this,MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommentActivity.this,ForumActivity.class));
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
                startActivity(new Intent(CommentActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommentActivity.this, EmergencyNumbersActivity.class));
            }
        });
    }
}
