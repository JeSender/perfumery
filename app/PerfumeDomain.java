package com.example.perfumeryDomain;

import android.os.Parcel;
import android.os.Parcelable;

public class PerfumeDomain implements Parcelable {
    private String title;
    private double fee;
    private String pic;

    // Constructor
    public PerfumeDomain(String title, double fee, String pic) {
        this.title = title;
        this.fee = fee;
        this.pic = pic;
    }

    // Getters and Setters (if needed)
    public String getTitle() {
        return title;
    }

    public double getFee() {
        return fee;
    }

    public String getPic() {
        return pic;
    }

    // Parcelable methods
    protected PerfumeDomain(Parcel in) {
        title = in.readString();
        fee = in.readDouble();
        pic = in.readString();
    }

    public static final Creator<PerfumeDomain> CREATOR = new Creator<PerfumeDomain>() {
        @Override
        public PerfumeDomain createFromParcel(Parcel in) {
            return new PerfumeDomain(in);
        }

        @Override
        public PerfumeDomain[] newArray(int size) {
            return new PerfumeDomain[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeDouble(fee);
        dest.writeString(pic);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
