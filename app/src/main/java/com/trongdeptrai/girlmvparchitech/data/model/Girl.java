package com.trongdeptrai.girlmvparchitech.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class Girl implements Parcelable {
    @SerializedName("Name")
    private String mName;
    @SerializedName("Age")
    private int mAge;

    public Girl(String name, int age) {
        mName = name;
        mAge = age;
    }

    private Girl(Parcel in) {
        mName = in.readString();
        mAge = in.readInt();
    }

    public static final Creator<Girl> CREATOR = new Creator<Girl>() {
        @Override
        public Girl createFromParcel(Parcel in) {
            return new Girl(in);
        }

        @Override
        public Girl[] newArray(int size) {
            return new Girl[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeInt(mAge);
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }


}
