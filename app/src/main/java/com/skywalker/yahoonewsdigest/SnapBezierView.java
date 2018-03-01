package com.skywalker.yahoonewsdigest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/30               *
 *******************************/

public class SnapBezierView extends View {

    private float mCenter1X;
    private float mCenter1Y;
    private int mRadius1;

    private float mCenter2X;
    private float mCenter2Y;
    private int mRadius2;

    private Paint mPaint;

    private PointF mControl;

    private PointF mPoint1;
    private PointF mPoint2;
    private PointF mPoint3;
    private PointF mPoint4;

    private Path mPath;

    private float mX1;
    private float mX2;

    private static final int MAX_LENGTH = 300;
    private static final int MINI_LENGTH = 180;

    private float mLength;

    public SnapBezierView(Context context) {
        this(context,null);
    }

    public SnapBezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SnapBezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        mCenter1X=150;
        mCenter1Y=600;
        mRadius1=100;


        mCenter2X=mCenter1X+mRadius1+MINI_LENGTH;
        mCenter2Y=600;
        mRadius2=100;

        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL);

        mControl =new PointF();

        mPoint1=new PointF();
        mPoint2=new PointF();
        mPoint3=new PointF();
        mPoint4=new PointF();

        mPath=new Path();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(mCenter1X, mCenter1Y, mRadius1, mPaint);
        canvas.drawCircle(mCenter2X, mCenter2Y, mRadius2, mPaint);

        mLength = (float) Math.sqrt((mCenter2X - mCenter1X) * (mCenter2X - mCenter1X) + (mCenter2Y - mCenter1Y) * (mCenter2Y - mCenter1Y));

        mX1=(mRadius1*mLength)/(mRadius1+mRadius2);
        mX2=(mRadius2*mLength)/(mRadius1+mRadius2);

        mControl.x=mCenter1X+mX1;
        mControl.y=600;
        double r=Math.atan(mRadius1/mX1);
        double l1=Math.sqrt((mControl.x-mCenter1X)*(mControl.x-mCenter1X)-mRadius1*mRadius1);
        mPoint1.x= (float) (mCenter1X+(mX1-l1*Math.cos(r)));
        mPoint1.y=(float)(mCenter1Y-l1*Math.sin(r));

        mPoint2.x= (float) (mCenter1X+(mX1-l1*Math.cos(r)));
        mPoint2.y=(float)(mCenter1Y+l1*Math.sin(r));


        double l2=Math.sqrt((mControl.x-mCenter2X)*(mControl.x-mCenter2X)-mRadius2*mRadius2);
        mPoint3.x= (float) (mCenter2X-(mX2-l2*Math.cos(r)));
        mPoint3.y=(float)(mCenter2Y-l2*Math.sin(r));

        mPoint4.x= (float) (mCenter2X-(mX2-l2*Math.cos(r)));
        mPoint4.y=(float)(mCenter2Y+l2*Math.sin(r));

        mPath.reset();
        mPath.moveTo(mPoint1.x, mPoint1.y);
        mPath.quadTo(mControl.x, mControl.y, mPoint3.x, mPoint3.y);
        mPath.lineTo(mPoint4.x, mPoint4.y);
        mPath.quadTo(mControl.x, mControl.y, mPoint2.x, mPoint2.y);

        mPaint.setColor(Color.GREEN);
        canvas.drawPoint(mControl.x,mControl.y,mPaint);
        canvas.drawPoint(mPoint1.x,mPoint1.y,mPaint);
        canvas.drawPoint(mPoint2.x,mPoint2.y,mPaint);
        canvas.drawPoint(mPoint3.x,mPoint3.y,mPaint);
        canvas.drawPoint(mPoint4.x,mPoint4.y,mPaint);
        canvas.drawPath(mPath, mPaint);


    }
}
