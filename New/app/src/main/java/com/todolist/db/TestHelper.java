package com.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class TestHelper extends SQLiteOpenHelper {

    public TestHelper(Context context) {
        super(context, Test.DB_NAME, null, Test.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "Create Table " + Test.TaskEntry.TABLE + " ( " +
                Test.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Test.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Test.TaskEntry.TABLE);
        onCreate(db);
    }
}

