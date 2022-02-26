package com.example.calsakay;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MessagesFragment extends Fragment implements DatabaseAccessCallback{

    private RecyclerView rvMessages;
    private ArrayList<Messages> messages = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.rvMessages = view.findViewById(R.id.rvMessagesContainer);
        DatabaseAccess db = new DatabaseAccess(getActivity());
//        db.executeQuery("SELECT * FROM messages WHERE ");
//        //TODO: GET THE MESSAGES(INBOX)
    }

    @Override
    public void QueryResponse(List<String[]> data) {
        messages.clear();

        for(String[] chats : data){

        }

        MessagesRecViewAdapter messageAdapter = new MessagesRecViewAdapter();
        messageAdapter.setMessages(messages);

        this.rvMessages.setAdapter(messageAdapter);
        this.rvMessages.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}