package com.example.finaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.finaltest.ListData.Person;
import com.example.finaltest.ListData.PersonAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Person> personList = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> firstNameList = Arrays.asList("Thanaphoom","Mart");
        List<String> lastNameList = Arrays.asList("Babparn", "Melo");
        List<Integer> ageList = Arrays.asList(22, 18);
        List<Integer> imageList = Arrays.asList(R.drawable.person1, R.drawable.person2);

        listView = findViewById(R.id.listViewShow);

        for (int i = 0; i < firstNameList.size(); i++){
            personList.add(new Person(firstNameList.get(i), lastNameList.get(i), ageList.get(i), imageList.get(i)));
        }

        PersonAdapter personAdapter = new PersonAdapter(this, personList);
        listView.setAdapter(personAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, BMIActivity.class));
            }
        });
    }
}
