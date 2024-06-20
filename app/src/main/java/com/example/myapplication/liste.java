package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class liste implements Parcelable {

    private int id;
    private String name;

    public liste() {
    }

    protected liste(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<liste> CREATOR = new Creator<liste>() {
        @Override
        public liste createFromParcel(Parcel in) {
            return new liste(in);
        }

        @Override
        public liste[] newArray(int size) {
            return new liste[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
