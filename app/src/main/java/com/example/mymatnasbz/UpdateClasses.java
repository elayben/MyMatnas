package com.example.mymatnasbz;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateClasses extends AppCompatActivity implements View.OnClickListener {
    long id=0;
    ClassesOpenHelper cop;
    EditText etxtNameU,etxtDescU;
    ImageButton ibtnBack, upd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_classes);

        ibtnBack=findViewById(R.id.ibtnBack);
        ibtnBack.setOnClickListener(this);

        upd=findViewById(R.id.upd);
        upd.setOnClickListener(this);

        cop=new ClassesOpenHelper(this);
        etxtDescU=findViewById(R.id.etxtDescU);
        etxtNameU=findViewById(R.id.etxtNameU);
        id = getIntent().getLongExtra("rowId", 0);
        if (id > 0) {
            cop.open();
            Classes c = cop.getClassbyID(id);
            etxtNameU.setText(c.getName());
            etxtDescU.setText(c.getDesc());



             cop.close();


        }
    }

    @Override
    public void onClick(View v) {
    if (v==ibtnBack){
        Intent intent = new Intent(UpdateClasses.this, AllClassesManager.class);
        startActivity(intent);
    }
        if (v==upd)
        {
            String name = etxtNameU.getText().toString();
            String desc = etxtDescU.getText().toString();
            Classes uc = new Classes(id,name, desc);

            cop.open();//פתיחת מסד נתונים DB
             id  = cop.updateByRow(uc);//יצירת רשומה(חוג) בתוך DB
            cop.close();//סגירת DB
            Toast.makeText(UpdateClasses.this, " חוג נשמר! " + uc.getName().toString(), Toast.LENGTH_SHORT).show();


        }
}}