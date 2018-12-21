package com.example.thanaphoombabparn.androidlab04;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnSign:
                intent = new Intent(getApplicationContext(), SignActivity.class);
                startActivity(intent);
                break;
            case R.id.btnUniversity:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.rmutt.ac.th/"));
                startActivity(intent);
                break;
            case R.id.btnExit:
                finish();
                break;
            default:
                break;
        }
    }
}
