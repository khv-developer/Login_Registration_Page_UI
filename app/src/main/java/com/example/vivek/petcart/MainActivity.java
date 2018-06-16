package com.example.vivek.petcart;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SliderAdepter sliderAdepter;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pager);
        linearLayout = findViewById(R.id.dots);

        sliderAdepter = new SliderAdepter(this);
        viewPager.setAdapter(sliderAdepter);



    }
}
