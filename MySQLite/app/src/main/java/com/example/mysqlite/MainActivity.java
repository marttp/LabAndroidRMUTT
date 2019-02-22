package com.example.mysqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView studentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentListView = findViewById(R.id.studentListView);

        Button btnNewStudent = findViewById(R.id.btnNewStu);
        btnNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddNewActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // initialize connection
        StudentListDAO studentListDAO = new StudentListDAO(getApplicationContext());
        studentListDAO.open();
        // Do something
        ArrayList<String> myList = studentListDAO.getAllStudentList();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, R.layout.simple_list_item, R.id.listItem, myList);
        studentListView.setAdapter(adapter);
        studentListDAO.close();
    }
}
