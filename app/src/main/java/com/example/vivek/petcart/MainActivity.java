package com.example.vivek.petcart;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SliderAdepter sliderAdepter;
    private LinearLayout linearLayout;
    private TextView [] mDots;
    private Button next,previous;
    private  int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pager);
        linearLayout = findViewById(R.id.dots);

        sliderAdepter = new SliderAdepter(this);
        viewPager.setAdapter(sliderAdepter);

        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);


        next = findViewById(R.id.nxt);
        previous = findViewById(R.id.pre);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(mCurrentPage + 1);
                Intent ob = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(ob);

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(mCurrentPage - 1);

            }
        });
    }

    public void addDotsIndicator(int position){
        mDots =new TextView[3];
        linearLayout.removeAllViews();

        for (int i=0 ; i<mDots.length; i++){

            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTranspentWhite));

            linearLayout.addView(mDots[i]);

        }
        if (mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorwhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener  = new  ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);
            mCurrentPage = position;
            if (position == 0){
                next.setEnabled(true);
                previous.setEnabled(false);
                previous.setVisibility(View.INVISIBLE);

                next.setText("Next");
                previous.setText("");

            }else if (position == mDots.length){

                next.setEnabled(true);
                previous.setEnabled(true);
                previous.setVisibility(View.VISIBLE);

                next.setText("Finish");
                previous.setText("Back");


            }else {
                next.setEnabled(true);
                previous.setEnabled(true);
                previous.setVisibility(View.VISIBLE);

                next.setText("Next");
                previous.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    }

