package com.example.mymatnasbz;


import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mymatnasbz.User;

import java.util.ArrayList;

public class AllUsers extends AppCompatActivity implements AdapterView.OnItemClickListener {

    SqliteHelper ucoh;
    ArrayList<User> listOfUsers;
    ListView listView;
    UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        listView = (ListView) findViewById(R.id.LVUsers);
        ucoh = new SqliteHelper(this);

        listOfUsers = new ArrayList<User>();
        ucoh.open();
        listOfUsers = ucoh.getAllUsers();
        ucoh.close();
        userAdapter = new UserAdapter(this, 0, listOfUsers);
        listView.setAdapter(userAdapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        listOfUsers = new ArrayList<User>();
        ucoh.open();
        listOfUsers = ucoh.getAllUsers();
        ucoh.close();
        userAdapter = new UserAdapter(this, 0, listOfUsers);
        listView.setAdapter(userAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        User p = userAdapter.getItem(position);
        Toast.makeText(getBaseContext(), p.getUserName() + " touched", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(AllUsers.this, UpdateUsers.class);
        i.putExtra("rowId", p.getId());
        startActivityForResult(i, 0);//0--->going to updatescreen
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}