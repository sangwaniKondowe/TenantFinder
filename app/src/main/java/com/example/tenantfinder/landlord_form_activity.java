package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class landlord_form_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_form);
    }

    public void onClickSignUp(View view) {
        Intent intent = new Intent(this, tenant_form_activity.class);
        startActivity(intent);
    }
}