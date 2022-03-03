package com.example.calsakay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dd.CircularProgressButton;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ConversationRecViewAdapter extends RecyclerView.Adapter<ConversationRecViewAdapter.ViewHolder> {

    List<ConversationModel> convo;

    public void setConvo(List<ConversationModel> convo) {
        this.convo = convo;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ConversationRecViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conversation_item, parent, false);
        ConversationRecViewAdapter.ViewHolder holder = new ConversationRecViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationRecViewAdapter.ViewHolder holder, int position) {

        if (convo.get(position).getMessageType().contentEquals("outgoing")){
            holder.tvMessageSent.setText(convo.get(position).getMessageContent());
            holder.tvConversationSentTime.setText(convo.get(position).getMessageTimestamp());
            holder.cvConversationSent.setVisibility(View.VISIBLE);
            holder.cvConversationRecieved.setVisibility(View.GONE);
        } else {
            holder.tvMessageRecieved.setText(convo.get(position).getMessageContent());
            holder.tvConversationRecievedTime.setText(convo.get(position).getMessageTimestamp());
            holder.cvConversationRecieved.setVisibility(View.VISIBLE);
            holder.cvConversationSent.setVisibility(View.GONE);
        }
    }



    @Override
    public int getItemCount() {
        return this.convo.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvMessageRecieved, tvMessageSent, tvConversationRecievedTime, tvConversationSentTime;
        private MaterialCardView cvConversationRecieved, cvConversationSent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMessageSent = itemView.findViewById(R.id.tvMessageSent);
            tvMessageRecieved = itemView.findViewById(R.id.tvMessageRecieved);
            tvConversationRecievedTime = itemView.findViewById(R.id.tvConversationRecievedTime);
            tvConversationSentTime = itemView.findViewById(R.id.tvConversationSentTime);
            cvConversationRecieved = itemView.findViewById(R.id.cvConversationRecieved);
            cvConversationSent = itemView.findViewById(R.id.cvConversationSend);
        }
    }
}


