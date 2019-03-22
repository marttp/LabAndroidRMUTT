package com.example.traininglistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LocationAdapter extends BaseAdapter {

    private Context context;
    private List<MapLocation> mapLocationList;

    public LocationAdapter(Context context, List<MapLocation> mapLocationList) {
        this.context = context;
        this.mapLocationList = mapLocationList;
    }

    @Override
    public int getCount() {
        if(mapLocationList == null){
            return 0;
        }
        return mapLocationList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewShow = inflater.inflate(R.layout.location_list, parent, false);

        TextView textLat = viewShow.findViewById(R.id.latValue);
        TextView textLng = viewShow.findViewById(R.id.longValue);
        textLat.setText(String.valueOf(mapLocationList.get(position).getLatLng().latitude));
        textLng.setText(String.valueOf(mapLocationList.get(position).getLatLng().longitude));


        return viewShow;
    }
}
