package com.example.thanaphoombabparn.homeworkmyprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onClickBtn(View view){
        switch (view.getId()){
            case R.id.btnMe:
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                break;
            case R.id.btnSkill:
                startActivity(new Intent(MainActivity.this, SkillActivity.class));
                break;
            case R.id.btnComment:
                startActivity(new Intent(MainActivity.this, CommentActivity.class));
                break;
            default: break;
        }
    }
}
