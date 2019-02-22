package com.example.androidlab8;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DepartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        String pathFahkwanB = "fonts/TH Fahkwang Bold.ttf";
        Typeface fontFahkwanB = Typeface.createFromAsset(getAssets(), pathFahkwanB);
        TextView txtDepartment = findViewById(R.id.txtDepartment);
        txtDepartment.setTypeface(fontFahkwanB);
        txtDepartment.setTextSize(40);
        txtDepartment.setTextColor(Color.rgb(0, 0, 255));

        String[] departmentName = new String[]{"1. CPE", "2. EE",
                "3. ETE", "4. CE",
                "5. ME", "6. IE",
                "7. CHE", "Exit"
        };

        ListView listViewDepartment = findViewById(R.id.listViewDepartment);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, departmentName);
        listViewDepartment.setAdapter(adapter);
        listViewDepartment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = "You have selected " + ((TextView) view).getText();
                msg += " at position " + String.valueOf(i);
                Toast.makeText(DepartmentActivity.this, msg, Toast.LENGTH_SHORT).show();
                if (i == 7) finish();
            }
        });
    }
}
