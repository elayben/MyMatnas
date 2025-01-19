package com.example.mymatnasbz;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClassesAdapter extends ArrayAdapter<Classes> {
    Context context;
    List<Classes> objects;



    public ClassesAdapter(Context context, int resource, List<Classes> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.onerowclasses, parent, false);

        TextView TVClassesname = (TextView) view.findViewById(R.id.TVClassesname);
        TextView TVClassesdesc = (TextView) view.findViewById(R.id.TVClassesdesc);
        ImageView IVClasses = (ImageView) view.findViewById(R.id.IVClasses);
        Classes temp = objects.get(position);
        TVClassesname.setText(temp.getName());


        byte[]classesImage=temp.getPicture();
        Bitmap bitmap= BitmapFactory.decodeByteArray(classesImage, 0, classesImage.length);
        IVClasses.setImageBitmap(bitmap);

        TVClassesdesc.setText(temp.getDesc());


        return view;
    }
}
