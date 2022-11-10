package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button donationButton,needBloodButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donationButton = findViewById(R.id.donationButton);
        needBloodButton = findViewById(R.id.needBloodButton);

        donationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(pass);

            }
        });

        needBloodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass1 = new Intent(MainActivity.this,MainActivity4.class);
                startActivity(pass1);
            }
        });
    }


}