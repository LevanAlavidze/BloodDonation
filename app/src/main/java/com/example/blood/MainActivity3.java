package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerView;
    Spinner spinner;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;

    private List<UserModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView = findViewById(R.id.recyclerview);
        spinner = findViewById(R.id.spinner);



        //array list for blood type(spinner)
        arrayList = new ArrayList();
        arrayList.add("Type A");
        arrayList.add("Type B");
        arrayList.add("Type AB");
        arrayList.add("Type O");

        arrayAdapter = new ArrayAdapter(MainActivity3.this, android.R.layout.simple_list_item_1,arrayList);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               // list = DataBase.getDataBase(getApplicationContext()).getDao().blody();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        getData();
    }

    private void getData() {

        list = new ArrayList<>();
        list = DataBase.getDataBase(getApplicationContext()).getDao().getAllData();
        recyclerView.setAdapter(new UserAdapter(getApplicationContext(),DataBase.getDataBase(getApplicationContext()).getDao().getAllData()));

    }
}