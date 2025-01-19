package com.example.mymatnasbz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class ScrollChooseActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton IBGym;
    private ImageButton IBGymboree;
    private ImageButton IBLibrary;
    private ImageButton IBWorkers;
    private ImageButton IBClasses;
    public Button btnChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_choose);
        IBGym= (ImageButton) findViewById(R.id.IBGym);
        IBGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGymActivity();
            }
        });


        IBLibrary= (ImageButton) findViewById(R.id.IBLibrary);
        IBLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLibraryActivity();
            }
        });

        btnChat=findViewById(R.id.btnChat);
        btnChat.setOnClickListener(this);



        IBWorkers= (ImageButton) findViewById(R.id.IBWorkers);
        IBWorkers.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                openWorkersActivity();
            }
        });
        IBClasses= (ImageButton) findViewById(R.id.IBClasses);
        IBClasses.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openClassesActivity();
            }
        });
    }


    public void openGymActivity() {
        Intent intent = new Intent(this, GymActivity.class);
        startActivity(intent);
    }

    public void openLibraryActivity() {
        Intent intent = new Intent(this, LibraryActivity.class);
        startActivity(intent);
    }
    public void openWorkersActivity() {
        Intent intent = new Intent(this, WorkersActivity.class);
        startActivity(intent);
    }
    public void openClassesActivity() {
        Intent intent = new Intent(this, AllClassses.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v==btnChat)
        {
            Intent i= new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=972544697768"));
            startActivity(i);

        }
    }
}