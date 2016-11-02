package com.letzgro.viewpager2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.letzgro.viewpager2.model.CustomPoint;

import java.util.ArrayList;
import java.util.List;


public class LineView extends View {

    public float getStartX() {
        return startX;
    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public float getStopX() {
        return stopX;
    }

    public void setStopX(float stopX) {
        this.stopX = stopX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public float getStopY() {
        return stopY;
    }

    public void setStopY(float stopY) {
        this.stopY = stopY;
    }

    private float startX;
    private float stopX;
    private float startY;
    private float stopY;

    Paint paintBlack = new Paint();
    Paint mPaintGreen, mPaintRed;


    float startPoint = 10;
    float endPoint;

    float count = 5;
    float averageSize;

    public static List<CustomPoint> points = new ArrayList<CustomPoint>();

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, AttributeSet attrs, int defstyle) {
        super(context, attrs, defstyle);
    }

/*

    public LineView(Context context) {
        super(context);

        //  paint.setStrokeWidth(3);

    }
*/

    @Override
    public void onDraw(Canvas canvas) {
     /*   mPaintGreen = new Paint();
        mPaintRed = new Paint();

        mPaintGreen.setColor(Color.GREEN);
        mPaintRed.setColor(Color.RED);

        Log.d("myLog", "louyffufyfyflygiglulugglgi");


        int width = 400;
        //  graph.measure(width, 10);

        setStartX(0);
        setStartY(10);
        setStopY(10);
        setStopX(width);

        averageSize = width / (count - 1);
        endPoint = width - 10;

        points.add(new CustomPoint(startPoint, 10, mPaintGreen));
        points.add(new CustomPoint(averageSize, 10, mPaintRed));
        points.add(new CustomPoint(averageSize * 2, 10, mPaintGreen));
        points.add(new CustomPoint(averageSize * 3, 10, mPaintGreen));
        points.add(new CustomPoint(endPoint, 10, mPaintRed));
        Log.d("myLog", "l: " + points.size());*/
        canvas.drawLine(getStartX(), getStartY(), getStopX(), getStopY(), paintBlack);

        for (CustomPoint point : points) {
            canvas.drawCircle(point.getX(), point.getY(), 10, point.getPaint());
           // invalidate();
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int desiredWidth = 656;
        int desiredHeight = 20;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height);
    }
}