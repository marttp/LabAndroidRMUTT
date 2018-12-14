package com.example.thanaphoombabparn.androidlab02;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double firstOperand = 0;
    private double secondOperand = 0;
    private double previousAnswer;

    private String operator = "";
    private int mode = 1;
    private boolean isOnAnswer = false;
    private String first = "";
    private String second = "";

    TextView textView = null;
    EditText editText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.textInput);

        textView.setText("");

    }

    public void onClickButton(View view) {

        switch (view.getId()) {
            case R.id.btn0:
                setTextShow("0", "operand");
                break;
            case R.id.btn1:
                setTextShow("1", "operand");
                break;
            case R.id.btn2:
                setTextShow("2", "operand");
                break;
            case R.id.btn3:
                setTextShow("3", "operand");
                break;
            case R.id.btn4:
                setTextShow("4", "operand");
                break;
            case R.id.btn5:
                setTextShow("5", "operand");
                break;
            case R.id.btn6:
                setTextShow("6", "operand");
                break;
            case R.id.btn7:
                setTextShow("7", "operand");
                break;
            case R.id.btn8:
                setTextShow("8", "operand");
                break;
            case R.id.btn9:
                setTextShow("9", "operand");
                break;
            case R.id.btnPoint:
                setTextShow(".", "operand");
                break;

            case R.id.btnPlus:
                setTextShow("+", "operator");
                break;
            case R.id.btnMinus:
                setTextShow("-", "operator");
                break;
            case R.id.btnMultiply:
                setTextShow("*", "operator");
                break;
            case R.id.btnDivide:
                setTextShow("/", "operator");
                break;
            case R.id.btnPowerValue:
                setTextShow("^", "operator");
                break;

            case R.id.btnPercent:
                calculate(first, second, operator);
                break;
            case R.id.btnPowerDouble:
                calculatePower(first, "2");
                break;

            case R.id.btnEqual:
                if(first.isEmpty() || second.isEmpty()) return;
                    else calculate(first, second);
                break;

            case R.id.btnClear:
                clearData();
                break;
        }
    }


    private void setTextShow(String text, String type) {
        switch (type) {
            case "operand":
                if (mode == 1) {
                    first += text;
                    editText.setText(first);
                } else {
                    second += text;
                    editText.setText(second);
                }
                break;
            case "operator":
                operator = text;
                mode = 2;
                break;
        }
        String textSet = first + " " + operator + " " + second;
        textView.setText(textSet);
    }

    private void calculate(String first, String second) {
        double answer = 0;
        try {
            isOnAnswer = true;
            firstOperand = Double.parseDouble(first);
            secondOperand = Double.parseDouble(second);


            switch (operator) {
                case "+":
                    answer = firstOperand + secondOperand;
                    break;
                case "-":
                    answer = firstOperand - secondOperand;
                    break;
                case "*":
                    answer = firstOperand * secondOperand;
                    break;
                case "/":
                    answer = firstOperand / secondOperand;
                    break;
                case "^":
                    answer = Math.pow(firstOperand, secondOperand);
                    break;
            }
        } catch (Exception e) {
            showDialog();
            return;
        }
        afterStepAnswer(answer);
    }

    private void calculate(String first, String second, String op) {
        double answer = 0;
        try {
            isOnAnswer = true;
            firstOperand = Double.parseDouble(first);
            secondOperand = Double.parseDouble(second);
            switch (op) {
                case "+":
                    answer = firstOperand + (firstOperand * (secondOperand / 100));
                    break;
                case "-":
                    answer = firstOperand - (firstOperand * (secondOperand / 100));
                    break;
                case "*":
                    answer = firstOperand * (firstOperand * (secondOperand / 100));
                    break;
                case "/":
                    answer = firstOperand / (firstOperand * (secondOperand / 100));
                    break;
            }
        } catch (Exception e) {
            showDialog();
            return;
        }
        afterStepAnswer(answer);
    }

    private void afterStepAnswer(double answer) {
        previousAnswer = answer;
        firstOperand = 0;
        secondOperand = 0;
        first = "";
        second = "";
        editText.setText(String.valueOf(answer));
    }

    private void calculatePower(String first, String power) {
        try {
            double answer = Math.pow(Double.parseDouble(first), Double.parseDouble(power));
            afterStepAnswer(answer);
        } catch (Exception e) {
            showDialog();
        }
    }

    private void clearData() {
        previousAnswer = 0;
        firstOperand = 0;
        secondOperand = 0;
        operator = "";
        mode = 1;
        isOnAnswer = false;
        first = "";
        second = "";
        textView.setText("");
        editText.setText("");
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Something error.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "Clear value", Toast.LENGTH_SHORT).show();
                clearData();
                dialog.dismiss();
            }
        });
        builder.show();
    }

}
