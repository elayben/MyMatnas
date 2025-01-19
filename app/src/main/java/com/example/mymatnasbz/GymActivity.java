package com.example.mymatnasbz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GymActivity extends AppCompatActivity {

    private ImageButton IBReturnFromGym;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);
        ImageView mimageView=(ImageView) findViewById(R.id.IVGym);
        Bitmap mbitmap=((BitmapDrawable) getResources().getDrawable(R.drawable.bzgym)).getBitmap();
        Bitmap imageRounded=Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas=new Canvas(imageRounded);
        Paint mpaint=new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawRoundRect((new RectF(0, 0, mbitmap.getWidth(), mbitmap.getHeight())), 100, 100, mpaint); // Round Image Corner 100 100 100 100
        mimageView.setImageBitmap(imageRounded);
        IBReturnFromGym= (ImageButton) findViewById(R.id.IBReturnFromGym);
        IBReturnFromGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoosingActivity();
            }

            private void openChoosingActivity() {
                Intent intent = new Intent(GymActivity.this ,ScrollChooseActivity.class);
                startActivity(intent);
            }
        });
    }
}