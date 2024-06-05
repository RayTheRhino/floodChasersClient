package com.example.floodchasers.Views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.example.floodchasers.R;
import com.google.android.material.textview.MaterialTextView;

public class Footer extends LinearLayout {

    private MaterialTextView home;
    private MaterialTextView forums;
    private MaterialTextView safety;
    private MaterialTextView alerts;
    private MaterialTextView profile;

    public Footer(Context context) {
        super(context);
        initializeViews(context);
    }

    public Footer(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public Footer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.footer, this);

        home = view.findViewById(R.id.home);
        forums = view.findViewById(R.id.forums);
        safety = view.findViewById(R.id.safety);
        alerts = view.findViewById(R.id.alerts);
        profile = view.findViewById(R.id.profile);
        home.setTextColor(ContextCompat.getColor(getContext(), R.color.primary_color));
        home.setTypeface(null, Typeface.BOLD);
    }

    public void setHomeButtonClickListener(OnClickListener listener) {
        home.setOnClickListener(listener);
    }

    public void setForumsButtonClickListener(OnClickListener listener) {
        forums.setOnClickListener(listener);
    }

    public void setSafetyButtonClickListener(OnClickListener listener) {
        safety.setOnClickListener(listener);
    }

    public void setAlertsButtonClickListener(OnClickListener listener) {
        alerts.setOnClickListener(listener);
    }

    public void setProfileButtonClickListener(OnClickListener listener) {
        profile.setOnClickListener(listener);
    }

    public MaterialTextView getHome() {
        return home;
    }

    public MaterialTextView getForums() {
        return forums;
    }

    public MaterialTextView getSafety() {
        return safety;
    }

    public MaterialTextView getAlerts() {
        return alerts;
    }

    public MaterialTextView getProfile() {
        return profile;
    }

    public void updateTextColor(MaterialTextView textView) {
        home.setTextColor(ContextCompat.getColor(getContext(), R.color.text_black));
        forums.setTextColor(ContextCompat.getColor(getContext(), R.color.text_black));
        safety.setTextColor(ContextCompat.getColor(getContext(), R.color.text_black));
        alerts.setTextColor(ContextCompat.getColor(getContext(), R.color.text_black));
        profile.setTextColor(ContextCompat.getColor(getContext(), R.color.text_black));
        home.setTypeface(null, Typeface.NORMAL);
        forums.setTypeface(null, Typeface.NORMAL);
        safety.setTypeface(null, Typeface.NORMAL);
        alerts.setTypeface(null, Typeface.NORMAL);
        profile.setTypeface(null, Typeface.NORMAL);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.primary_color));
    }
}
