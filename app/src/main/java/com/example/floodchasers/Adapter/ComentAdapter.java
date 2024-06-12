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
import com.example.floodchasers.R;

import java.util.ArrayList;

public class ComentAdapter extends RecyclerView.Adapter<ComentAdapter.ViewHolder> {

    private ArrayList<String> mData;
    private Context mContext;


    public ComentAdapter(Context context, ArrayList<String> data) {
        this.mData = data;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ComentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentAdapter.ViewHolder holder, int position) {
        String text = mData.get(position);
//        holder.textView.setText(text);
//        holder.cardView.setOnClickListener(v -> {
//            Intent intent = new Intent(mContext, CommentActivity.class);
//            intent.putExtra("ITEM_TEXT", text);
//            mContext.startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView comment_title, comment_content,comment_author, comment_published_at;
        public ImageView comment_image_view;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            comment_title = itemView.findViewById(R.id.comment_title);
            comment_image_view = itemView.findViewById(R.id.comment_image_view);
            comment_content = itemView.findViewById(R.id.comment_content);
            comment_author = itemView.findViewById(R.id.comment_author);
            comment_published_at = itemView.findViewById(R.id.comment_published_at);
            cardView = itemView.findViewById(R.id.comment_card);
        }
    }
}
