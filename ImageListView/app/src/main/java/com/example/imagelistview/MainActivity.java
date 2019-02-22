package com.example.imagelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Hardware> hardwareList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> resId = Arrays.asList(R.drawable.mobile, R.drawable.notebook, R.drawable.pc, R.drawable.printer, R.drawable.keyboard, R.drawable.mouse, R.drawable.speaker, R.drawable.earphone);
        List<String> menuName = Arrays.asList("Mobile", "Notebook", "PC", "Printer", "Keyboard", "Mouse", "Speaker", "Earphone");
        List<String> description = Arrays.asList(
                getString(R.string.mobile_des),
                getString(R.string.notebook_des),
                getString(R.string.pc_des),
                getString(R.string.printer_des),
                getString(R.string.keyboard_des),
                getString(R.string.mouse_des),
                getString(R.string.speaker_des),
                getString(R.string.headphone_des)
        );

        listView = findViewById(R.id.imageListView);

        for (int i=0; i < resId.size(); i++){
            hardwareList.add(new Hardware(resId.get(i), menuName.get(i), description.get(i)));
        }

        ListAdapter listAdapter = new ListAdapter(this, hardwareList);
        listView.setAdapter(listAdapter);
    }

}
