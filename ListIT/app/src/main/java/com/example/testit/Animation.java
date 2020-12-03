package com.example.testit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.view.View;


public class Animation extends View implements Runnable{

    Bitmap photoOrange;
    Paint paint;
    Handler handler;
    float xOrange, yOrange, cote;
    RectF rect;
    int orangeXstep, orangeYstep;
    public Animation(Context context, Handler handler) {
        super(context);
        init(handler);
        orangeXstep = orangeYstep = 20;
        cote = 100;
        photoOrange = BitmapFactory.decodeResource(getResources(), R.drawable.orange);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        handler.post(this);
    }
    private void init(Handler handler) {
        this.handler = handler;
        //  photoFruit = BitmapFactory.decodeResource(getResources(), R.drawable.orange);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        rect = new RectF(xOrange, yOrange, xOrange + 1, yOrange + 1);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        //   canvas.drawBitmap(photoFromage, null, new RectF(getLeft(), getTop(), getRight(), getBottom()), paint);
        //canvas.drawBitmap(photoFruit, null, new RectF(getLeft() , getTop() , getLeft()+cote, getTop()+cote), paint);
        canvas.drawBitmap(photoOrange, xOrange, yOrange, paint);
    }
    @Override
    public void run() {
        //  x += xstep;
        yOrange += orangeYstep;
        invalidate();
        handler.postDelayed(this, 2);
        if (yOrange > getHeight()) {
            yOrange = -300;
        }
    }
}
