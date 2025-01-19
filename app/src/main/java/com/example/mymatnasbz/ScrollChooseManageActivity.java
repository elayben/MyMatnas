package com.example.mymatnasbz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ScrollChooseManageActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton IBClassesManager, IBUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_choose_manage);

        IBClassesManager= (ImageButton) findViewById(R.id.IBClassesManager);
        IBClassesManager.setOnClickListener(this);

        IBUsers= (ImageButton) findViewById(R.id.IBUsers);
        IBUsers.setOnClickListener(this);



    }


    public void openClassesActivityManagerActivity() {
        Intent intent = new Intent(this, ClassesActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v==IBClassesManager)
        openClassesActivityManagerActivity();
        if (v==IBUsers)
        {
            Intent intent = new Intent(this, AllUsers.class);
            startActivity(intent);
        }
    }

}