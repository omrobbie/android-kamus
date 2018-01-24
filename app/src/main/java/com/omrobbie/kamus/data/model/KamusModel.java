/*
 * Created by omrobbie.
 * Copyright (c) 2018. All rights reserved.
 * Last modified 10/20/17 2:46 PM.
 */

package com.omrobbie.kamus.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by omrobbie on 20/10/2017.
 */

public class KamusModel implements Parcelable {

    private int id;
    private String word;
    private String translate;

    public KamusModel() {
    }

    public KamusModel(String word, String translate) {
        this.word = word;
        this.translate = translate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.word);
        dest.writeString(this.translate);
    }

    protected KamusModel(Parcel in) {
        this.id = in.readInt();
        this.word = in.readString();
        this.translate = in.readString();
    }

    public static final Parcelable.Creator<KamusModel> CREATOR = new Parcelable.Creator<KamusModel>() {
        @Override
        public KamusModel createFromParcel(Parcel source) {
            return new KamusModel(source);
        }

        @Override
        public KamusModel[] newArray(int size) {
            return new KamusModel[size];
        }
    };
}
