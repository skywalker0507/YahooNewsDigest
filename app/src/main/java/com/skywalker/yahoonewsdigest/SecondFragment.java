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

public class SecondFragment extends BaseFragment {

    OnboardingCircleView circleView;
    private OnboardingDocumentView mDocumentView;
    private boolean mEnter=false;

    @Override
    protected void initView(LayoutInflater inflater, View view, Bundle savedInstanceState) {
        circleView = view.findViewById(R.id.OnboardingCircleView);
        mDocumentView=view.findViewById(R.id.OnboardingDocumentView);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.onboarding_page2;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        Log.e("SecondFragment", "position-->" + position);
        Log.e("SecondFragment", "onPageScrolled-->" + positionOffset);


        float p = position + positionOffset;
        if (p > 0 && p < 2) {


            circleView.animateSecondScreenClock(position, positionOffset);
        }else {

            mEnter=true;
        }

        if (position==1&&mEnter){
            mDocumentView.startAnimation();
            mEnter=false;
        }

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
