package com.skywalker.yahoonewsdigest;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        FirstFragment fragment1=new FirstFragment();
        fragment1.setViewPager(mViewPager);
        SecondFragment fragment2=new SecondFragment();
        fragment2.setViewPager(mViewPager);

        ThreeFragment fragment3=new ThreeFragment();
        fragment3.setViewPager(mViewPager);

        MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addItem(fragment1,"12",1);
        adapter.addItem(fragment2,"123",2);
        adapter.addItem(fragment3,"1234",3);
        mViewPager.setAdapter(adapter);
    }

    private void initViews(){
        mViewPager=(ViewPager)findViewById(R.id.main_viewPager);
        mViewPager.bringToFront();

    }

    private class CustomTransformer implements ViewPager.PageTransformer{

        @Override
        public void transformPage(View page, float position) {

        }
    }
}
