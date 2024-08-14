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
import com.example.floodchasers.Boundaries.Comment;
import com.example.floodchasers.Objects.Post;
import com.example.floodchasers.R;

import java.io.Serializable;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    public Context context;
    public List<Post> posts;

    public PostAdapter(Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }
    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.card_layout_thread, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.bind(posts.get(position));

        holder.postView.setOnClickListener(v -> {
            Post selectedPost = posts.get(position);
            String postId = selectedPost.getId();
            String postBody = selectedPost.getBody();
            List<Comment> postComments = selectedPost.getComments();

            Intent intent = new Intent(context, CommentActivity.class);
            intent.putExtra("POST_ID", postId);
            intent.putExtra("POST_BODY",postBody);
            intent.putExtra("POST_COMMENTS",(Serializable) postComments);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView forum_image_view;
    private TextView forum_title, forum_body, forum_created_time;
    private CardView postView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            findViews();
        }
        private void findViews() {
            forum_title = itemView.findViewById(R.id.forum_title);
            forum_body = itemView.findViewById(R.id.forum_body);
            forum_created_time = itemView.findViewById(R.id.forum_created_time);
            postView = itemView.findViewById(R.id.post_card);
        }
        public void bind(Post post){
            forum_title.setText(post.getTitle());
            forum_body.setText(post.getBody());
            forum_created_time.setText(post.getTimeCreated());
        }
    }

}
