package com.example.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String databaseName = "student.sqlite";
    private static final int dbVersion = 1;

    // Context is class for get something of change page.
    Context myContext;

    private static final String tableCreateSQL = "CREATE TABLE student_list(id INTEGER PRIMARY KEY AUTOINCREMENT, std_name TEXT);";

    public DBHelper(Context context) {
        super(context, databaseName, null, dbVersion);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreateSQL);
        String insertData1 = "INSERT INTO student_list(std_name) VALUES ('RMUTT 1');";
        String insertData2 = "INSERT INTO student_list(std_name) VALUES ('RMUTT 2');";
        String insertData3 = "INSERT INTO student_list(std_name) VALUES ('RMUTT 3');";

        db.execSQL(insertData1);
        db.execSQL(insertData2);
        db.execSQL(insertData3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
