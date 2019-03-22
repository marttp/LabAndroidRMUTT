package com.example.cryptorate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.CustomViewHolder> {

    public Context context;
    public List<Cryptocurrency> cryptocurrencyList = new ArrayList<>();

    private class ComparatorCrypto implements Comparator<Cryptocurrency> {
        @Override
        public int compare(Cryptocurrency o1, Cryptocurrency o2) {
            return o1.getRank() - o2.getRank();
        }
    }

    public CryptoAdapter(Context context, List<Cryptocurrency> cryptocurrencyList) {
        this.context = context;
        this.cryptocurrencyList = cryptocurrencyList;
        Collections.sort(this.cryptocurrencyList, new ComparatorCrypto());
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView textIcon;
        TextView textName;
        TextView textRank;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            textIcon = mView.findViewById(R.id.textIcon);
            textRank = mView.findViewById(R.id.textRank);
            textName = mView.findViewById(R.id.textName);

        }
    }

    @Override
    public long getItemId(int position) {
        return cryptocurrencyList.get(position).hashCode();
    }

    @Override
    public int getItemCount() {
        if(cryptocurrencyList == null){
            return 0;
        }
        return cryptocurrencyList.size();
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.crypto_list_data, viewGroup, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.textIcon.setText(cryptocurrencyList.get(i).getSymbol());
        customViewHolder.textRank.setText(String.valueOf(cryptocurrencyList.get(i).getRank()));
        customViewHolder.textName.setText(cryptocurrencyList.get(i).getName());
    }

}
