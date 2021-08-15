package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LandlordLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_login);

        Button btn = (Button) findViewById(R.id.btn_signup_send_request_lnd);

        btn.setOnClickListener(v -> {
            Intent intent3 = new Intent(LandlordLogin.this, Landlord.class);
            startActivity(intent3);
        });
    }
}