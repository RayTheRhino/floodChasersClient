package com.example.floodchasers.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Activities.CommentActivity;
import com.example.floodchasers.Activities.MapActivity;
import com.example.floodchasers.Objects.Alert;
import com.example.floodchasers.R;

import java.util.ArrayList;

public class AlertsAdapter extends RecyclerView.Adapter<AlertsAdapter.ViewHolder> {

    private ArrayList<Alert> mData;
    private Context mContext;


    public AlertsAdapter(Context context, ArrayList<Alert> data) {
        this.mData = data;
        this.mContext = context;
    }

    @NonNull
    @Override
    public AlertsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.alert_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlertsAdapter.ViewHolder holder, int position) {
        Alert currentAlert = mData.get(position);

        holder.alert_headline_Tv.setText(currentAlert.getHeadline());
        holder.alert_description_Tv.setText(currentAlert.getDescription());
        holder.alert_area_Tv.setText(currentAlert.getAreas());
        holder.alert_severity_Tv.setText(currentAlert.getSeverity());
        holder.alert_time_created_Tv.setText(currentAlert.getTimeCreated().toString());

        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, MapActivity.class);
            intent.putExtra("latitude", currentAlert.getLat());
            intent.putExtra("longitude", currentAlert.getLang());
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView alert_headline_Tv, alert_time_created_Tv,alert_severity_Tv,alert_area_Tv,alert_description_Tv;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            alert_headline_Tv = itemView.findViewById(R.id.alert_headline_Tv);
            alert_time_created_Tv = itemView.findViewById(R.id.alert_time_created_Tv);
            alert_severity_Tv = itemView.findViewById(R.id.alert_severity_Tv);
            alert_area_Tv = itemView.findViewById(R.id.alert_area_Tv);
            alert_description_Tv= itemView.findViewById(R.id.alert_description_Tv);
            cardView = itemView.findViewById(R.id.alert_card);
        }
    }
}
