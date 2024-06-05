package com.example.floodchasers.Activities;

import static com.example.floodchasers.Objects.AppConfig.SERVER_URL;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Adapter.ArticlesAdapter;
import com.example.floodchasers.Api.LearnApi;
import com.example.floodchasers.Boundaries.LearnBoundary;
import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity  extends AppCompatActivity {

    private TextView username;
    private ImageView settings;
    private RecyclerView rv_newslist;
    private ArticlesAdapter articlesAdapter;
    private ArrayList<LearnBoundary> learnBoundaries;
    private Footer footerView;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private LearnApi learnApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        barListeners();
        footerView.updateTextColor(footerView.getHome());

        learnBoundaries = new ArrayList<LearnBoundary>();
        rv_newslist.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        articlesAdapter = new ArticlesAdapter(MainActivity.this,learnBoundaries);
        rv_newslist.setAdapter(articlesAdapter);
        learnApi = retrofit.create(LearnApi.class);
        populateArticles();
    }

    public void populateArticles(){
        Log.d("TEST", "populateArticles: ");
        learnApi.getArticles().enqueue(new Callback<List<LearnBoundary>>() {
            @Override
            public void onResponse(Call<List<LearnBoundary>> call, Response<List<LearnBoundary>> response) {
                if(!response.isSuccessful()){

                    Toast.makeText(MainActivity.this, "Failed to get articles", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Got articles", Toast.LENGTH_SHORT).show(); //remove later
                    learnBoundaries.addAll(response.body());
                    articlesAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<LearnBoundary>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to send get articles", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void barListeners() {
        footerView.setHomeButtonClickListener(view ->
                startActivity(new Intent(MainActivity.this,MainActivity.class))
        );
        footerView.setForumsButtonClickListener(view ->
                startActivity(new Intent(MainActivity.this, ForumActivity.class))
        );
        footerView.setSafetyButtonClickListener(view ->
                startActivity(new Intent(MainActivity.this, SafetyActivity.class))
        );
        footerView.setAlertsButtonClickListener(view ->
                startActivity(new Intent(MainActivity.this, AlertsActivity.class))
        );
    }
    private void findViews() {
        username = findViewById(R.id.username);
        settings = findViewById(R.id.settings);
        footerView = findViewById(R.id.footerView);
        rv_newslist = findViewById(R.id.rv_newslist);
    }
}
