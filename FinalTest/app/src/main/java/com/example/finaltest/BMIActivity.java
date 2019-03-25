package com.example.finaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static java.lang.System.out;

public class BMIActivity extends AppCompatActivity {

    EditText inputHeight;
    EditText inputWeight;

    TextView bmiResult;
    TextView bmiResultText;

    EditText inputLat;
    EditText inputLong;

    double heightInMeter;
    double weightKilogram;
    double bmi;
    double lat;
    double lng;
    String answerShow;
    int whatIsResult = 0;
    DecimalFormat df = new DecimalFormat();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        Button btnCalculate = findViewById(R.id.btnCalculateBmi);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputHeight = findViewById(R.id.inputHeight);
                inputWeight = findViewById(R.id.inputWeight);
                bmiResult = findViewById(R.id.bmiResult);
                bmiResultText = findViewById(R.id.bmiResultText);

                try {

                    if(inputHeight.getText().toString().trim().length() > 0){
                        heightInMeter = Double.parseDouble(inputHeight.getText().toString()) / 100;
                        weightKilogram = Double.parseDouble(inputWeight.getText().toString());
                        out.println("heightInMeter = "+heightInMeter);
                        out.println("weightKilogram = "+weightKilogram);

                        bmi = weightKilogram / Math.pow(heightInMeter,2);
                        Log.i("BMI", String.valueOf(bmi));

                        whatIsResult = bmi >= 30 ? 1 :
                                (bmi >= 25 && bmi < 30) ? 2 :
                                        (bmi >= 23 && bmi < 25) ? 3 :
                                                (bmi >= 18.6 && bmi < 23) ? 4 :
                                                        (bmi < 18.5) ? 5 : 0;

                        df.setMaximumFractionDigits(3);
                        bmiResult.setText(String.valueOf(df.format(bmi)));

                        switch (whatIsResult) {
                            case 1:
                                bmiResultText.setText(getText(R.string.very_fat));
                                break;
                            case 2:
                                bmiResultText.setText(getText(R.string.fat));
                                break;
                            case 3:
                                bmiResultText.setText(getText(R.string.more_normal));
                                break;
                            case 4:
                                bmiResultText.setText(getText(R.string.normal));
                                break;
                            case 5:
                                bmiResultText.setText(getText(R.string.thin));
                                break;
                            default:
                                bmiResultText.setText("Error");
                                break;
                        }
                    }
                    out.println("whatIsResult = "+whatIsResult);

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(BMIActivity.this, "Something wrong. Check input", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        Button btnGoMap = findViewById(R.id.btnGoMap);
        btnGoMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputLat = findViewById(R.id.inputLat);
                inputLong = findViewById(R.id.inputLng);
                try{
                    if(whatIsResult != 0){
                        if(inputLat.getText().toString().trim().length() > 0 && inputLong.getText().toString().trim().length() > 0){
                            lat = Double.parseDouble(inputLat.getText().toString());
                            lng = Double.parseDouble(inputLong.getText().toString());

                            Intent intent = new Intent(BMIActivity.this, MapsActivity.class);

                            intent.putExtra("lat", lat);
                            intent.putExtra("lng", lng);
                            intent.putExtra("bmiResult", bmi);
                            intent.putExtra("whatIsResult", whatIsResult);

                            startActivity(intent);
                        }
                    } else {
                        Toast.makeText(BMIActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(BMIActivity.this, "Check height, weight, lat, lng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
