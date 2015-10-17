package com.help.sd.uni_con;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.help.sd.uni_con.R;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;

public class postAdapter extends ArrayAdapter<ParseObject> {

    Context context; int resource; List<ParseObject> objects;

    public postAdapter(Context context, int resource, List<ParseObject> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource,parent,false);
        }
        TextView tv1 = (TextView) convertView.findViewById(R.id.textView32);
        TextView tv2 = (TextView) convertView.findViewById(R.id.textView33);
        TextView tv3 = (TextView) convertView.findViewById(R.id.textView34);
        TextView tv4 = (TextView) convertView.findViewById(R.id.textView35);
        TextView tv5 = (TextView) convertView.findViewById(R.id.textView36);
        TextView tv6 = (TextView) convertView.findViewById(R.id.textView37);


        return convertView;
    }
}
