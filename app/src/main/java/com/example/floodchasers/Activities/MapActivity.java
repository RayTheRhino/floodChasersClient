package com.example.floodchasers.Activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.floodchasers.Fragment.MapsFragment;
import com.example.floodchasers.R;
import com.example.floodchasers.Views.Footer;

public class MapActivity extends AppCompatActivity {
    private Footer footerView;
    private FrameLayout frame_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        findViews();
        Fragment fragment = new MapsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

    private void findViews() {
        frame_layout = findViewById(R.id.frame_layout);
        footerView = findViewById(R.id.footerView);
    }
}
