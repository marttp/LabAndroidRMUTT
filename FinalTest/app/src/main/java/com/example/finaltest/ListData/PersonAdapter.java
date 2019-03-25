package com.example.finaltest.ListData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finaltest.R;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends BaseAdapter {

    Context context;
    List<Person> personList = new ArrayList<>();

    public PersonAdapter(Context context, List<Person> personList){
        this.context = context;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        if(personList == null){
            return 0;
        }
        return personList.size();
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
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewShow = layoutInflater.inflate(R.layout.person_data, parent, false);

        ImageView imageView = viewShow.findViewById(R.id.avatarImage);
        TextView textFirstName = viewShow.findViewById(R.id.textFirstName);
        TextView textLastName = viewShow.findViewById(R.id.textLastName);
        TextView textAge = viewShow.findViewById(R.id.textAge);

        imageView.setImageResource(personList.get(position).getImgId());
        textFirstName.setText(personList.get(position).getFisrtName());
        textLastName.setText(personList.get(position).getLastName());
        textAge.setText(String.valueOf(personList.get(position).getAge()));

        return viewShow;
    }
}
