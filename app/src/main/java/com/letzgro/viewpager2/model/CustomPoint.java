package com.letzgro.viewpager2.model;

import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by bomko on 24.10.16.
 */

public class CustomPoint  implements Parcelable{

    public float getX() {
        return mX;
    }

    public float getY() {
        return mY;
    }

    private float mX;
    private float mY;

    public Paint getPaint() {
        return mPaint;
    }

    private Paint mPaint;

    public CustomPoint(float x, float y, Paint paint) {
        mX = x;
        mY = y;
        mPaint = paint;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
