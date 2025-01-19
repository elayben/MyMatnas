package com.example.mymatnasbz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateUsers extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    long id;
    SqliteHelper cop;
    EditText etxtNameU,etxtEmailU;
    ImageButton ibtnBack, upd;
    User c;
    Switch switchIsIns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_users);
        ibtnBack=findViewById(R.id.ibtnBack);
        ibtnBack.setOnClickListener(this);
        upd=findViewById(R.id.upd);
        upd.setOnClickListener(this);

        switchIsIns = (Switch)findViewById(R.id.switchIsIns);
        switchIsIns.setOnCheckedChangeListener(this);
        cop=new SqliteHelper(this);
        etxtEmailU=findViewById(R.id.etxtEmailU);
        etxtNameU=findViewById(R.id.etxtNameU);

        id = Integer.parseInt(getIntent().getStringExtra("rowId"));
        if (id > 0) {
            cop.open();
            c = cop.getUserID(id);
            etxtEmailU.setText(c.getEmail());
            etxtNameU.setText(c.getUserName());
            if(c.getInstructor().equals("true"))
            {
                switchIsIns.setChecked(true);
            }
            else {
                switchIsIns.setChecked(false);
            }

            cop.close();
        }




    }

    @Override
    public void onClick(View v) {
        if (v==ibtnBack){
            Intent intent = new Intent(UpdateUsers.this, AllUsers.class);
            startActivity(intent);
        }
        if (v==upd)
        {

            String name = etxtNameU.getText().toString();
            String email = etxtEmailU.getText().toString();

            User uc = new User(id+"",name, email,c.getPassword());
            String instructor="";
            if (switchIsIns.isChecked())
            {
                instructor= "true";
            }
            else
                instructor="false";
            uc.setInstructor(instructor);


            cop.open();//פתיחת מסד נתונים DB
            id  = cop.updateByRow(uc);//יצירת רשומה(חוג) בתוך DB
            cop.close();//סגירת DB
            Toast.makeText(UpdateUsers.this, "  משתמש נשמר! " + uc.getUserName().toString(), Toast.LENGTH_SHORT).show();


        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}

