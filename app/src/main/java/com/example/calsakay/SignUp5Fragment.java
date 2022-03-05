package com.example.calsakay;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUp5Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUp5Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignUp5Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Signup5.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUp5Fragment newInstance(String param1, String param2) {
        SignUp5Fragment fragment = new SignUp5Fragment();
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

    private Button btn_signup5, btn_signup5_back;
    private EditText et_password, et_username, et_password_confirm;
    private DatabaseAccess dbAccess;
    private Bundle extras;

    private String str_username, str_password, str_confirm_password;
    // test string
    private String account_status = "0", role = "1", date_joined = "0";
    private Bundle bundle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up5, container, false);
        bundle = this.getArguments();

        et_username = view.findViewById(R.id.et_username);
        et_password = view.findViewById(R.id.et_password);
        et_password_confirm = view.findViewById(R.id.et_confirmPass);


        dbAccess = new DatabaseAccess(getActivity());

        btn_signup5 = view.findViewById(R.id.btn_signup5);
        btn_signup5_back = view.findViewById(R.id.btn_signup5_back);

        btn_signup5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str_username = et_username.getText().toString();
                str_password = et_password.getText().toString();
                str_confirm_password = et_password_confirm.getText().toString();

                insertData();
                SignUpFinalStepFragment signUpFinalStepFragment = new SignUpFinalStepFragment();
                signUpFinalStepFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.signupLayout, signUpFinalStepFragment).commit();

            }
        });

        btn_signup5_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                bundle.putString("company_address", et_comp_address.getText().toString());

                SignUp4Fragment signUp4Fragment = new SignUp4Fragment();
                signUp4Fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.signupLayout, signUp4Fragment).commit();
            }
        });
        return view;
    }

    public void insertData(){
        try {
            dbAccess.executeNonQuery("INSERT INTO calsakay_tbl_users (" +
                    "first_name)" +
                    "VALUES ('" +
                    bundle.getString("fname") + "')");
//                    extras.getString("medical_job") + "','" +
//                    extras.getString("company_name") + "','" +
//                    extras.getString("company_adress") + "','" +
//                    extras.getString("company_number") + "','" +
//                    extras.getString("frontImage") + "','" +
//                    extras.getString("backImage") + "','" +
//                    extras.getString("profile_pic") + "','" +
//                    str_username + "','" +
//                    str_password + "','" +
//                    "0" + "','" +
//                    "1" + "','" +
//                    "'00/00/00')");
//
        }catch (Exception e){
            Log.e("CATCH ERROR: ", e.getMessage());
        }
    }
}