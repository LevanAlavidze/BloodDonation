package com.example.blood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final extends AppCompatActivity {

    TextView tvName,tvMobile,tvLocation,tvBloodType,tvDonationDate,tvHealth;
    Button bCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        tvName = findViewById(R.id.tvName);
        tvMobile = findViewById(R.id.tvMobile);
        tvLocation = findViewById(R.id.tvLocation);
        tvBloodType = findViewById(R.id.tvBloodType);
        tvDonationDate = findViewById(R.id.tvDonationDate);
        tvHealth = findViewById(R.id.tvHealth);

        bCall = findViewById(R.id.bCall);


        UserModel userModel = (UserModel) getIntent().getSerializableExtra("pass");
        tvName.setText(userModel.getName());
        tvMobile.setText(userModel.getMobile());
        tvLocation.setText(userModel.getLocation());
        tvBloodType.setText(userModel.getBloodtype());
        tvDonationDate.setText(userModel.getNextdate());
        tvHealth.setText(userModel.getHealthIssue());

        bCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callToBlood(tvMobile.getText().toString());
            }
        });





    }

    private void callToBlood(final String mobNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", mobNumber, null)));
    }
}