package com.letzgro.viewpager2.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bomko on 01.11.16.
 */

public class Loads implements Parcelable {

    protected Loads(Parcel in) {
        mName = in.readString();
        mDate = in.readString();
        mCity = in.readString();
        mLocation = in.readString();
        mPhone = in.readString();
    }

    public Loads(String name, String date, String city, String location, String phone) {
        mName = name;
        mDate = date;
        mCity = city;
        mLocation = location;
        mPhone = phone;

    }

    public static final Creator<Loads> CREATOR = new Creator<Loads>() {
        @Override
        public Loads createFromParcel(Parcel in) {
            return new Loads(in);
        }

        @Override
        public Loads[] newArray(int size) {
            return new Loads[size];
        }
    };

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    private String mName;
    private String mDate;
    private String mCity;
    private String mLocation;
    private String mPhone;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDate);
        dest.writeString(mCity);
        dest.writeString(mLocation);
        dest.writeString(mPhone);
    }
}
