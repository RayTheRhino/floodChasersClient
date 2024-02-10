package com.example.floodchasers.Activities;

import static com.example.floodchasers.Objects.AppConfig.SERVER_URL;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.Api.UserApi;
import com.example.floodchasers.Objects.User;
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
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private UserApi userApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();

        userApi = retrofit.create(UserApi.class);
        onClick();
    }

    private void onClick() {
        signIn_login_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentEmail = signIN_LBL_email.getText().toString();
                String currentPassword = signIN_LBL_password.getText().toString();
                callBackinfo(currentEmail, currentPassword);

            }
        });

        signIn_BTN_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }


    private void callBackinfo(String email, String password) {
        Call<User> call = userApi.LoggedInUser(email, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){

                    Toast.makeText(SignInActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignInActivity.this, "User signed In successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                Log.e("LoggedInUser", "onFailure: ",throwable );
                Toast.makeText(SignInActivity.this, "Email or password incorrect!", Toast.LENGTH_LONG).show();

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
