package com.example.midtermexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MapProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_process);

        Button btnGoMap = findViewById(R.id.btnGoMap);
        btnGoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editTextLatitude = findViewById(R.id.editTextLatitude);
                EditText editTextLongitude = findViewById(R.id.editTextLongitude);

                EditText editTextHeight = findViewById(R.id.editTextHeight);
                EditText editTextWidth = findViewById(R.id.editTextWidth);

                double lat = Double.parseDouble(editTextLatitude.getText().toString());
                double lng = Double.parseDouble(editTextLongitude.getText().toString());

                double height = Double.parseDouble(editTextHeight.getText().toString());
                double width = Double.parseDouble(editTextWidth.getText().toString());

                Intent intent = new Intent(MapProcessActivity.this, MapsActivity.class);

                intent.putExtra("latitude", lat);
                intent.putExtra("longitude", lng);
                intent.putExtra("height", height);
                intent.putExtra("width", width);

                startActivity(intent);
            }
        });
    }
}
