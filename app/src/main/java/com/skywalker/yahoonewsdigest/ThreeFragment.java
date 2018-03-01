package com.skywalker.yahoonewsdigest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/7               *
 *******************************/

public class ThreeFragment extends BaseFragment {
    private CircleGroupView mCircleGroupView;

    @Override
    protected void initView(LayoutInflater inflater, View view, Bundle savedInstanceState) {

        mCircleGroupView =view.findViewById(R.id.circleGroupView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.onboarding_page3;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        float p = position + positionOffset;
        if (p > 1 && p <= 2){
            mCircleGroupView.moveCircles(position,positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
