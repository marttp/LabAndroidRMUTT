package com.example.androidlab8;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String pathFahkwanB = "fonts/TH Fahkwang Bold.ttf";
        Typeface fontFahkwanB = Typeface.createFromAsset(getAssets(), pathFahkwanB);
        final TextView txtRMUTT = findViewById(R.id.txtRMUTT);
        txtRMUTT.setTypeface(fontFahkwanB);
        final String[] facultyName = new String[]{
                "1. FACULTY OF ENGINEERING",
                "2. FACULTY OF BUSINESS ADMINISTRATION",
                "3. FACULTY OF SCIENCE AND TECHNOLOGY",
                "4. FACULTY OF TECHNICAL EDUCATION",
                "5. FACULTY OF ARCHITECTURE"
        };
        ListView listViewMain = findViewById(R.id.listViewMain);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, facultyName);
        listViewMain.setAdapter(adapter);
        listViewMain.setAdapter(adapter);
        listViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, DepartmentActivity.class));
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });
    }
}
