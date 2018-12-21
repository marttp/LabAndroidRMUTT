package com.example.thanaphoombabparn.androidlab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGo2 = null;
    Button btnGo3 = null;
    Button btnExit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGo2 = findViewById(R.id.go2);
        btnGo3 = findViewById(R.id.go3);
        btnExit = findViewById(R.id.btnExit);

        btnGo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PageTwoActivity.class);
                startActivity(intent);
            }
        });

        btnGo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PageThreeActivity.class);
                startActivity(intent);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void onClickBtn(View view){
        Intent intent = new Intent(getApplicationContext(), PageFourActivity.class);
        startActivity(intent);
    }
}
