package com.example.tiffany.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Tiffany on 04-Mar-17.
 */

public class SQLController {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_RECIPE = "_recipe";
    public static final String KEY_DETAILS = "_details";

    private static final String DB_NAME = "Recipe_db";
    private static final String DB_TABLE = "RecipeTable";
    private static final int DB_VERSION = 1;

    private DatabaseHelper myHelper;
    private Context myContext;
    private SQLiteDatabase myDatabase;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String LOGCAT = null;

        public DatabaseHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            Log.d(LOGCAT, "Created.");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DB_TABLE + " ("
                    + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + KEY_RECIPE + " TEXT NOT NULL,"
                    + KEY_DETAILS + " TEXT NOT NULL);");
            Log.d(LOGCAT, "Recipe Table Created");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
        }

    }

    public SQLController(Context c) {
        myContext = c;
    }

    public SQLController open() throws SQLException {
        myHelper = new DatabaseHelper(myContext);
        myDatabase = myHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        myHelper.close();
    }

    public long createEntry(String recipe, String details) throws Exception {
        ContentValues contentvalue = new ContentValues();
        contentvalue.put(KEY_RECIPE, recipe);
        contentvalue.put(KEY_DETAILS, details);
        return myDatabase.insertOrThrow(DB_TABLE, null, contentvalue);
    }

    public Cursor query(String query) {
        return myDatabase.rawQuery(query, null);
    }


}
