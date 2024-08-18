package com.example.floodchasers.Activities;

import static com.example.floodchasers.Objects.AppConfig.SERVER_URL;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Adapter.AlertsAdapter;
import com.example.floodchasers.Api.AlertsApi;
import com.example.floodchasers.Classes.AlertReceiver;
import com.example.floodchasers.Objects.Alert;
import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserSettingsActivity extends AppCompatActivity {
    private TextView username, alertsTitleTextView, TV_set_alert, TV_update_timing, tv_choose_alert;
    private ImageView settings;
    private EditText EDt_choose_alert;
    private ToggleButton TB_set_alert;
    private Spinner Sp_update_timing_spinner;
    private MaterialButton Enter_location_BTN;
    private MaterialTextView home,forums,alerts,safety,profile;
    private RecyclerView alertsRecyclerView;
    private AlertsAdapter alertsAdapter;
    private ArrayList<Alert> alertArray = new ArrayList<>();
    private AlertsApi alertApi;
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private SharedPreferences sharedPrefAlertNotification;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts_notifications);
        findViews();
        initSpinner();
        Intent intent = getIntent();
        String usernameValue = intent.getStringExtra("username");

        if (usernameValue != null) {
            username.setText(usernameValue);
        }

        alertApi = retrofit.create(AlertsApi.class);
        ClickListeners();

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "FloodAlertsChannel",
                    "Flood Alerts",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("Channel for the flood alerts");
            notificationManager.createNotificationChannel(channel);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(UserSettingsActivity.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(UserSettingsActivity.this, new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

    }
    private long getDelayForFrequency(String frequency) {
        switch (frequency.toLowerCase()) {
            case "day":
                return 5 * 1000; // 30 seconds
            case "week":
                return 2 * 60 * 1000; // 2 minutes
            case "month":
                return 5 * 60 * 1000; // 5 minutes
            default:
                return 30 * 1000; // Default to 30 seconds if frequency is not recognized
        }
    }

    private void scheduleNotification(String location, long delay) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        intent.putExtra("location", location);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        long triggerTime = System.currentTimeMillis() + delay;
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);
    }
    private void ClickListeners() {
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserSettingsActivity.this, UserSettingsActivity.class);
                startActivity(intent);
            }
        });
        Enter_location_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Locations = EDt_choose_alert.getText().toString().trim();
                SharedPreferences.Editor editor = sharedPrefAlertNotification.edit();
                editor.putString("Locations",Locations).apply();
                Toast.makeText(UserSettingsActivity.this, "Location Saved: " + Locations, Toast.LENGTH_SHORT).show();

                // Get the selected frequency from the spinner
                String frequency = Sp_update_timing_spinner.getSelectedItem().toString();

                // Schedule a notification based on the selected frequency
                long delay = getDelayForFrequency(frequency);
                scheduleNotification(Locations, delay);
            }
        });

        boolean isAlertChecked = sharedPrefAlertNotification.getBoolean("toggle_state", false);
        TB_set_alert.setChecked(isAlertChecked);
        TB_set_alert.setOnCheckedChangeListener((buttonView, isChecked) -> {
            sharedPrefAlertNotification.edit().putBoolean("IsAlertOn", isChecked).apply();
            if (isChecked) {
                sendPushNotification("Alert Enabled", "You have turned on flood alerts.");
            }else{
                notificationManager.cancelAll();
            }
        });
    }
    private void sendPushNotification(String title, String message) {
        Intent intent = new Intent(this, AlertsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "FloodAlertsChannel")
                .setSmallIcon(R.drawable.alert) // Replace with your app's icon
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        notificationManager.notify(1, builder.build());
    }

    private void findViews() {
        username = findViewById(R.id.username);
        home = findViewById(R.id.profile);
        forums = findViewById(R.id.forums);
        alerts = findViewById(R.id.alerts);
        safety = findViewById(R.id.safety);
        profile = findViewById(R.id.profile);
        alertsTitleTextView = findViewById(R.id.alertsTitleTextView);
        TV_set_alert = findViewById(R.id.TV_set_alert);
        TV_update_timing = findViewById(R.id.TV_update_timing);
        tv_choose_alert = findViewById(R.id.tv_choose_alert);
        settings = findViewById(R.id.settings);
        EDt_choose_alert = findViewById(R.id.EDt_choose_alert);
        TB_set_alert = findViewById(R.id.TB_set_alert);
        Sp_update_timing_spinner = findViewById(R.id.Sp_update_timing_spinner);
        Enter_location_BTN = findViewById(R.id.Enter_location_BTN) ;
        sharedPrefAlertNotification =  getSharedPreferences("AlertNotification", Context.MODE_PRIVATE);
    }
    private void initSpinner() {
        ArrayList<String> datesRange = new ArrayList<>();
        datesRange.add("day");
        datesRange.add("week");
        datesRange.add("month");
        Sp_update_timing_spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datesRange));
        String hey = Sp_update_timing_spinner.getSelectedItem().toString();

    }

    private void barListeners() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserSettingsActivity.this,MainActivity.class));
            }
        });
        forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserSettingsActivity.this,ForumActivity.class));
            }
        });
        alerts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserSettingsActivity.this,AlertsActivity.class));
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserSettingsActivity.this, SafetyActivity.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserSettingsActivity.this, UserProfileActivity.class));
            }
        });
    }

}
