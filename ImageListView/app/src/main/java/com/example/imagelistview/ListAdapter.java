package com.example.imagelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<Hardware> hardwareList = new ArrayList<>();

    ListAdapter(Context context, List<Hardware> hardwareList){
        this.context = context;
        this.hardwareList = hardwareList;
    }

    @Override
    public int getCount() {
        if(hardwareList == null){
            return 0;
        }
        return hardwareList.size();
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
        View viewShow;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewShow = inflater.inflate(R.layout.list_item, parent, false);

        ImageView imageView = viewShow.findViewById(R.id.image);
        TextView category = viewShow.findViewById(R.id.type);
        TextView description = viewShow.findViewById(R.id.typeDescription);

        imageView.setImageResource(hardwareList.get(position).getResId());
        category.setText(hardwareList.get(position).getCategory());
        description.setText(hardwareList.get(position).getDescription());

        return viewShow;
    }
}
