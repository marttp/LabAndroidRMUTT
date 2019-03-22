package com.example.cryptorate;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CryptoAdapter cryptoAdapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        CryptoServices cryptoServices = RetrofitClientInstance.getRetrofitInstance().create(CryptoServices.class);
        Call<JsonElement> call = cryptoServices.getAllCrypto("fd6eee4bc90c1e7b","BTC",1,"volume_desc");
        call.enqueue(new Callback<JsonElement>() {

            @Override
            public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    JSONArray jsonArrayResponsed = jsonObject.getJSONArray("coins");
                    ArrayList<Cryptocurrency> arrayList = new Gson().fromJson(jsonArrayResponsed.toString(), new TypeToken<List<Cryptocurrency>>(){}.getType());
                    initCryptoDataList(arrayList);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JsonElement> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initCryptoDataList(List<Cryptocurrency> cryptocurrencyList){
        recyclerView = findViewById(R.id.recyclerView);
        cryptoAdapter = new CryptoAdapter(this, cryptocurrencyList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(cryptoAdapter);
    }
}
