package com.help.sd.uni_con.LogIn_SignUp_Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.help.sd.uni_con.Home_Activity.Home;
import com.help.sd.uni_con.R;
import com.parse.ParseUser;

public class LogIn_SignUp extends AppCompatActivity implements
        LogIn.OnFragmentInteractionListener,
        SignUp.OnFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in__sign_up);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.root);

        rl.setBackgroundColor(Color.parseColor("#d3d3d3"));

        ParseUser currentUser = ParseUser.getCurrentUser();
        if(currentUser!=null){
            startHomeActivity();
        } else getFragmentManager().beginTransaction().add(rl.getId(),new LogIn(),"login").commit();

    }

    @Override
    public void onNewUserButtonPressed() {
        getFragmentManager().beginTransaction().replace(R.id.root,new SignUp(),"signup").commit();
    }

    @Override
    public void onLogInButtonPressed() {
        startHomeActivity();
    }

    @Override
    public void onSignUpButtonPressed() {
        startHomeActivity();
    }

    @Override
    public void onCancelButtonPressed() {
        getFragmentManager().popBackStack();
    }

    private void startHomeActivity(){
        Intent intent = new Intent(LogIn_SignUp.this,Home.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
