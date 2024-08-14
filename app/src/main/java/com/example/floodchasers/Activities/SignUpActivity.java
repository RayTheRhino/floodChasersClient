package com.example.floodchasers.Activities;

import static com.example.floodchasers.Objects.AppConfig.SERVER_URL;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.floodchasers.Api.UserApi;
import com.example.floodchasers.R;
import com.example.floodchasers.SignUp;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {
    private EditText signUp_LBL_name,signUp_LBL_password, signUp_LBL_email;
    private MaterialButton signUp_BTN_signUp,signUp_BTN_Login,signUp_BTN_uploadImg;
    private ImageView signUp_IMV_appLogo;
    private static final int PICK_IMAGE = 1;
    private Uri selectedImageUri;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private UserApi userApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViews();

        userApi = retrofit.create(UserApi.class);
        onClick();


    }

    private void onClick() {
        signUp_BTN_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SignUpClicked", "onClick: ");
                DataFromET();

            }
        });
        signUp_BTN_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });

        signUp_BTN_uploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
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
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                signUp_IMV_appLogo.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void DataFromET() {
        String username = signUp_LBL_name.getText().toString();
        String email = signUp_LBL_email.getText().toString();
        String password = signUp_LBL_password.getText().toString();

        SignUp signUpData = new SignUp();

        signUpData.setUsername(username);
        signUpData.setEmail(email);
        signUpData.setPassword(password);

        if (selectedImageUri != null) {
            // Convert the image to a Base64
            // String imageBase64 = convertImageToBase64(selectedImageUri);
            // signUpData.setProfilePicture(imageBase64);
        }

        Gson gson = new Gson();
        callBackinfo(gson.toJson(signUpData));
    }


    private void callBackinfo(String signUpData) {
        Call<Void> call = userApi.CreateNewUser(signUpData, null);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!response.isSuccessful()){

                    Toast.makeText(SignUpActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignUpActivity.this, "User signed successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
                Log.e("API_ERROR", "Request failed: " + t.getMessage());
                Toast.makeText(SignUpActivity.this, "Req failed!", Toast.LENGTH_SHORT).show();
            }

        });
    }
    /*
    private String convertImageToBase64(Uri imageUri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] imageBytes = baos.toByteArray();
            return Base64.encodeToString(imageBytes, Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    */

    private void findViews() {
        signUp_LBL_password = findViewById(R.id.signUp_LBL_password);
        signUp_LBL_name = findViewById(R.id.signUp_LBL_name);
        signUp_LBL_email = findViewById(R.id.signUp_LBL_email);
        signUp_BTN_signUp= findViewById(R.id.signUp_BTN_signUp);
        signUp_BTN_Login = findViewById(R.id.signUp_BTN_Login);
        signUp_BTN_uploadImg = findViewById(R.id.signUp_BTN_uploadImg);
        signUp_IMV_appLogo = findViewById(R.id.signUp_IMV_appLogo);
    }
}
