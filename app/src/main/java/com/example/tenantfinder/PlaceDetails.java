package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PlaceDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}