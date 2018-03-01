package com.skywalker.yahoonewsdigest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
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

public class CircleGroupView extends View {

    private Bitmap[] mCircles = new Bitmap[6];
    private Path mPath = new Path();
    private static final int RADIUS = 260;
    private static final int PADDING = 100;
    private float mPathLength;
    private float[] mPos = new float[2];
    private float[] mTan = new float[2];
    private Matrix mMatrix = new Matrix();

    private float[] mPosition = new float[6];
    private static final int STEP = 1;
    private int mMax = 600;
    private boolean mMove = false;
    private float p;

    private PathMeasure mPathMeasure;

    public CircleGroupView(Context context) {
        this(context, null);
    }

    public CircleGroupView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleGroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension((RADIUS + PADDING) * 2, (RADIUS + PADDING) * 2);
    }

    private void init() {
        mCircles[0] = Utils.getCircularBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_3_atom01));
        mCircles[1] = Utils.getCircularBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_3_atom02));
        mCircles[2] = Utils.getCircularBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_3_atom03));
        mCircles[3] = Utils.getCircularBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_3_atom04));
        mCircles[4] = Utils.getCircularBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_3_atom05));
        mCircles[5] = Utils.getCircularBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_3_atom06));

        for (int i = 0; i < mPosition.length; i++) {
            mPosition[i] = i * mMax / 6;
        }

        RectF rectF = new RectF(PADDING, PADDING, PADDING + RADIUS * 2, PADDING + RADIUS * 2);
        mPath.addArc(rectF, 0, 359);

        mPath.close();

        mPathMeasure = new PathMeasure(mPath, false);
        mPathLength = mPathMeasure.getLength();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mCircles.length; i++) {

            mPathMeasure.getPosTan(mPosition[i] * mPathLength / mMax, mPos, mTan);
            mMatrix.reset();

            if (!mMove) {
                mMatrix.postTranslate(mPos[0] - mCircles[i].getWidth() / 2, mPos[1] - mCircles[i].getHeight() / 2);
                canvas.drawBitmap(mCircles[i], mMatrix, null);
                mPosition[i] += STEP;

                if (mPosition[i] == mMax) {
                    mPosition[i] = 0;
                }

                postInvalidateOnAnimation();

            } else {

                if (i % 2 == 0) {
                    mMatrix.postTranslate(mPos[0] - mCircles[i].getWidth() / 2, mPos[1] - mCircles[i].getHeight() / 2);
                } else {
                    mMatrix.postTranslate(mPos[0] - mCircles[i].getWidth() / 2 + p * 600, mPos[1] - mCircles[i].getHeight() / 2);
                }

                canvas.drawBitmap(mCircles[i], mMatrix, null);
            }
        }
    }

    public void moveCircles(int position, float positionOffset) {

        mMove = position != 2;

        p = 1 - positionOffset;
        postInvalidateOnAnimation();
    }
}
