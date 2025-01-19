package com.example.mymatnasbz;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    Context context;
    List<User> objects;



    public UserAdapter(Context context, int resource, List<User> objects) {
       super(context,resource,objects);
        this.objects = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.onerowusers, parent, false);

        TextView TVUsersName = (TextView) view.findViewById(R.id.TVUsersName);
        TextView TVUsersEmail = (TextView) view.findViewById(R.id.TVUsersEmail);
        User temp = objects.get(position);
        TVUsersName.setText(temp.getUserName());
        TVUsersEmail.setText(temp.getEmail());


        return view;
    }
}
