package com.example.githubuserapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Github extends ArrayList<Parcelable> implements Parcelable{
    private final int avatar;
    private final String name;
    private final String username;
    private final String company;
    private final String location;
    private final String repository;
    private final String followers;
    private final String following;

    public Github(String name, String username, String company, String location, String repository, String followers,
                  String following, int resourceId) {
        this.avatar = resourceId;
        this.name = name;
        this.username = username;
        this.company = company;
        this.location = location;
        this.repository = repository;
        this.followers = followers;
        this.following = following;}

    int getAvatar() {
        return avatar;
    }

    String getName() {
        return name;
    }

    String getUsername() {
        return username;
    }

    String getCompany() {
        return company;
    }

    String getLocation() {
        return location;
    }

    String getRepository() {
        return repository;
    }

    String getFollowers() {
        return followers;
    }

    String getFollowing() {
        return following;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.avatar);
        dest.writeString(this.name);
        dest.writeString(this.username);
        dest.writeString(this.company);
        dest.writeString(this.location);
        dest.writeString(this.repository);
        dest.writeString(this.followers);
        dest.writeString(this.following);
    }

    private Github(Parcel in) {
        this.avatar = in.readInt();
        this.name = in.readString();
        this.username = in.readString();
        this.company = in.readString();
        this.location = in.readString();
        this.repository = in.readString();
        this.followers = in.readString();
        this.following = in.readString();
    }

    public static final Parcelable.Creator<Github> CREATOR = new Parcelable.Creator<Github>() {
        @Override
        public Github createFromParcel(Parcel in) {
            return new Github(in);
        }

        @Override
        public Github[] newArray(int size) {
            return new Github[size];
        }
    };
}
