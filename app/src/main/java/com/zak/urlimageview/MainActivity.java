package com.zak.urlimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zak.URLImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URLImageView image = findViewById(R.id.image);
        image.load("https://musicart.xboxlive.com/6/cf3fdc26-0000-0000-0000-000000000009/504/image.jpg?w=1920&h=1080");
    }
}
