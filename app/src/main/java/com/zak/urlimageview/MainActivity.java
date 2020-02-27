package com.zak.urlimageview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.zak.URLImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URLImageView image = findViewById(R.id.image);
        image.setResolution(1000, 667);

        image.setCallback(new URLImageView.Callback() {
            @Override
            public void onStartLoad() {
                Log.d("onStartLoad : ", "Start load");
            }

            @Override
            public void onSuccess(Bitmap b) {
                Log.d("onSuccess : ", "success load");
            }

            @Override
            public void onError(Exception e) {
                Log.d("onError : ", e.getMessage());
            }
        }).load("https://images.unsplash.com/photo-1545858908-bc6fee2bd44d?ixlib=rb-1.2.1&w=1000&q=80");


    }
}
