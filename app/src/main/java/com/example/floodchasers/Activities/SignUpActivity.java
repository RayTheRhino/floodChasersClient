package com.example.floodchasers.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.floodchasers.Api.UserApi;
import com.example.floodchasers.R;
import com.example.floodchasers.SignUp;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {
    private EditText signUp_LBL_name,signUp_LBL_password, signUp_LBL_email;
    private MaterialButton signUp_BTN_signUp;

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.0.18:5094/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private UserApi userApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        findViews();

        userApi = retrofit.create(UserApi.class);

        signUp_BTN_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("SignUpClicked", "onClick: ");
                DataFromET();

            }
        });

    }

    private void DataFromET() {
        String username = signUp_LBL_name.getText().toString();
        String email = signUp_LBL_email.getText().toString();
        String password = signUp_LBL_password.getText().toString();

        SignUp signUpData = new SignUp();

        signUpData.setUsername(username);
        signUpData.setEmail(email);
        signUpData.setPassword(password);

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
                    Intent intent = new Intent(SignUpActivity.this, MenuActivity.class);
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

    private void findViews() {
        signUp_LBL_password = findViewById(R.id.signUp_LBL_password);
        signUp_LBL_name = findViewById(R.id.signUp_LBL_name);
        signUp_LBL_email = findViewById(R.id.signUp_LBL_email);
        signUp_BTN_signUp= findViewById(R.id.signUp_BTN_signUp);

    }
}
