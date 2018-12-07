package com.example.thanaphoombabparn.androidlab01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConvertDegreeActivity extends AppCompatActivity {

    EditText celsiusEditText = null;
    Button btnConvert = null;
    TextView farenShowAnswer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert_degree);

        btnConvert = findViewById(R.id.btnConvertDegree);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                celsiusEditText = findViewById(R.id.editText3);
                farenShowAnswer = findViewById(R.id.farenText);

                try {
                    Double celsius = (Double.parseDouble(celsiusEditText.getText().toString())*1.8)+32;
                    farenShowAnswer.setTextSize(24);
                    farenShowAnswer.setText(celsius.toString());
                } catch (Exception e) {
                    farenShowAnswer.setTextSize(18);
                    farenShowAnswer.setText("Invalid celsius");
                }

            }
        });

    }
}
