package com.zak.urlimageview;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zak.URLImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URLImageView image = findViewById(R.id.image);

        image.setCallback(new URLImageView.Callback() {
            @Override
            public void onStartLoad() {
                Log.d("onStartLoad : ", "Start load");
            }

            @Override
            public void onSuccess(Bitmap b) {
                int x = b.getHeight();
                Log.d("onSuccess : ", "success load");
            }

            @Override
            public void onError(Exception e) {
                Log.d("onError : ", e.getMessage());
            }
        }).load("https://c4.wallpaperflare.com/wallpaper/246/739/689/digital-digital-art-artwork-illustration-abstract-hd-wallpaper-thumb.jpg");


    }
}
