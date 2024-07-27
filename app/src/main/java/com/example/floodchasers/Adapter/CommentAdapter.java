package com.example.floodchasers.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.floodchasers.Boundaries.Comment;
import com.example.floodchasers.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private List<Comment> comments;
    private Context context;


    public CommentAdapter(Context context, List<Comment> comments) {
        this.comments = comments;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int position) {
        holder.bind(comments.get(position));
        holder.cardView.setOnClickListener(v->{

        });
//        String text = data.get(position);
//        holder.textView.setText(text);
//        holder.cardView.setOnClickListener(v -> {
//            Intent intent = new Intent(mContext, CommentActivity.class);
//            intent.putExtra("ITEM_TEXT", text);
//            mContext.startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView comment_title, comment_content,comment_author, comment_published_at;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
           findViews();
        }
        public void findViews(){
            comment_title = itemView.findViewById(R.id.comment_title);
            comment_content = itemView.findViewById(R.id.comment_content);
            comment_author = itemView.findViewById(R.id.comment_author);
            comment_published_at = itemView.findViewById(R.id.comment_published_at);
            cardView = itemView.findViewById(R.id.comment_card);
        }
        public void bind(Comment comment){
            comment_title.setText(comment.getTitle());
//            commen.setText(comment.getBody());
            comment_published_at.setText(comment.getTimeCreated());
        }
    }
}
