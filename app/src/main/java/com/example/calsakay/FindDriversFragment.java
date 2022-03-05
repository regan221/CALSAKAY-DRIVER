package com.example.calsakay;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.chivorn.smartmaterialspinner.SmartMaterialSpinner;
import com.dd.CircularProgressButton;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FindDriversFragment extends Fragment {

    private SmartMaterialSpinner<String> spPickupPoint, spDropoffPoint;
    private List<String> pickupList, dropoffList;
    private CircularProgressButton btFindDriver;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btFindDriver = view.findViewById(R.id.btFindDrivers);
        spPickupPoint = view.findViewById(R.id.spPickupPoint);
        spDropoffPoint = view.findViewById(R.id.spDropoffPoint);
        pickupList = new ArrayList<>();
        dropoffList = new ArrayList<>();

        pickupList.add("pick 1");
        pickupList.add("asd");
        pickupList.add("meme");
        pickupList.add("hahaha");

        spPickupPoint.setItem(pickupList);

        dropoffList.add("pick 1");
        dropoffList.add("asd");
        dropoffList.add("meme");
        dropoffList.add("hahaha");

        spDropoffPoint.setItem(dropoffList);

        btFindDriver.setProgress(0);
        btFindDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btFindDriver.setProgress(0);
                btFindDriver.setIndeterminateProgressMode(true);
                btFindDriver.setProgress(50);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find_drivers, container, false);

    }

}