package com.example.floodchasers.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.floodchasers.Boundaries.ForumBoundary;
import com.example.floodchasers.R;

import java.util.ArrayList;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.ViewHolder> {
    public Context context;
    private int currPosition;
    public ArrayList<ForumBoundary> forumBoundaries;

//    private boolean showNameOnly = false;

    public ForumAdapter(Context context, ArrayList<ForumBoundary> forumBoundaries){
        this.context = context;
        this.forumBoundaries = forumBoundaries;
        currPosition = 0;
    }
    @NonNull
    @Override
    public ForumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_forum, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumAdapter.ViewHolder holder, int position) {
        currPosition = position;
        holder.bind(forumBoundaries.get(position));
    }


    @Override
    public int getItemCount() {
        return forumBoundaries.size();
    }
//
//    public void setContact(List<Contact> contacts) {
//        this.contacts = contacts;
//        notifyDataSetChanged();
//    }
//
//    public Contact getContactPos(int position) {
//        return contacts.get(position);
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView forum_image_view;
    private TextView forum_title, forum_body, forum_created_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            findViews();
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int position = getAbsoluteAdapterPosition();
//                    if (listener != null && position != RecyclerView.NO_POSITION) {
//                        listener.onItemClick(contacts.get(position));
//                    }
//                }
//            });
        }
        private void findViews() {
            forum_title = itemView.findViewById(R.id.forum_title);
            forum_body = itemView.findViewById(R.id.forum_body);
            forum_created_time = itemView.findViewById(R.id.forum_created_time);
        }
        public void bind(ForumBoundary forumBoundary){
            forum_title.setText(forumBoundary.getPosts().get(currPosition).getTitle());
            forum_body.setText(forumBoundary.getPosts().get(currPosition).getBody());
            forum_created_time.setText(forumBoundary.getPosts().get(currPosition).getTimeCreated());
        }
    }



//    public interface OnItemClickListener {
//        void onItemClick(Contact contact);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener listener) {
//        this.listener = listener;
//    }
//

}
