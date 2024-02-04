package com.example.floodchasers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.Api.UserApi;
import com.example.floodchasers.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignInActivity extends AppCompatActivity {

    private ImageView main_IMV_appLogo;
    private EditText signIN_LBL_email, signIN_LBL_password;
    private MaterialButton signIn_login_BTN, signIn_BTN_forgotPassword, signIn_BTN_SignUp;
    private MaterialTextView signIn_LBL_loginQ;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.0.18:5094/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private UserApi userApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();

        userApi = retrofit.create(UserApi.class);
    }

    private void callBackinfo(String signUpData) {
        Call<JsonObject> call = userApi.getUserById("yourUserId");

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject userJson = response.body();

                    String userId = userJson.get("userId").getAsString();
                    String email = userJson.get("email").getAsString();
                    String userName = userJson.get("userName").getAsString();

                    if (!response.isSuccessful()) {
                        Toast.makeText(SignInActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignInActivity.this, "User Logged In successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignInActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                t.printStackTrace();
                Log.e("API_ERROR", "Request failed: " + t.getMessage());
                Toast.makeText(SignInActivity.this, "Req failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void findViews() {
        main_IMV_appLogo = findViewById(R.id.main_IMV_appLogo);
        signIN_LBL_email = findViewById(R.id.signIN_LBL_email);
        signIN_LBL_password = findViewById(R.id.signIN_LBL_password);
        signIn_login_BTN = findViewById(R.id.signIn_login_BTN);
        signIn_BTN_forgotPassword = findViewById(R.id.signIn_BTN_forgotPassword);
        signIn_BTN_SignUp = findViewById(R.id.signIn_BTN_SignUp);
        signIn_LBL_loginQ = findViewById(R.id.signIn_LBL_loginQ);
    }
}
