package com.skywalker.yahoonewsdigest;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/6               *
 *******************************/

public class OnboardingCircleView extends View {
    private Bitmap mSun;
    public OnboardingCircleView(Context context) {
        this(context, null);
    }

    public OnboardingCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OnboardingCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
