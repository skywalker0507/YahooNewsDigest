package com.skywalker.yahoonewsdigest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/6               *
 *******************************/

public class FirstFragment extends BaseFragment {

    private ImageView mAtomStockchart;
    private ImageView mAtomSound;
    private ImageView mMainbox;
    private ImageView mAtomQuote;
    private ImageView mAtomVideo;
    private ImageView mAtomMap;
    private ImageView mAtomInfographic;
    private ImageView mAtomWikipedia;

    private AnimatorSet mAnimatorSet;

    private HashMap<ImageView, Float> mOriginalXValuesMap = new HashMap<>();
    private HashMap<ImageView,Float> mMap=new HashMap<>();

    private final static String TAG = "FirstFragment";

    @Override
    protected void initView(LayoutInflater inflater, final View view, Bundle savedInstanceState) {
        mAtomStockchart = (ImageView) view.findViewById(R.id.ivOnboardingAtomStockchart);
        mAtomSound = (ImageView) view.findViewById(R.id.ivOnboardingAtomSound);
        mMainbox = (ImageView) view.findViewById(R.id.ivOnboardingMainbox);
        mAtomQuote = (ImageView) view.findViewById(R.id.ivOnboardingAtomQuote);
        mAtomVideo = (ImageView) view.findViewById(R.id.ivOnboardingAtomVideo);
        mAtomMap = (ImageView) view.findViewById(R.id.ivOnboardingAtomMap);
        mAtomInfographic = (ImageView) view.findViewById(R.id.ivOnboardingAtomInfographic);
        mAtomWikipedia = (ImageView) view.findViewById(R.id.ivOnboardingAtomWikipedia);
        initializeAlpha();
        doFadeAnimation();
        view.post(new Runnable() {
            @Override
            public void run() {
                float x=1080;
                getOriginalPositions(x);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.onboarding_page1;
    }

    private void getOriginalPositions(float x) {

        mOriginalXValuesMap.put(mMainbox, mMainbox.getX());
        mOriginalXValuesMap.put(mAtomVideo, mAtomVideo.getX());
        mOriginalXValuesMap.put(mAtomInfographic, mAtomInfographic.getX());
        mOriginalXValuesMap.put(mAtomStockchart, mAtomStockchart.getX());
        mOriginalXValuesMap.put(mAtomSound, mAtomSound.getX());
        mOriginalXValuesMap.put(mAtomQuote, mAtomQuote.getX());
        mOriginalXValuesMap.put(mAtomMap, mAtomMap.getX());
        mOriginalXValuesMap.put(mAtomWikipedia, mAtomWikipedia.getX());

        mMap.put(mMainbox, mMainbox.getX()/x);
        mMap.put(mAtomVideo, mAtomVideo.getX()/x);
        mMap.put(mAtomInfographic, mAtomInfographic.getX()/x);
        mMap.put(mAtomStockchart, mAtomStockchart.getX());
        mMap.put(mAtomSound, mAtomSound.getX()/x);
        mMap.put(mAtomQuote, mAtomQuote.getX()/x);
        mMap.put(mAtomMap, mAtomMap.getX()/x);
        mMap.put(mAtomWikipedia, mAtomWikipedia.getX()/x);

    }


    private void setViewsInOriginalPosition() {

        mMainbox.setX(mOriginalXValuesMap.get(mMainbox));
        mAtomVideo.setX(mOriginalXValuesMap.get(mAtomVideo));
        mAtomInfographic.setX(mOriginalXValuesMap.get(mAtomInfographic));
        mAtomStockchart.setX(mOriginalXValuesMap.get(mAtomStockchart));
        mAtomSound.setX(mOriginalXValuesMap.get(mAtomSound));
        mAtomQuote.setX(mOriginalXValuesMap.get(mAtomQuote));
        mAtomMap.setX(mOriginalXValuesMap.get(mAtomMap));
        mAtomWikipedia.setX(mOriginalXValuesMap.get(mAtomWikipedia));

        //initializeAlpha();

    }

    private void initializeAlpha() {

        mAtomVideo.setAlpha(0f);
        mAtomInfographic.setAlpha(0f);
        mAtomStockchart.setAlpha(0f);
        mAtomSound.setAlpha(0f);
        mAtomQuote.setAlpha(0f);
        mAtomMap.setAlpha(0f);
        mAtomWikipedia.setAlpha(0f);
    }

    private void moveTheSpheres(float pageWidth) {


        float videoPosition = (float) (0.15 * pageWidth);
        if (videoPosition > (-1 * mOriginalXValuesMap.get(mAtomVideo))) {

        }
        mAtomVideo.setTranslationX(videoPosition);

        float infographicPosition = (float) (0.50 * pageWidth);
        if (infographicPosition > (-1 * mOriginalXValuesMap.get(mAtomInfographic))) {

        }
        mAtomInfographic.setTranslationX(infographicPosition);

        float stockchartPosition = (float) (0.50 * pageWidth);
        if (stockchartPosition > (-1 * mOriginalXValuesMap.get(mAtomStockchart))) {

        }
        mAtomStockchart.setTranslationX(stockchartPosition);

        float soundPosition = (float) (0.30 * pageWidth);
        if (soundPosition > (-1 * mOriginalXValuesMap.get(mAtomSound))) {

        }
        mAtomSound.setTranslationX(soundPosition);

        float quotePosition = (float) (-0.37 * pageWidth);
        if (quotePosition > (-1 * mOriginalXValuesMap.get(mAtomQuote))) {

        }
        mAtomQuote.setTranslationX(quotePosition);

        float mapPosition = (float) (-1.1 * pageWidth);
        if (mapPosition > (-1 * mOriginalXValuesMap.get(mAtomMap))) {

        }
        mAtomMap.setTranslationX(mapPosition);

        float wikipediaPosition = (float) (-0.37 * pageWidth);
        if (wikipediaPosition > (-1 * mOriginalXValuesMap.get(mAtomWikipedia))) {

        }
        mAtomWikipedia.setTranslationX(wikipediaPosition);

    }

    private void doFadeAnimation() {

        ObjectAnimator fadeCamcord = ObjectAnimator.ofFloat(mAtomVideo, "alpha", 0f, 1f);
        fadeCamcord.setDuration(700);

        ObjectAnimator fadeClock = ObjectAnimator.ofFloat(mAtomInfographic, "alpha", 0f, 1f);
        fadeClock.setDuration(700);

        ObjectAnimator fadeGraph = ObjectAnimator.ofFloat(mAtomStockchart, "alpha", 0f, 1f);
        fadeGraph.setDuration(700);

        ObjectAnimator fadeAudio = ObjectAnimator.ofFloat(mAtomSound, "alpha", 0f, 1f);
        fadeAudio.setDuration(700);

        ObjectAnimator fadeQuote = ObjectAnimator.ofFloat(mAtomQuote, "alpha", 0f, 1f);
        fadeQuote.setDuration(700);

        ObjectAnimator fadeMap = ObjectAnimator.ofFloat(mAtomMap, "alpha", 0f, 1f);
        fadeMap.setDuration(700);

        ObjectAnimator fadeWordpress = ObjectAnimator.ofFloat(mAtomWikipedia, "alpha", 0f, 1f);
        fadeWordpress.setDuration(700);

        //1 5    3 2  7 6  4

        mAnimatorSet = new AnimatorSet();
        fadeAudio.setStartDelay(50);
        fadeGraph.setStartDelay(200);
        fadeWordpress.setStartDelay(500);
        fadeClock.setStartDelay(700);
        fadeMap.setStartDelay(900);
        fadeQuote.setStartDelay(1100);

        mAnimatorSet.play(fadeCamcord).with(fadeAudio).with(fadeGraph).with(fadeWordpress).with(fadeClock).with(fadeMap).with(fadeQuote);
        mAnimatorSet.start();

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        float p = position + positionOffset;
        if (p > 0 && p < 1) {
            moveTheSpheres(positionOffsetPixels);
            Log.e("FirstFragment", "onPageScrolled-->" + positionOffsetPixels);
        }

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
