package com.example.kevinbui.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // To launch activity
        Intent in = getIntent();

        // Which index to display
        int index = in.getIntExtra("com.example.kevinbui.ITEM_INDEX", -1);

        if (index > -1){
            int pic = getImg(index);
            ImageView img = (ImageView)findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }

    // Set image that we want
    private int getImg(int index){
        switch(index){
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomato;
            case 2: return R.drawable.squash;
            default: return -1;
        }
    }

    // To scale the image
    private void scaleImg(ImageView img, int pic){

        // To determine screen size
        Display screen = getWindowManager().getDefaultDisplay();
       // What we are going to use to scale the image
        BitmapFactory.Options options= new BitmapFactory.Options();

        options.inJustDecodeBounds = true; // turn on boundaries
        BitmapFactory.decodeResource(getResources() ,pic, options); // Allow us to look at resources without having to draw it

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        // Scale the image if bigger
        if(imgWidth > screenWidth){
            int ratio = Math.round( (float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio;
        }

        // Turn off
        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }
}
