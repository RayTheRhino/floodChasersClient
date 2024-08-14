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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Adapter.PostAdapter;
import com.example.floodchasers.Api.PostApi;
import com.example.floodchasers.Objects.Post;
import com.example.floodchasers.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForumActivity extends AppCompatActivity {
    private TextView username, TV_Forums, add_comment_LBL, comment_title_LBL, comment_body_LBL;
    private ImageView settings, Edit_Comment_IV;
    private EditText comment_title_EDT, comment_body_Edt;
    private LinearLayout lay_add_forum_topic;
    private MaterialTextView home, forums, alerts, safety, profile;
    private RecyclerView RV_forum;
    private MaterialButton Add_Meta_BTN, Add_Comment_BTN;
    private Button BTN_add_topic;
    private PostAdapter adapter;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private PostApi postApi;
    private List<Post> postArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forums);
        findViews();

        Intent intent = getIntent();
        String usernameValue = intent.getStringExtra("username");

        if (usernameValue != null) {
            username.setText(usernameValue);
        }

        barListeners();
        ClickListeners();


        postApi = retrofit.create(PostApi.class);
        RV_forum.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter(ForumActivity.this, postArray);
        RV_forum.setAdapter(adapter);
        RV_forum.setHasFixedSize(true);
        GetAllPosts();
    }

    private void ClickListeners() {
        BTN_add_topic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lay_add_forum_topic.getVisibility() == View.VISIBLE) {
                    lay_add_forum_topic.setVisibility(View.GONE);
                } else {
                    lay_add_forum_topic.setVisibility(View.VISIBLE);
                }
            }
        });

        Add_Comment_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = comment_title_EDT.getText().toString();
                String body = comment_body_Edt.getText().toString();
                createPost(title,body);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForumActivity.this, UserSettingsActivity.class);
                startActivity(intent);

            }
        });
    }

    private void GetAllPosts() {
      postApi.GetPosts().enqueue(new Callback<List<Post>>() {
          @Override
          public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
              if(!response.isSuccessful()){

                  Toast.makeText(ForumActivity.this, "Cant get posts!", Toast.LENGTH_SHORT).show();
              }
              else {
                  postArray.addAll(response.body());
                  adapter.notifyDataSetChanged();
              }
          }

          @Override
          public void onFailure(Call<List<Post>> call, Throwable t) {
              Toast.makeText(ForumActivity.this, "Cent get posts!", Toast.LENGTH_SHORT).show();
          }
      });
    }
    private void createPost(String title, String body) {
        Post newPost = new Post();
        newPost.setId(UUID.randomUUID().toString());
        newPost.setTitle(title);
        newPost.setBody(body);

        postApi.CreatePost(newPost).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(ForumActivity.this, "Post created successfully", Toast.LENGTH_SHORT).show();
                    comment_title_EDT.setText("");
                    comment_body_Edt.setText("");
                    GetAllPosts();
                } else {
                    Toast.makeText(ForumActivity.this, "Failed to create post", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(ForumActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForumActivity.this, MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForumActivity.this, ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForumActivity.this,AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForumActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForumActivity.this, UserProfileActivity.class));
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
