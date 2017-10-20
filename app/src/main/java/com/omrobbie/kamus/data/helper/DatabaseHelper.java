package com.omrobbie.kamus.data.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by omrobbie on 20/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "kamus.db";
    public static String TABLE_NAME = "table_kamus";

    public static String FIELD_ID = "id";
    public static String FIELD_WORD = "word";
    public static String FIELD_TRANSLATE = "translate";

    private static final int DATABASE_VERSION = 1;

    public static String CREATE_TABLE = "create table " + TABLE_NAME + " (" +
            FIELD_ID + " integer primary key autoincrement, " +
            FIELD_WORD + " text not null, " +
            FIELD_TRANSLATE + " text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
