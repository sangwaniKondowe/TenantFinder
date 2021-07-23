package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class View_Remove extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_remove);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}