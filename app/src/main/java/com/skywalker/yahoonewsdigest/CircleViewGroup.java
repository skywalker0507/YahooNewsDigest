package com.skywalker.yahoonewsdigest;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/6               *
 *******************************/

public class CircleViewGroup extends ViewGroup {

    public CircleViewGroup(Context context) {
        super(context);
    }

    public CircleViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CircleViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
