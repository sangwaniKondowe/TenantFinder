package com.example.tenantfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LandlordLogin extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tenantfinder-60751-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_login);

        final EditText phonenumber = findViewById(R.id.phoneNumber);
        final EditText password = findViewById(R.id.lndPassword);
        final Button btnLogin = findViewById(R.id.btn_signup_send_request_lnd);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phoneTxt = phonenumber.getText().toString();
                final String passwordTxt = password.getText().toString();

                if(phoneTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(LandlordLogin.this, "Please enter your mobile or password", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference.child("landlords").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phoneTxt)) {

                                final String getPassword = snapshot.child(phoneTxt).child("password").getValue(String.class);

                                if(getPassword.equals(passwordTxt)) {

                                    Toast.makeText(LandlordLogin.this, "Successfully signed in.", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LandlordLogin.this, Landlord.class));
                                    finish();
                                }
                                else {
                                    Toast.makeText(LandlordLogin.this, "Wrong password.", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(LandlordLogin.this, "Wrong mobile number.", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

        });

    }
}