package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    Spinner spinner;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        spinner = findViewById(R.id.spinner2);
        recyclerView = findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        //array list for blood type(spinner)
        arrayList = new ArrayList();
        arrayList.add("Type A");
        arrayList.add("Type B");
        arrayList.add("Type AB");
        arrayList.add("Type O");

        arrayAdapter = new ArrayAdapter(MainActivity4.this, android.R.layout.simple_list_item_1,arrayList);
        spinner.setAdapter(arrayAdapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                GetUsers getUsers = new GetUsers();
                getUsers.execute();



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }

    class GetUsers extends AsyncTask<Void,Void,List<UserModel>>{

        @Override
        protected List<UserModel> doInBackground(Void... voids) {
            List<UserModel> listForGet = DataBase.getDataBase(getApplicationContext()).getDao().blody(spinner.getSelectedItem().toString());

            return listForGet;
        }

        @Override
        protected void onPostExecute(List<UserModel> list) {
            super.onPostExecute(list);
            UserAdapter userAdapter = new UserAdapter(MainActivity4.this,list);

            recyclerView.setAdapter(userAdapter);



        }
    }



}