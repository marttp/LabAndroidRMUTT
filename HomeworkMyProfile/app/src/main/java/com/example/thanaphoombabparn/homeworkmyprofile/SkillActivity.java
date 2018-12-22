package com.example.thanaphoombabparn.homeworkmyprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class SkillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);

        ImageButton imageButton = findViewById(R.id.imageButtonBackProfile);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Switch swFrontend = findViewById(R.id.switch1);
        swFrontend.setChecked(true);
        swFrontend.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    findViewById(R.id.textFrontendContent).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.textFrontendContent).setVisibility(View.INVISIBLE);
                }
            }
        });

        Switch swBackend = findViewById(R.id.switch2);
        swBackend.setChecked(true);
        swBackend.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    findViewById(R.id.textBackendContent).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.textBackendContent).setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
