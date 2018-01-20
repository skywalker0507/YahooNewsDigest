package com.skywalker.yahoonewsdigest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/6               *
 *******************************/

public class OnboardingDocumentView extends View {

    private int mPosition = 0;
    private int[] leftPositions = new int[4];
    private int mDocumentWidth;
    private int mDocumentHeight;

    private Paint mPaint;

    private Paint mLinePaint;

    private static final int HORIZONTAL_PADDING = 30;
    private static final int VERTICAL_PADDING = 50;


    private static final int  STROKE_WIDTH= 2;

    private Bitmap[] mBitmaps = new Bitmap[4];

    public OnboardingDocumentView(Context context) {
        this(context, null);
    }

    public OnboardingDocumentView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OnboardingDocumentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {

        mBitmaps[0] = BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_2_document_atom_blue);
        mBitmaps[1] = BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_2_document_atom_red);
        mBitmaps[2] = BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_2_document_atom_orange);
        mBitmaps[3] = BitmapFactory.decodeResource(getResources(), R.drawable.onboarding_2_document_atom_green);

        leftPositions[0] = 50;
        leftPositions[1] = leftPositions[0] + mBitmaps[0].getHeight();
        leftPositions[2] = leftPositions[1] + mBitmaps[1].getHeight();
        leftPositions[3] = leftPositions[2] + mBitmaps[2].getHeight();

        mDocumentWidth = mBitmaps[0].getWidth() + 5 * 2;
        mDocumentHeight = mBitmaps[0].getHeight() + mBitmaps[1].getHeight() + mBitmaps[2].getHeight() + mBitmaps[3].getHeight() + 5 * 5;

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(STROKE_WIDTH*2);
        mPaint.setStyle(Paint.Style.STROKE);

        mLinePaint = new Paint();
        mLinePaint.setAlpha(0);



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(mDocumentWidth+2*HORIZONTAL_PADDING,mDocumentHeight+2+VERTICAL_PADDING);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawRect(HORIZONTAL_PADDING+15, VERTICAL_PADDING-15, HORIZONTAL_PADDING+15 + mDocumentWidth, VERTICAL_PADDING-15+ mDocumentHeight, mPaint);

        canvas.drawRect(HORIZONTAL_PADDING, VERTICAL_PADDING, HORIZONTAL_PADDING + mDocumentWidth, VERTICAL_PADDING + mDocumentHeight, mPaint);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawRect(HORIZONTAL_PADDING+STROKE_WIDTH, VERTICAL_PADDING+STROKE_WIDTH, HORIZONTAL_PADDING-STROKE_WIDTH*2 + mDocumentWidth, VERTICAL_PADDING-STROKE_WIDTH*2 + mDocumentHeight, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);


        if (mPosition < 4) {
            for (int i = 0; i < mPosition; i++) {
                canvas.drawBitmap(mBitmaps[i], HORIZONTAL_PADDING + 5, leftPositions[i] + 5, null);
            }

            canvas.drawBitmap(mBitmaps[mPosition], HORIZONTAL_PADDING + 5, leftPositions[mPosition] + 5, mLinePaint);
            fadeTheLine(mLinePaint);
        } else {

            for (int i = 0; i < 4; i++) {
                canvas.drawBitmap(mBitmaps[i], HORIZONTAL_PADDING + 5, leftPositions[i] + 5, null);
            }
        }

    }

    private void fadeTheLine(Paint paint) {

        if (mPosition < mBitmaps.length) {
            if (paint.getAlpha() != 255) {
                int newAlpha = paint.getAlpha() + 17;
                if (newAlpha >= 255) {
                    newAlpha = 255;
                }

                paint.setAlpha(newAlpha);

            } else {
                paint.setAlpha(0);
                mPosition++;

            }

            //invalidate();
            postInvalidateOnAnimation();

        }


    }
}
