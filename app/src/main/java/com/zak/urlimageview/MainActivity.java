package com.zak.urlimageview;

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
            public void onSuccess() {
                Log.d("onSuccess : ", "success load");
            }

            @Override
            public void onError(Exception e) {
                Log.d("onError : ", e.getMessage());
            }
        }).load("213");


    }
}
