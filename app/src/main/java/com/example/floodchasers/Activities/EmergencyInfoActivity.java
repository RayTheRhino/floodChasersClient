package com.example.floodchasers.Activities;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.floodchasers.R;
import com.google.android.material.button.MaterialButton;

public class EmergencyInfoActivity extends AppCompatActivity {
    private EditText signUp_LBL_name,signUp_LBL_password, signUp_LBL_email;
    private MaterialButton signUp_BTN_signUp,signUp_BTN_Login,signUp_BTN_uploadImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_info);
        findViews();


//        onClick();


    }

//    private void onClick() {
//        signUp_BTN_signUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("SignUpClicked", "onClick: ");
//                DataFromET();
//
//            }
//        });
//        signUp_BTN_Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(EmergencySettingsActivity.this, SignInActivity.class);
//                startActivity(intent);
//            }
//        });
//
//
//    }

//    private void DataFromET() {
//        String username = signUp_LBL_name.getText().toString();
//        String email = signUp_LBL_email.getText().toString();
//        String password = signUp_LBL_password.getText().toString();
//
//        SignUp signUpData = new SignUp();
//
//        signUpData.setUsername(username);
//        signUpData.setEmail(email);
//        signUpData.setPassword(password);
//
//        Gson gson = new Gson();
//        callBackinfo(gson.toJson(signUpData));
//    }


//    private void callBackinfo(String signUpData) {
//        Call<Void> call = userApi.CreateNewUser(signUpData, null);
//
//        call.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if(!response.isSuccessful()){
//
//                    Toast.makeText(EmergencySettingsActivity.this, "Error!", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(EmergencySettingsActivity.this, "User signed successfully", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(EmergencySettingsActivity.this, MenuActivity.class);
//                    startActivity(intent);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                t.printStackTrace();
//                Log.e("API_ERROR", "Request failed: " + t.getMessage());
//                Toast.makeText(EmergencySettingsActivity.this, "Req failed!", Toast.LENGTH_SHORT).show();
//            }
//
//        });
//    }

    private void findViews() {
        signUp_LBL_password = findViewById(R.id.signUp_LBL_password);
        signUp_LBL_name = findViewById(R.id.signUp_LBL_name);
        signUp_LBL_email = findViewById(R.id.signUp_LBL_email);
        signUp_BTN_signUp= findViewById(R.id.signUp_BTN_signUp);
        signUp_BTN_Login = findViewById(R.id.signUp_BTN_Login);
        signUp_BTN_uploadImg = findViewById(R.id.signUp_BTN_uploadImg);
    }
}
