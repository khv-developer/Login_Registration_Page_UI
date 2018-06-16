package com.example.vivek.petcart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdepter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public  SliderAdepter (Context context){
        this.context=context;
    }

    //Arrays

    public int[] slide_images={
            R.drawable.eat,
            R.drawable.bird,
            R.drawable.study

    };
    public String[] slide_heading={
            "EAT",
            "Bird",
            "Study"

    };

    public String[] slides_decs={
            "Lorem isqum dolor sit amet, consetetur adipiscing elit, sed to eiusmod tempor incididunt ut labore et dolor manga",
            "Lorem isqum dolor sit amet, consetetur adipiscing elit, sed to eiusmod tempor incididunt ut labore et dolor manga",
            "Lorem isqum dolor sit amet, consetetur adipiscing elit, sed to eiusmod tempor incididunt ut labore et dolor manga"

    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull View container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.slide_layout, (ViewGroup) container,false);

        ImageView imageView = v.findViewById(R.id.img);
        TextView heading = v.findViewById(R.id.textView);
        TextView dec = v.findViewById(R.id.textView2);

        imageView.setImageResource(slide_images[position]);
        heading.setText(slide_heading[position]);
        dec.setText(slides_decs[position]);
        ((ViewGroup) container).addView(v);

        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);

    }
}
