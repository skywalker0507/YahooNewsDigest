package com.skywalker.yahoonewsdigest;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/6               *
 *******************************/

public class Fragment2 extends BaseFragment{


    @Override
    protected void initView(LayoutInflater inflater, View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment2;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        float p=position+positionOffset;
        if (p>1&&p<2){
            Log.e("Fragment2","onPageScrolled-->"+positionOffsetPixels);
        }

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
