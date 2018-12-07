package com.example.thanaphoombabparn.androidlab01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExampleActivity extends AppCompatActivity {

    EditText editText = null;
    Button btnShow = null;
    Button btnSetRmutt = null;
    Button btnNextAct = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        editText = findViewById(R.id.editText2);
        btnShow = findViewById(R.id.btnShowAct2);
        btnSetRmutt = findViewById(R.id.btnSetRmutt);
        btnNextAct = findViewById(R.id.btnNext2);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().trim().equals("")){
                    Toast.makeText(ExampleActivity.this, "Hello "+editText.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSetRmutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("RMUTT");
            }
        });

        btnNextAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExampleActivity.this, ConvertDegreeActivity.class));
            }
        });

    }
}
