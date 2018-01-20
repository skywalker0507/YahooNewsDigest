package com.skywalker.yahoonewsdigest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/7               *
 *******************************/

public class ThreeFragment extends BaseFragment {
    private ImageView mImageView;

    @Override
    protected void initView(LayoutInflater inflater, View view, Bundle savedInstanceState) {
        mImageView = view.findViewById(R.id.image);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_3;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        mImageView.setTranslationX(-positionOffsetPixels * 0.25f);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
