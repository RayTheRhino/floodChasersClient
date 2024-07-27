package com.example.floodchasers.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.floodchasers.Boundaries.Learn;
import com.example.floodchasers.R;

import java.util.ArrayList;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {
    public Context context;
    public ArrayList<Learn>learnBoundaries;
    public ArticlesAdapter(Context context, ArrayList<Learn> learnArrayList) {
        this.context = context;
        this.learnBoundaries = learnArrayList;
    }

    @NonNull
    @Override
    public ArticlesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.learn_recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesAdapter.ViewHolder holder, int position) {
        holder.bind(learnBoundaries.get(position));
    }

    @Override
    public int getItemCount() {
        return learnBoundaries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView article_title,article_content,article_url,article_published_at,article_author;
        private ImageView article_image_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            findViews();
        }

        private void findViews() {
            article_title = itemView.findViewById(R.id.article_title);
            article_content = itemView.findViewById(R.id.article_content);
            article_image_view = itemView.findViewById(R.id.article_image_view);
//            article_url = itemView.findViewById(R.id.article_url);
            article_published_at = itemView.findViewById(R.id.article_published_at);
            article_author = itemView.findViewById(R.id.article_author);
        }

        public void bind(Learn learn){
            article_title.setText(learn.getTitle());
            article_content.setText(learn.getContent());
//            article_url.setText(learnBoundary.getUrl());
            article_published_at.setText(learn.getPublishedAt());
            article_author.setText(learn.getAuthor());
            Glide.with(context).load(learn.getUrlToImage()).into(article_image_view);
        }

        public void onClick(View v) {
            String url = (String) v.getTag();
            openUrl(url);
        }

        private void openUrl(String url) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        }
    }
}
