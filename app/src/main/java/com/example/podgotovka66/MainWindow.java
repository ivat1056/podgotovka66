package com.example.podgotovka66;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainWindow extends AppCompatActivity {
EditText search;
Spinner spinner;
ListView listView;
AdapterMask adapterMask;
List<Model> modelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);
        search = findViewById(R.id.search);
        spinner = findViewById(R.id.order);
        listView = findViewById(R.id.list);
        Get();

    }
    void Get(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://ngknn.ru:5001/NGKNN/%D0%9C%D0%B0%D0%BC%D1%88%D0%B5%D0%B2%D0%B0%D0%AE%D0%A1/%D0%AD%D0%BA%D0%B7%D0%B0%D0%BC%D0%B5%D0%BD/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI api = retrofit.create(RetrofitAPI.class);
        Call<List<Model>> call = api.getmodel();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                modelList = response.body();
                adapterMask = new AdapterMask(MainWindow.this,modelList);
                listView.setAdapter(adapterMask);
                adapterMask.notifyDataSetInvalidated();
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });
    }


}