package com.example.finaltest;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DecimalFormat;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    int whatIsResult;
    double lat;
    double lng;
    double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        whatIsResult = getIntent().getIntExtra("whatIsResult",0);
        lat = getIntent().getDoubleExtra("lat",0);
        lng = getIntent().getDoubleExtra("lng",0);
        bmi = getIntent().getDoubleExtra("bmiResult",0);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng location = new LatLng(lat, lng);
        String answerShow = "";

        switch (whatIsResult) {
            case 1:
                answerShow = getText(R.string.very_fat_result).toString();
                break;
            case 2:
                answerShow = getText(R.string.fat_result).toString();
                break;
            case 3:
                answerShow = getText(R.string.more_normal_result).toString();
                break;
            case 4:
                answerShow = getText(R.string.normal_result).toString();
                break;
            case 5:
                answerShow = getText(R.string.thin_result).toString();
                break;
            default:
                break;
        }

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(3);
        mMap.addMarker(new MarkerOptions().position(location).title(answerShow+"("+String.valueOf(df.format(bmi))+")"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
}
