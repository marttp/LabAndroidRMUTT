package com.example.mysqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        final EditText editText = findViewById(R.id.editTextStu);
        Button btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentList student = new StudentList();
                student.setStdName(String.valueOf(editText.getText()));

                StudentListDAO studentListDAO = new StudentListDAO(getApplicationContext());
                studentListDAO.open();
                studentListDAO.add(student);
                studentListDAO.close();

                finish();
            }
        });
    }
}
