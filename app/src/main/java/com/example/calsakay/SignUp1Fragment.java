package com.example.calsakay;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUp1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUp1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignUp1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUp1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUp1Fragment newInstance(String param1, String param2) {
        SignUp1Fragment fragment = new SignUp1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    private RadioGroup grdb;
    private RadioButton rd_button;
    private DatePicker datePicker;
    private Button btnNext, btnCancel;
    private EditText et_firstName, et_lastName, et_phoneNum, et_email, et_address;
    private String str_firstName, str_lastName, str_gender, str_birthday, str_phoneNum, str_email, str_address;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up1, container, false);

        grdb = view.findViewById(R.id.grdb_gender);
        datePicker = view.findViewById(R.id.dp_birthday);

        btnNext = (Button) view.findViewById(R.id.btn_signup1);
        btnCancel = (Button) view.findViewById(R.id.btn_cancel_signup);

        et_firstName = (EditText) view.findViewById(R.id.et_fname);
        et_lastName = (EditText) view.findViewById(R.id.et_lname);
        et_phoneNum = (EditText) view.findViewById(R.id.et_phonenum);
        et_email = (EditText) view.findViewById(R.id.et_email);
        et_address = (EditText) view.findViewById(R.id.et_address);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedId = grdb.getCheckedRadioButtonId();
//                rd_button = (RadioButton) view.findViewById(R.id.rdb_female);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm-DD-yyyy");

                str_firstName = et_firstName.getText().toString();
                str_lastName = et_lastName.getText().toString();
                str_gender = "test";
                str_birthday = datePicker.toString();
                str_email = et_email.getText().toString();
                str_phoneNum = et_phoneNum.getText().toString();
                str_address = et_address.getText().toString();




//                if (firstName.matches("")){
//                    Toast.makeText(getActivity(), "Firstname is required", Toast.LENGTH_LONG).show();
//                }else if (lastName.matches("")){
//                    Toast.makeText(getActivity(), "Lastname is required", Toast.LENGTH_LONG).show();
//                }else if(phoneNum.matches("")){
//                    Toast.makeText(getActivity(), "Phone number is required", Toast.LENGTH_LONG).show();
//                }else if (email.matches("")){
//                    Toast.makeText(getActivity(), "Email is required", Toast.LENGTH_LONG).show();
//                }else{
                    Bundle bundle = new Bundle();
                    bundle.putString("fname", str_firstName);
                    bundle.putString("lname", str_lastName);
                    bundle.putString("gender", str_gender);
                    bundle.putString("birthday", str_birthday);
                    bundle.putString("email", str_email);
                    bundle.putString("phonenum", str_phoneNum);
                    bundle.putString("address", str_address);

                    SignUp2Fragment signUp2Fragment = new SignUp2Fragment();
                    SignUp5Fragment signUp5Fragment = new SignUp5Fragment();
                    signUp5Fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.signupLayout, signUp2Fragment).commit();
//                }


            }
        });


        return view;
    }


}