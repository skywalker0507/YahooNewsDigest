package com.skywalker.yahoonewsdigest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/6               *
 *******************************/

public class OnboardingCircleView extends View {
    private Bitmap mSun;
    private Bitmap mMoon;

    private Paint mPaint;

    private int mX;
    private int mY;

    private float[] mPos;
    private float[] mTan;

    private Matrix mMatrix;

    private Path mMoonPath;
    private Path mSunPath;

    private PathMeasure mMoonPathMeasure;
    private PathMeasure mSunPathMeasure;
    private float mPathLength;
    private float mDistance;

    private static final int RADIUS = 350;

    public OnboardingCircleView(Context context) {
        this(context, null);
    }

    public OnboardingCircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OnboardingCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mSun = BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_2_sun);
        mMoon = BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_2_moon);

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setPathEffect(new DashPathEffect(new float[]{10, 10}, 1));

        mX = RADIUS + 100;
        mY = RADIUS + 100;

        mPos = new float[2];
        mTan = new float[2];
        mMatrix = new Matrix();

        mDistance = 0;


        initNewPath(Path.Direction.CW);
    }

    private void initNewPath(Path.Direction dir) {

        mMoonPath = new Path();
        mSunPath = new Path();
        RectF rectF = new RectF(mX - RADIUS, mY - RADIUS, mX + RADIUS, mY + RADIUS);


        mMoonPath.addArc(rectF, 50, 359);

        mSunPath.addArc(rectF, 230, 359);

        mMoonPath.close();
        mSunPath.close();

        mMoonPathMeasure = new PathMeasure(mMoonPath, false);
        mSunPathMeasure = new PathMeasure(mSunPath, false);
        mPathLength = mMoonPathMeasure.getLength();


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mX * 2, mY * 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawPath(mMoonPath, mPaint);

        mMoonPathMeasure.getPosTan(mDistance, mPos, mTan);
        mMatrix.reset();
        mMatrix.postTranslate(mPos[0] - mMoon.getWidth() / 2, mPos[1] - mMoon.getHeight() / 2);
        canvas.drawBitmap(mMoon, mMatrix, null);


        mSunPathMeasure.getPosTan(mDistance, mPos, mTan);
        mMatrix.reset();
        mMatrix.postTranslate(mPos[0] - mSun.getWidth() / 2, mPos[1] - mSun.getHeight() / 2);
        canvas.drawBitmap(mSun, mMatrix, null);
    }

    public void animateSecondScreenClock(int position, float positionOffset) {


        mDistance = mPathLength / 2 * (Math.abs(positionOffset));

        if (position == 0) {
            mDistance += mPathLength / 2;
        }

        invalidate();
    }
}
