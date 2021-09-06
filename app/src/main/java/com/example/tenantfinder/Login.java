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

public class Login extends AppCompatActivity{
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tenantfinder-60751-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final EditText username = findViewById(R.id.tnt_user);
        final EditText password = findViewById(R.id.tntPassword);
        final Button btn = findViewById(R.id.btn_tenant_login);


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final String userTxt = username.getText().toString();
               final String passwordTxt = password.getText().toString();

               if(userTxt.isEmpty() || passwordTxt.isEmpty()) {
                   Toast.makeText(Login.this, "Please enter your email or password", Toast.LENGTH_SHORT).show();
               }
               else {

                   databaseReference.child("tenants").addListenerForSingleValueEvent(new ValueEventListener() {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot) {
                           if(snapshot.hasChild(userTxt)) {

                               final String getPassword = snapshot.child(userTxt).child("password").getValue(String.class);

                               if(getPassword.equals(passwordTxt)) {

                                   Toast.makeText(Login.this, "Successfully signed in.", Toast.LENGTH_SHORT).show();
                                   startActivity(new Intent(Login.this, TenantHomeActivity.class));
                                   finish();
                               }
                               else {
                                   Toast.makeText(Login.this, "Wrong password.", Toast.LENGTH_SHORT).show();
                               }
                           } else {
                               Toast.makeText(Login.this, "Wrong username.", Toast.LENGTH_SHORT).show();
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