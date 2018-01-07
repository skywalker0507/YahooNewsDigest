package com.skywalker.yahoonewsdigest;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
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
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public OnboardingCircleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
