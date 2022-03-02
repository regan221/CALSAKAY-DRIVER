package com.example.calsakay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Conversation extends AppCompatActivity {

    List<ConversationModel> convo = new ArrayList<>();
    RecyclerView rvConvo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        rvConvo = findViewById(R.id.rvConversation);

        ConversationRecViewAdapter convoAdapter = new ConversationRecViewAdapter();

        convo.add(new ConversationModel("Message sent 1", "1:00pm", true));
        convo.add(new ConversationModel("Message recieved 2", "2:00pm", false));
        convo.add(new ConversationModel("Message sent 3", "3:00pm", true));
        convo.add(new ConversationModel("Message sent 4", "4:00pm", true));
        convo.add(new ConversationModel("Message sent 1", "1:00pm", true));
        convo.add(new ConversationModel("Message recieved 2", "2:00pm", false));
        convo.add(new ConversationModel("Message sent 3", "3:00pm", true));
        convo.add(new ConversationModel("Message sent 4", "4:00pm", true));
        convo.add(new ConversationModel("Message sent 1", "1:00pm", true));
        convo.add(new ConversationModel("Message recieved 2", "2:00pm", false));
        convo.add(new ConversationModel("Message sent 3", "3:00pm", true));
        convo.add(new ConversationModel("Message sent 4", "4:00pm", true));
        convo.add(new ConversationModel("Message sent 1", "1:00pm", true));
        convo.add(new ConversationModel("Message recieved 2", "2:00pm", false));
        convo.add(new ConversationModel("Message sent 3", "3:00pm", true));
        convo.add(new ConversationModel("Message sent 4", "4:00pm", true));

        convoAdapter.setConvo(convo);
        rvConvo.setAdapter(convoAdapter);
        rvConvo.setLayoutManager(new LinearLayoutManager(this));

    }
}