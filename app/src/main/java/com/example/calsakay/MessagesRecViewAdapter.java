package com.example.calsakay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessagesRecViewAdapter extends RecyclerView.Adapter<MessagesRecViewAdapter.ViewHolder>{

    private List<Messages> messages;

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvMessageSender.setText(messages.get(position).getThreadName());
        holder.tvMessagePreview.setText(messages.get(position).getMessage());
        if(messages.get(position).isRead() == false){
            holder.ivIsRead.setVisibility(View.VISIBLE);
        } else {
            holder.ivIsRead.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return this.messages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvMessageSender, tvMessagePreview;
        private ImageView ivIsRead;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMessageSender = itemView.findViewById(R.id.tvMessageSender);
            tvMessagePreview = itemView.findViewById(R.id.tvMessagePreview);
            ivIsRead = itemView.findViewById(R.id.ivIsRead);
        }
    }
}
