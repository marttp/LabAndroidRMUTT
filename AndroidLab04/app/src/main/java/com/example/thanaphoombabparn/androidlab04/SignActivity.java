package com.example.thanaphoombabparn.androidlab04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        ImageButton imageButton = findViewById(R.id.imageBtn1);
        Button button = findViewById(R.id.btnSign);
        final EditText editText1 = findViewById(R.id.editText);
        final EditText editText2 = findViewById(R.id.editText2);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = editText1.getText().toString();
                String lastName = editText2.getText().toString();
                if(firstName.trim().isEmpty()){
                    Toast.makeText(SignActivity.this,"First name is empty",Toast.LENGTH_SHORT).show();
                } else if(lastName.trim().isEmpty()){
                    Toast.makeText(SignActivity.this,"Last name is empty",Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SignActivity.this, ShowSignActivity.class);
                    intent.putExtra("firstName",firstName);
                    intent.putExtra("lastName",lastName);
                    startActivity(intent);
                }
            }
        });
    }
}
