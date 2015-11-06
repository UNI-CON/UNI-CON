package com.help.sd.uni_con.Course_Activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.help.sd.uni_con.R;

public class addCourseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        if (getIntent().getBooleanExtra("student",false))
            getFragmentManager().beginTransaction().add(R.id.root, new add_course_student_Fragment()).commit();
         else
            getFragmentManager().beginTransaction().add(R.id.root, new add_course_prof_Fragment()).commit();
    }
    //dfsfsfsf
    //dsdfsd
///fsdfsdfswdfswdlkfnws
}
