package com.example.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class StudentListDAO {
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public StudentListDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public ArrayList<String> getAllStudentList(){

        ArrayList<String> studentList = new ArrayList();
        String query = "SELECT * FROM student_list;";

        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            studentList.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return studentList;
    }

    public void add(StudentList studentList){
        StudentList newStudent = new StudentList();
        newStudent = studentList;
        ContentValues values = new ContentValues();
        values.put("std_name", newStudent.getStdName());
        this.database.insert("student_list", null, values);
        Log.d("Student list demo", "Add student complete!!");
    }

}
