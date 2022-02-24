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

public class MessagesFragment extends Fragment {

    private RecyclerView rvMessages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvMessages = view.findViewById(R.id.rvMessagesContainer);

        ArrayList<Messages> messages = new ArrayList<>();

        messages.add(new Messages("Driver 1", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 12", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 16", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 1", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 12", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 16", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 1", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 12", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 16", "Nandito nako maam", "Feb 22 2022 1:00pm"));messages.add(new Messages("Driver 1", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 12", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 16", "Nandito nako maam", "Feb 22 2022 1:00pm"));messages.add(new Messages("Driver 1", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 12", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 16", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 1", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 12", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 16", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 1", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 12", "Nandito nako maam", "Feb 22 2022 1:00pm"));
        messages.add(new Messages("Driver 16", "Nandito nako maam", "Feb 22 2022 1:00pm"));



        MessagesRecViewAdapter messageAdapter = new MessagesRecViewAdapter();
        messageAdapter.setMessages(messages);

        rvMessages.setAdapter(messageAdapter);
        rvMessages.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}