package com.skywalker.yahoonewsdigest;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/6               *
 *******************************/

public class SecondFragment extends BaseFragment {


    @Override
    protected void initView(LayoutInflater inflater, View view, Bundle savedInstanceState) {
        ImageView imageView=view.findViewById(R.id.iv_circleline);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment2;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        Log.e("SecondFragment", "onPageScrolled-->" + positionOffsetPixels);

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
