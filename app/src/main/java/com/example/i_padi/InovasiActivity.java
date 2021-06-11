package com.example.i_padi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class InovasiActivity extends AppCompatActivity {
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inovasi);

        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1()); //page_1
        list.add(new PageFragment2()); //page_2
        list.add(new PageFragment3());//page_3
        list.add(new PageFragment4());//page_4
        list.add(new PageFragment5());//page_5
        list.add(new PageFragment6());//page_6
        list.add(new PageFragment7());//page_7
        list.add(new PageFragment8());//page_8



        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager(),list);

        pager.setAdapter(pagerAdapter);
    }
}