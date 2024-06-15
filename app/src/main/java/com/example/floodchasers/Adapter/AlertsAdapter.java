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
import com.example.floodchasers.R;

import java.util.ArrayList;

public class AlertsAdapter extends RecyclerView.Adapter<AlertsAdapter.ViewHolder> {

    private ArrayList<String> mData;
    private Context mContext;


    public AlertsAdapter(Context context, ArrayList<String> data) {
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
        String text = mData.get(position);
//        holder.textView.setText(text);
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, MapActivity.class);
//            intent.putExtra("ITEM_TEXT", text);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView forum_title, forum_content,forum_author,forum_published_at;
        public ImageView forum_image_view;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            forum_image_view = itemView.findViewById(R.id.forum_image_view);
            forum_title = itemView.findViewById(R.id.forum_title);
            forum_content = itemView.findViewById(R.id.forum_content);
            forum_author = itemView.findViewById(R.id.forum_author);
            forum_published_at= itemView.findViewById(R.id.forum_published_at);
            cardView = itemView.findViewById(R.id.alert_card);
        }
    }
}
