package com.example.mymatnasbz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class WorkersActivity extends AppCompatActivity {

    private ImageButton IBReturnFromWorkers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workers);
        IBReturnFromWorkers= (ImageButton) findViewById(R.id.IBReturnFromWorkers);
        IBReturnFromWorkers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoosingActivity();
            }

            private void openChoosingActivity() {
                Intent intent = new Intent(WorkersActivity.this ,ScrollChooseActivity.class);
                startActivity(intent);
            }
        });
    }
}