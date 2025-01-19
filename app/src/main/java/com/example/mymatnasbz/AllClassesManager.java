package com.example.mymatnasbz;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AllClassesManager extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ClassesOpenHelper ucoh;
    ArrayList<Classes> listOfClasses;
    ListView listView;
    ClassesAdapter userclassAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_classes_manager);
        listView = (ListView) findViewById(R.id.LVClassesManager1);
        ucoh = new ClassesOpenHelper(this);

        listOfClasses = new ArrayList<Classes>();
        ucoh.open();
        listOfClasses = ucoh.getAllClasses();
        ucoh.close();
        userclassAdapter = new ClassesAdapter(this, 0, listOfClasses);
        listView.setAdapter(userclassAdapter);
        listView.setOnItemClickListener(this);
    }


  /*  @Override
    protected void onRestart() {
        super.onRestart();
        ucoh.open();
        listOfClasses = ucoh.getAllClasses();
        ucoh.close();
        userclassAdapter = new ClassesAdapter(this, 0, listOfClasses);
        listView.setAdapter(userclassAdapter);
        listView.setOnItemClickListener(this);
    }
*/
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        Classes p = userclassAdapter.getItem(position);
            Toast.makeText(getBaseContext(), p.getName() + " נבחר", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(AllClassesManager.this, UpdateClasses.class);
        i.putExtra("rowId", p.getId());
        startActivityForResult(i, 0);//0--->going to updatescreen
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}