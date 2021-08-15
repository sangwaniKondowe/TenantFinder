package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Landlord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord);

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, PlaceDetails.class);
        startActivity(intent);
    }

    public void onClickTwo(View view) {
        Intent intent = new Intent(this, View_Remove.class);
        startActivity(intent);
    }
    public void onClickThree(View view) {
        Intent intent = new Intent(this, Notifications.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, LandlordLogin.class);
        startActivity(intent);
    }
}