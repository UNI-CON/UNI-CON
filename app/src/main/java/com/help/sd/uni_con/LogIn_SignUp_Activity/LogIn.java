package com.help.sd.uni_con.LogIn_SignUp_Activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.help.sd.uni_con.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LogIn extends Fragment {

    private OnFragmentInteractionListener mListener;

    public LogIn() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button b1 = (Button) getView().findViewById(R.id.button);
        Button b2 = (Button) getView().findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogInButtonPressed();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNewUserButtonPressed();
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    private void onLogInButtonPressed() {
        final EditText et_email = (EditText) getView().findViewById(R.id.editText);
        final EditText et_passwd = (EditText) getView().findViewById(R.id.editText2);
        ParseUser.logInInBackground(et_email.getText().toString(), et_passwd.getText().toString(), new LogInCallback() {

            @Override
            public void done(ParseUser user, ParseException e) {
                if (et_email.getText().toString().length() == 0)
                    et_email.setError("Enter Email");
                else if (et_passwd.getText().toString().length() == 0)
                    et_passwd.setError("Enter Password");
                else if (user != null) {
                    mListener.onLogInButtonPressed();
                } else {
                    Toast.makeText(getActivity(), "Log In Failed, Invalid Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void onNewUserButtonPressed() {
        if (mListener != null) {
            mListener.onNewUserButtonPressed();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onNewUserButtonPressed();
        public void onLogInButtonPressed();
    }

}
