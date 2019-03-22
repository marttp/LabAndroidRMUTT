package com.example.traininglistview;

import com.google.android.gms.maps.model.LatLng;

public class MapLocation {
    private LatLng latLng;

    public MapLocation(LatLng latLng) {
        this.latLng = latLng;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
