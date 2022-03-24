package com.example.calsakay;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.chivorn.smartmaterialspinner.SmartMaterialSpinner;
import com.dd.CircularProgressButton;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FindDriversFragment extends Fragment{

    private SmartMaterialSpinner<String> spPickupPoint, spDropoffPoint, spPersons;
    private List<String[]> locationList;
    private List<String> personNumber = new ArrayList<>();
    private CircularProgressButton btFindDriver;
    private int btProgress, selectedPickupId, selectedDropoffId, userId, persons, listMaxPersons;
    private Bundle savedState = null;
    private Context currentContext;
    private Dashboard currentActivity;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        currentActivity = (Dashboard) getActivity();
        btFindDriver = view.findViewById(R.id.btFindDrivers);
        spPickupPoint = view.findViewById(R.id.spPickupPoint);
        spDropoffPoint = view.findViewById(R.id.spDropoffPoint);
        spPersons = view.findViewById(R.id.spPersons);
        userId = Integer.parseInt(currentActivity.getUserData().get(0)[0]);
        listMaxPersons = 20;

        for(int i = 1; i <= listMaxPersons; i++){personNumber.add(String.valueOf(i));}
        spPersons.setItem(personNumber);
        spDropoffPoint.setEnabled(false);

        spPersons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                persons = Integer.parseInt(adapterView.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spPickupPoint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedPickupId = Integer.parseInt(locationList.get(i)[0]);
                initializeDropOffLocationList(locationList, i);
                spDropoffPoint.setEnabled(true);
                btFindDriver.setVisibility(View.GONE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spDropoffPoint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedDropoffId = findSelectedItem(spDropoffPoint.getSelectedItem());
                btFindDriver.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btFindDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btFindDriver.setProgress(0);
                btFindDriver.setIndeterminateProgressMode(true);
                btFindDriver.setProgress(50);

                new FindDrivers().execute();

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_find_drivers, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        currentContext = context;
        DatabaseAccess dbAccess = new DatabaseAccess(getContext());
        dbAccess.executeQuery("SELECT * FROM locations");
    }

    public void fillPickupPoint(List<String[]> data){
        locationList = data;
        initializePickupLocationList(data);
    }

    private void initializePickupLocationList(List<String[]> data){
        List<String> pickupList = new ArrayList<>();
        for(String[] row : data) {
            pickupList.add(row[1]);
        }
        spPickupPoint.setItem(pickupList);
    }

    private void initializeDropOffLocationList(List<String[]> data, int pickupPoint){
        List<String> dropoffList = new ArrayList<>();
        for(String[] row : data) {
            dropoffList.add(row[1]);
        }
        dropoffList.remove(pickupPoint);
        spDropoffPoint.setItem(dropoffList);
    }

    private int findSelectedItem(String name){
        int id = 0;
        for(String[] row : locationList){
            if(name.contentEquals(row[1])){
                id = Integer.parseInt(row[0]);
            }
        }
        return id;
    }

        class FindDrivers extends AsyncTask<Void, Void, Void> {
        int rowCount = 5, id;
        String error;
        Statement statement;

        private void checkForDrivers(int id) throws SQLException {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS rowCount FROM calsakay_tbl_pending_rides WHERE id = " + id);

            while(resultSet.next()){
                rowCount = resultSet.getInt("rowCount");
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://163.44.242.10:3306/feqxsxpi_calsakay?characterEncoding=latin1","feqxsxpi_root", "UCC2021bsitKrazy");
                statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO calsakay_tbl_pending_rides " +
                        "SET frontliner_id = " + userId +
                        ", persons = " + persons +
                        ", pickup_point = " + selectedPickupId +
                        ", dropoff_point = " + selectedDropoffId);

                ResultSet rs= statement.getGeneratedKeys();
                if(rs.next()){
                    id = rs.getInt(1);
                }

                while(rowCount != 0){
                    checkForDrivers(id);
                }

            } catch (Exception e) {
                error = e.toString();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            currentActivity.setAccepted(true);
            super.onPostExecute(unused);
        }
    }
}