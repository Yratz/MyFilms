package com.example.coursework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 14;
    public static final String DATABASE_NAME = "moviesDB";
    public static final String TABLE_MOVIES = "movies";

    public static final String TABLE_WISHLIST = "wishlist";
    public static final String TABLE_VISIBLE = "visible";

    public static final String KEY_ID = "_id";
    public static final String KEY_REALIZE_DATE= "realize_date";
    public static final String KEY_TITLE = "title";
    public static final String KEY_OVERVIEW = "overview";
    public static final String KEY_POPULARITY = "popularity";
    public static final String KEY_VOTE_COUNT = "vote_count";
    public static final String KEY_VOTE_AVERAGE = "vote_average";
    public static final String KEY_ORIGINAL_LANGUAGE = "original_language";
    public static final String KEY_GENRE = "genre";
    public static final String KEY_POSTER_URL = "poster_url";
    public static final String KEY_WISHLIST = "wishlist";
    public static final String KEY_VISIBLE = "visible";
    public static final String USER_RATE = "user_rate";
    public static final String USER_REVIEW = "user_review";

    public static final String KEY_WAY_TO_MOVIE = "way_to_movie";


    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_MOVIES + "(" + KEY_ID
                + " integer primary key," + KEY_REALIZE_DATE + " text," + KEY_TITLE + " text," + KEY_OVERVIEW + " text,"
                + KEY_POPULARITY + " text,"  + KEY_VOTE_COUNT + " text," + KEY_VOTE_AVERAGE + " float,"
                + KEY_ORIGINAL_LANGUAGE + " text," + KEY_GENRE + " text," + KEY_POSTER_URL + " text," + KEY_WISHLIST + " integer," + KEY_VISIBLE + " integer," +
                USER_RATE + " float," + USER_REVIEW + " text" + ")");
        db.execSQL("create table " + TABLE_WISHLIST + "(" + KEY_ID + " integer primary key," + KEY_WAY_TO_MOVIE + " integer" + ")");
        db.execSQL("create table " + TABLE_VISIBLE + "(" + KEY_ID + " integer primary key," + KEY_WAY_TO_MOVIE + " integer" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_MOVIES);
        db.execSQL("drop table if exists " + TABLE_WISHLIST);
        db.execSQL("drop table if exists " + TABLE_VISIBLE);
        onCreate(db);

    }
}
