package com.example.blood;



import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity2 extends AppCompatActivity {

    EditText edName,edMobile,edHealthIssues,edLocation;
    Spinner spinner1;
    CheckBox checkBox;
    Button bSubmit,pickDonationDate;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    DatePickerDialog dp;
    String dt;
    SimpleDateFormat sdf;
    Calendar c;
    TextView edDonationDate,edNextDonationDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edName = findViewById(R.id.edName);
        edMobile = findViewById(R.id.edMobile);
        edDonationDate = findViewById(R.id.edDonationDate);
        edNextDonationDay = findViewById(R.id.edNextDonationDay);
        edHealthIssues = findViewById(R.id.edHealthIssues);
        edLocation = findViewById(R.id.edLocation);
        bSubmit = findViewById(R.id.bSubmit);
        spinner1 = findViewById(R.id.spinner1);
        pickDonationDate = findViewById(R.id.pickDonationDate);
        checkBox = findViewById(R.id.checkBox);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    edHealthIssues.setVisibility(View.VISIBLE);
                }
                else {
                    edHealthIssues.setVisibility(View.INVISIBLE);
                }
            }
        });

        //array list for blood type(spinner)
        arrayList = new ArrayList();
        arrayList.add("Type A");
        arrayList.add("Type B");
        arrayList.add("Type AB");
        arrayList.add("Type O");

        arrayAdapter = new ArrayAdapter(MainActivity2.this, android.R.layout.simple_list_item_1,arrayList);
        spinner1.setAdapter(arrayAdapter);

        pickDonationDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 dp = new DatePickerDialog(MainActivity2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        int month = i1+1;

                        String s = i2+"/"+month+"/"+i;

                        edDonationDate.setText(s);
                        //next donation day + 60 days
                        dt = edDonationDate.getText().toString();
                        sdf = new SimpleDateFormat("MM/dd/yyyy");
                        Calendar c = Calendar.getInstance();
                        try {
                            c.setTime(sdf.parse(dt));
                        }
                        catch (ParseException e){
                            e.printStackTrace();
                        }
                        c.add(Calendar.DATE,60);

                        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
                        String output = sdf1.format(c.getTime());
                        edNextDonationDay.setText(output);

                    }
                },
                        2022,
                        0,
                        7);
        dp.show();
           }

        });



        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //saveData();
                Save save = new Save();
                save.execute();
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }


        });

    }


    class Save extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            UserModel userModel = new UserModel();
            userModel.setName(edName.getText().toString());
            userModel.setMobile(edMobile.getText().toString());
            userModel.setLocation(edLocation.getText().toString());
            userModel.setBloodtype(spinner1.getSelectedItem().toString());
            userModel.setNextdate(edNextDonationDay.getText().toString());
            userModel.setHealthIssue(edHealthIssues.getText().toString());
            DataBase.getDataBase(getApplicationContext()).getDao().insertAllData(userModel);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            Toast.makeText(getApplicationContext(),"Your Application is saved Thank you",Toast.LENGTH_LONG).show();
        }
    }
}