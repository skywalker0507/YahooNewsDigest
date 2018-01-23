package com.skywalker.yahoonewsdigest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/23               *
 *******************************/

public class BezierCureView extends View {
    private float mCenter1X;
    private float mCenter1Y;
    private int mRadius1;

    private float mCenter2X;
    private float mCenter2Y;
    private int mRadius2;

    private Paint mPaint;
    private PointF mContorl;

    private PointF mPoint1;
    private PointF mPoint2;
    private PointF mPoint3;
    private PointF mPoint4;

    private Path mPath;


    public BezierCureView(Context context) {
        this(context,null);
    }

    public BezierCureView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BezierCureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init(){
        mCenter1X=300;
        mCenter1Y=300;
        mRadius1=100;


        mCenter2X=600;
        mCenter2Y=800;
        mRadius2=100;

        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL);

        mContorl=new PointF();

        mPoint1=new PointF();
        mPoint2=new PointF();
        mPoint3=new PointF();
        mPoint4=new PointF();

        mPath=new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mCenter2X=event.getX();
        mCenter2Y=event.getY();
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(mCenter1X, mCenter1Y, mRadius1, mPaint);
        canvas.drawCircle(mCenter2X, mCenter2Y, mRadius2, mPaint);

        float d = (float) Math.sqrt((mCenter2X - mCenter1X) * (mCenter2X - mCenter1X) + (mCenter2Y - mCenter1Y) * (mCenter2Y - mCenter1Y));
        float cos = (mCenter2X - mCenter1X) / d;

        float a = (float) (Math.acos(cos) * 180 / Math.PI);

        if (mCenter2Y - mCenter1Y < 0) {
            a = -a;
        }

        Log.e("degrees", "" + a);
        canvas.save();
        canvas.translate(mCenter1X, mCenter1Y);
        canvas.rotate(a);

        float distance = d / 2;
        //distance=Math.abs(100-distance);
        Log.e("distance",""+distance);
        mContorl.x = distance;
        mContorl.y = 0;

        double r1 = Math.acos(mRadius1 / distance);

        mPoint1.x = (float) (mRadius1 * Math.cos(r1));
        mPoint1.y = (float) (mRadius1 * Math.sin(r1));

        mPoint2.x = (float) (mRadius1 * Math.cos(r1));
        mPoint2.y = (float) (-mRadius1 * Math.sin(r1));

        double r2 = Math.acos(mRadius2 / distance);

        mPoint3.x = (float) (d - mRadius2 * Math.cos(r2));
        mPoint3.y = (float) (mRadius2 * Math.sin(r2));

        mPoint4.x = (float) (d - mRadius2 * Math.cos(r2));
        mPoint4.y = (float) (-mRadius2 * Math.sin(r2));


        mPath.reset();
        mPath.moveTo(mPoint1.x, mPoint1.y);
        mPath.quadTo(mContorl.x, mContorl.y, mPoint3.x, mPoint3.y);
        mPath.lineTo(mPoint4.x, mPoint4.y);
        mPath.quadTo(mContorl.x, mContorl.y, mPoint2.x, mPoint2.y);

        canvas.drawPath(mPath, mPaint);
        canvas.restore();

    }
}
