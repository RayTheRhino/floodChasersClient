package com.example.floodchasers.Activities;

import static com.example.floodchasers.Objects.AppConfig.SERVER_URL;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

import com.example.floodchasers.Adapter.CommentAdapter;
import com.example.floodchasers.Api.CommentApi;
import com.example.floodchasers.Api.PostApi;
import com.example.floodchasers.Boundaries.Comment;
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

public class CommentActivity extends AppCompatActivity {
    private TextView username, add_comment_LBL, comment_title_LBL, comment_body_LBL, TV_forum_topic;
    private ImageView settings;
    private MaterialTextView TV_comment, home, forums, alerts, safety, profile;
    private RecyclerView recyclerView;
    private Button BTN_add_comment;
    private EditText comment_title_EDT,comment_body_Edt;
    private MaterialButton Add_Meta_BTN, Add_Comment_BTN;
    private LinearLayout lay_add_comment;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private CommentApi commentApi;
    private PostApi postApi;
    private CommentAdapter adapter;
    private List<Comment> commentArray = new ArrayList<>();
    private String postId, postBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        findViews();

        Intent intent = getIntent();
        String usernameValue = intent.getStringExtra("username");

        if (usernameValue != null) {
            username.setText(usernameValue);
        }

        barListeners();
        ClickListeners();

        commentApi = retrofit.create(CommentApi.class);
        postApi = retrofit.create(PostApi.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CommentAdapter(CommentActivity.this, commentArray);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        //GetAllComments();
    }

    private void ClickListeners() {
        BTN_add_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lay_add_comment.getVisibility() == View.VISIBLE) {
                    lay_add_comment.setVisibility(View.GONE);
                } else {
                    lay_add_comment.setVisibility(View.VISIBLE);
                }
            }
        });

        Add_Comment_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = comment_title_EDT.getText().toString();
                String body = comment_body_Edt.getText().toString();
                createComment(title, body);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommentActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void GetAllComments() {
        commentApi.GetAllComments().enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful()) {

                    Toast.makeText(CommentActivity.this, "Cant get comments!", Toast.LENGTH_SHORT).show();
                } else {
                    commentArray.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                Toast.makeText(CommentActivity.this, "Cent get posts!", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void createComment(String title, String body) {
        Comment newComment = new Comment();
        newComment.setId(UUID.randomUUID().toString());
        newComment.setTitle(title);
        newComment.setBody(body.toString());

        postApi.AddCommentToPost(newComment,postId).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CommentActivity.this, "Comment Created Succesfully", Toast.LENGTH_SHORT).show();
                    Post post = response.body();
                    //todo:might cuse truble
                    comment_body_Edt.setText("");
                    comment_title_EDT.setText("");
                    commentArray.clear();
                    commentArray.addAll(post.comments);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(CommentActivity.this, "Failed to create commnet", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(CommentActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
        comment_body_Edt = findViewById(R.id.comment_body_Edt);
        Add_Meta_BTN = findViewById(R.id.Add_Meta_BTN);
        Add_Comment_BTN = findViewById(R.id.Add_Comment_BTN);
        home = findViewById(R.id.home);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
        TV_forum_topic = findViewById(R.id.TV_forum_topic);
        BTN_add_comment = findViewById(R.id.BTN_add_comment);
        lay_add_comment = findViewById(R.id.lay_add_comment);
        lay_add_comment.setVisibility(View.GONE);

        Intent intent = getIntent();
        postId = intent.getStringExtra("POST_ID");
        postBody = intent.getStringExtra("POST_BODY");
        TV_forum_topic.setText(postBody);
    }

    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommentActivity.this, MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommentActivity.this, ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommentActivity.this, AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommentActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CommentActivity.this, UserProfileActivity.class));
            }
        });
    }
}
