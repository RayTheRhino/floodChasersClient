package com.example.floodchasers.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;

public class UserProfileActivity extends AppCompatActivity {
    private TextView username,TV_profile_username, Tv_profile_status, home,forums,alerts,safety,profile;
    private ImageView settings,profile_IMV_user_profile;
    private EditText EDT_profile_status;
    private MaterialButton Add_Meta_BTN, Add_status_BTN;
    private static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_settings);
        findViews();

        Intent intent = getIntent();
        String usernameValue = intent.getStringExtra("username");

        if (usernameValue != null) {
            username.setText(usernameValue);
            TV_profile_username.setText(usernameValue);
        }
        OnClickListeners();
        BarListeners();
    }

    public void OnClickListeners(){
        Add_Meta_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        Add_status_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = EDT_profile_status.getText().toString().trim();
                if (!status.isEmpty()) {
                    saveStatus(status);
                } else {
                    Toast.makeText(UserProfileActivity.this, "Please write a status", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                profile_IMV_user_profile.setImageBitmap(bitmap);
                // Optionally, you can upload this image to your server here.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveStatus(String status) {
        // Save the status to your database or shared preferences
        Tv_profile_status.setText(status);
        EDT_profile_status.setText("");
        Toast.makeText(this, "Status updated", Toast.LENGTH_SHORT).show();
    }

    private void findViews() {
        EDT_profile_status = findViewById(R.id.EDT_profile_status);
        username = findViewById(R.id.username);
        TV_profile_username= findViewById(R.id.TV_profile_username);
        settings = findViewById(R.id.settings);
        profile_IMV_user_profile = findViewById(R.id.profile_IMV_user_profile);
        Add_Meta_BTN = findViewById(R.id.Add_Meta_BTN);
        Add_status_BTN = findViewById(R.id.Add_status_BTN);
        Tv_profile_status = findViewById(R.id.Tv_profile_status);
        home = findViewById(R.id.home);
        forums= findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
    }
    private void BarListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this,MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this,ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this,AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this, UserProfileActivity.class));
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
    }

}
