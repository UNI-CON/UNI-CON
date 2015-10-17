package com.help.sd.uni_con.Post_Activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.help.sd.uni_con.R;

public class postActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        if(getIntent().getIntExtra("id",0)==0){
            getFragmentManager().beginTransaction().add(R.id.container,new create_post_Fragment()).commit();
        }
    }
}
