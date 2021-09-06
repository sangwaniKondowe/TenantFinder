package com.example.tenantfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class tenant_form_activity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tenantfinder-60751-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_form);

        final EditText tUsername = findViewById(R.id.tntname);
        final EditText tEmail = findViewById(R.id.tntEmail);
        final EditText tPassword = findViewById(R.id.tntPassword);
        final EditText tConfPassword = findViewById(R.id.tnt_confirmPassword);
        final Button signUp = findViewById(R.id.btn_signup_send_request_tnt);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = tUsername.getText().toString();
                final String email = tEmail.getText().toString();
                final String password = tPassword.getText().toString();
                final String confPassword = tConfPassword.getText().toString();

                if(username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(tenant_form_activity.this, "Please fill all fields",Toast.LENGTH_SHORT).show();
                }
                else if(!password.equals(confPassword)) {
                    Toast.makeText(tenant_form_activity.this, "Passwords are not matching",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("tenants").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.hasChild(username)) {
                                Toast.makeText(tenant_form_activity.this, "Username is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else {

                                databaseReference.child("tenants").child(username).child("email").setValue(email);
                                databaseReference.child("tenants").child(username).child("password").setValue(password);

                                Toast.makeText(tenant_form_activity.this, "Signed up successfully.",Toast.LENGTH_SHORT).show();
                                finish();
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


