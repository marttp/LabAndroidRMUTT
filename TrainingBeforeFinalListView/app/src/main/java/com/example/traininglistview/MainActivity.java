package com.example.traininglistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private List<MapLocation> mapLocationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        for (int i = 0; i < 20; i++) {
            mapLocationList.add(new MapLocation(
                    new LatLng(
                            ThreadLocalRandom.current().nextDouble(12, 15),
                            ThreadLocalRandom.current().nextDouble(100, 150)
                    )));
        }

        LocationAdapter locationAdapter = new LocationAdapter(this, mapLocationList);
        listView.setAdapter(locationAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("latitude",mapLocationList.get(position).getLatLng().latitude);
                intent.putExtra("longitude",mapLocationList.get(position).getLatLng().longitude);
                startActivity(intent);
            }
        });
    }
}
