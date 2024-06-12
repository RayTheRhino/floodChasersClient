package com.example.floodchasers.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;

import androidx.cardview.widget.CardView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Activities.CommentActivity;
import com.example.floodchasers.R;

import java.util.ArrayList;

public class ComentAndForumAdapter extends RecyclerView.Adapter<ComentAndForumAdapter.ViewHolder> {

    private ArrayList<String> mData;
    private Context mContext;


    public ComentAndForumAdapter(Context context, ArrayList<String> data) {
        this.mData = data;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ComentAndForumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentAndForumAdapter.ViewHolder holder, int position) {
        String text = mData.get(position);
        holder.textView.setText(text);
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, CommentActivity.class);
//            intent.putExtra("ITEM_TEXT", text);
            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.Banana);
            cardView = itemView.findViewById(R.id.topic_card);
        }
    }
}
