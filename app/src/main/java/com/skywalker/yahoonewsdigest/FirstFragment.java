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

public class FirstFragment extends BaseFragment{

    private ImageView mAtomStockchart;
    private ImageView mAtomSound;
    private ImageView mMainbox;
    private ImageView mAtomQuote;
    private ImageView mAtomVideo;
    private ImageView mAtomMap;
    private ImageView mAtomInfographic;
    private ImageView mAtomWikipedia;

    private final static String TAG="FirstFragment";


    @Override
    protected void initView(LayoutInflater inflater, View view, Bundle savedInstanceState) {
        mAtomStockchart=(ImageView)view.findViewById(R.id.ivOnboardingAtomStockchart);
        mAtomSound=(ImageView)view.findViewById(R.id.ivOnboardingAtomSound);
        mMainbox=(ImageView)view.findViewById(R.id.ivOnboardingMainbox);
        mAtomQuote=(ImageView)view.findViewById(R.id.ivOnboardingAtomQuote);
        mAtomVideo=(ImageView)view.findViewById(R.id.ivOnboardingAtomVideo);
        mAtomMap=(ImageView)view.findViewById(R.id.ivOnboardingAtomMap);
        mAtomInfographic=(ImageView)view.findViewById(R.id.ivOnboardingAtomInfographic);
        mAtomWikipedia=(ImageView)view.findViewById(R.id.ivOnboardingAtomWikipedia);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.onboarding_page1;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        float p=position+positionOffset;
        if (p>0&&p<1){
            Log.e("FirstFragment","onPageScrolled-->"+positionOffsetPixels);
        }

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
