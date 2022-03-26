package com.example.calsakay;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class PassengerAcceptedFragment extends Fragment {
    private int driverId, userId, rideTraceId, rideStatus;
    String[] rideStatusText = {
            "Your driver will be picking you up now!",
            "You have been picked up!",
            "You are now on the way to your destination.",
    };
    ImageView ivDriverImage;
    FloatingActionMenu fmPassengerAcceptedMenu;
    FloatingActionButton fbPassengerAcceptedMenuItem1, fbPassengerAcceptedMenuItem2;
    TextView tvRideStatus, tvDriverName, tvDriverMobileNumber, tvDriverVehicleType, tvDriverPlateNumber, tvDriveEmail;
    Context currentContext;
    Dashboard currentActivity;
    List<String[]> driverDetails;
    Messages messageData;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.ivDriverImage = view.findViewById(R.id.ivDriverImage);
        this.fmPassengerAcceptedMenu = view.findViewById(R.id.fmPassengerAcceptedMenu);
        this.fbPassengerAcceptedMenuItem1 = view.findViewById(R.id.fbPassengerAcceptedMenuItem1);
        this.fbPassengerAcceptedMenuItem2 = view.findViewById(R.id.fbPassengerAcceptedMenuItem2);
        this.tvRideStatus = view.findViewById(R.id.tvRideStatus);
        this.tvDriverName = view.findViewById(R.id.tvDriverName);
        this.tvDriverMobileNumber = view.findViewById(R.id.tvDriverMobileNumber);
        this.tvDriverVehicleType = view.findViewById(R.id.tvDriverVehicleType);
        this.tvDriverPlateNumber = view.findViewById(R.id.tvDriverPlateNumber);
        this.tvDriveEmail = view.findViewById(R.id.tvDriveEmail);
        this.currentActivity = (Dashboard) getActivity();
        this.userId = Integer.parseInt(currentActivity.getUserData().get(0)[0]);

        this.fbPassengerAcceptedMenuItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoConvo = new Intent(currentContext, Conversation.class);
                gotoConvo.putExtra("messageData", messageData);
                currentContext.startActivity(gotoConvo);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_passenger_accepted, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.driverId = getArguments().getInt("driverId");
        this.rideTraceId = getArguments().getInt("rideTraceId");
        this.currentContext = context;
        DatabaseAccess dbAccess = new DatabaseAccess(context);
        dbAccess.executeQuery("SELECT *, 'DRIVER DETAILS' as Data FROM calsakay_tbl_users WHERE id = " + this.driverId);
    }

    public void setDriverDetails(List<String[]> data){
        this.driverDetails = data;

        String driverImageValue = this.driverDetails.get(0)[22],
                driverNameValue = this.driverDetails.get(0)[1] + " " + this.driverDetails.get(0)[2],
                driverMobileNo = this.driverDetails.get(0)[5],
                driverVehicle = this.driverDetails.get(0)[17],
                driverPlateNo = this.driverDetails.get(0)[18],
                driverEmail = this.driverDetails.get(0)[21];

        InputStream stream = new ByteArrayInputStream(Base64.decode(driverImageValue.getBytes(), Base64.DEFAULT));
        Bitmap chatImageBitmap = BitmapFactory.decodeStream(stream);
        this.tvRideStatus.setText(rideStatusText[0]);
        this.ivDriverImage.setImageBitmap(chatImageBitmap);
        this.tvDriverMobileNumber.setText(this.tvDriverMobileNumber.getText() + driverMobileNo);
        this.tvDriverVehicleType.setText(this.tvDriverVehicleType.getText() + driverVehicle);
        this.tvDriverPlateNumber.setText(this.tvDriverPlateNumber.getText() + driverPlateNo);
        this.tvDriveEmail.setText(this.tvDriveEmail.getText() + driverEmail);
        this.tvDriverName.setText(this.tvDriverName.getText() + driverNameValue);

        DatabaseAccess dbAccess = new DatabaseAccess(currentContext);
        dbAccess.executeQuery("SELECT calsakay_tbl_users.user_image AS chatmateImage, " +
                "CONCAT(calsakay_tbl_users.first_name, ' ', calsakay_tbl_users.last_name) AS threadName, " +
                "IF(messages.sender = " + this.userId + ", 'outgoing', 'ingoing') AS messageType, " +
                "messages.sender, messages.reciever, messages.message_id, messages.message, messages.read, messages.time, messages.read, 'PASSENGER DETAILS' as Data " +
                "FROM `messages` JOIN calsakay_tbl_users ON " +
                "IF(messages.sender = " + this.userId + ", messages.reciever = calsakay_tbl_users.id, messages.sender = calsakay_tbl_users.id)" +
                "WHERE (`reciever` = " + this.userId + " AND `sender` = " + this.driverId + ") " +
                "OR (`reciever` = " + this.driverId + " AND `sender` = " + userId + ") " +
                "ORDER BY message_id DESC LIMIT 1");
    }

    private Date convertToDateObject(String mysqlString) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-d HH:mm:ss");
        Date date = formatter.parse(mysqlString);
        return date;
    }

    public void initializeMessageDetails(List<String[]> data){
        try {
            this.messageData = new Messages(Integer.parseInt(data.get(0)[3]),
                    Integer.parseInt(data.get(0)[4]),
                    convertToDateObject(String.valueOf(data.get(0)[8])),
                    data.get(0)[6],
                    Integer.parseInt(data.get(0)[5]),
                    data.get(0)[1],
                    data.get(0)[2],
                    (data.get(0)[7].contentEquals("1")),
                    this.driverId,
                    this.userId,
                    data.get(0)[0]);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

        class CheckStatus extends AsyncTask<Void, Void, Void> {
        Statement statement;

        private void checkStatus() throws SQLException {
            ResultSet resultSet = statement.executeQuery("SELECT status WHERE id = " + rideTraceId);
            while(resultSet.next()){
                rideStatus = resultSet.getInt("status");
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://163.44.242.10:3306/feqxsxpi_calsakay?characterEncoding=latin1","feqxsxpi_root", "UCC2021bsitKrazy");
                statement = connection.createStatement();
                rideStatus = 2;

                //TODO: FIND A WAY TO CHANGE A VIEW ACCORDING TO CURRENT RIDE STATUS

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {

            super.onPostExecute(unused);
        }
    }
}