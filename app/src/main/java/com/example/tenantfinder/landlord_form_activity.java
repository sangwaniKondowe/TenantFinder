package com.example.tenantfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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


public class landlord_form_activity extends AppCompatActivity {
  //  EditText username, email, phoneNumber, password, reenterPassword;


    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://tenantfinder-60751-default-rtdb.firebaseio.com/");

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_form);

        final EditText mUserName = findViewById(R.id.lndname);
        final EditText mEmail = findViewById(R.id.lndEmail);
        final EditText mPhoneNumber = findViewById(R.id.landlord_phone);
        final EditText mPassword = findViewById(R.id.lndPassword);
        final EditText mConfPassword = findViewById(R.id.lnd_confirmPassword);
        final Button signUp = findViewById(R.id.btn_signup_send_request_lnd);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = mUserName.getText().toString();
                final String email = mEmail.getText().toString();
                final String phone = mPhoneNumber.getText().toString();
                final String password = mPassword.getText().toString();
                final String confPassword = mConfPassword.getText().toString();

                if(username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(landlord_form_activity.this, "Please fill all fields",Toast.LENGTH_SHORT).show();
                }
                else if(!password.equals(confPassword)) {
                    Toast.makeText(landlord_form_activity.this, "Passwords are not matching",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("landlords").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.hasChild(phone)) {
                                Toast.makeText(landlord_form_activity.this, "Phone is already registered", Toast.LENGTH_SHORT).show();
                            }
                            else {

                                databaseReference.child("landlords").child(phone).child("username").setValue(username);
                                databaseReference.child("landlords").child(phone).child("email").setValue(email);
                                databaseReference.child("landlords").child(phone).child("password").setValue(password);

                                Toast.makeText(landlord_form_activity.this, "Signed up successfully.",Toast.LENGTH_SHORT).show();
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

    public void onClickSignUp(View view) {
        startActivity(new Intent(this,tenant_form_activity.class));
        finish();
    }
}


//    signUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(checkDataEntered()){
//                    Toast.makeText(landlord_form_activity.this, "Success!", Toast.LENGTH_SHORT).show();
//                };
//            }
//        });
//    }

//    boolean isEmail(EditText text) {
//        CharSequence email = text.getText().toString();
//        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
//    }
//
//    boolean isEmpty(EditText text) {
//        CharSequence str = text.getText().toString();
//        return TextUtils.isEmpty(str);
//    }
//
//    boolean checkDataEntered() {
//        if (isEmpty(username)) {
//            username.setError("Username cannot be empty");
//            mUserName = null;
//        }else {
//            mUserName = username.getText().toString().trim();
//        }
//        if (isEmail(email) == false) {
//            email.setError("Enter valid email!");
//            mEmail = null;
//        } else {
//            mEmail = email.getText().toString().trim();
//        }
//        if (phoneNumber.getText().toString().length() == 0) {
//            phoneNumber.setError("Enter a phone number!");
//            mPhoneNumber = null;
//        } else {
//            mPhoneNumber = phoneNumber.getText().toString().trim();
//        }
//        if(password.getText().toString().length() == 0){
//            password.setError("Password not entered");
//            mPassword = null;
//        } else if(password.getText().toString().length() < 8) {
//            password.setError("Password should be at least of 8 characters");
//        } else {
//            mPassword = password.getText().toString().trim();
//        }
//        if(reenterPassword.getText().toString().length() == 0){
//            reenterPassword.setError("Please confirm password!");
//            mConfPassword = null;
//        } else if (!password.getText().toString().equals(reenterPassword.getText().toString())){
//            reenterPassword.setError("Password Not matched!");
//            return password == reenterPassword;
//        }else {
//            mConfPassword = reenterPassword.getText().toString().trim();
//        }
//
//        return mUserName != null && mEmail != null && mPhoneNumber != null && mPassword != null && reenterPassword != null;
//
//}
//public void onClickSignUp(View view) {
//        Intent intent = new Intent(this, tenant_form_activity.class);
//        startActivity(intent);
//        }
//        }

//public class landlord_form_activity extends AppCompatActivity {
//
//    EditText mUsername, mEmail, mPhoneNumber, mPassword, mReenterPassword;
//    Button mSignUp;
//    FirebaseAuth fAuth;
//    ProgressBar progressBar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_landlord_form);
//
//        mUsername = findViewById(R.id.tntname);
//        mEmail = findViewById(R.id.email);
//        mPhoneNumber = findViewById(R.id.landlord_phone);
//        mPassword = findViewById(R.id.tntPassword);
//        mReenterPassword = findViewById(R.id.tnt_confirmPassword);
//        mSignUp = findViewById(R.id.btn_signup_send_request);
//
//        fAuth = FirebaseAuth.getInstance();
//        progressBar = findViewById(R.id.progressBar);
//
//        if (fAuth.getCurrentUser() != null) {
//            startActivity(new Intent(getApplicationContext(), TenantDiscoverFragment.class));
//            finish();
//        }
//
//        mSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = mEmail.getText().toString().trim();
//                String password = mPassword.getText().toString().trim();
//
//                if(TextUtils.isEmpty(email)) {
//                    mEmail.setError("Email is required!");
//                    return;
//                }
//                if(TextUtils.isEmpty(password)) {
//                    mPassword.setError("Password is required!");
//                    return;
//                }
//                if (password.length() < 6 ) {
//                    mPassword.setError("Password must be >= 6 characters!");
//                    return;
//                }
//
//                progressBar.setVisibility(View.VISIBLE);
//
//                //register user in firebase
//
//                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                       if (task.isSuccessful()) {
//                           Toast.makeText(landlord_form_activity.this, "User created!", Toast.LENGTH_SHORT).show();
//                           startActivity(new Intent(getApplicationContext(), TenantDiscoverFragment.class));
//                       } else {
//                           Toast.makeText(landlord_form_activity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                       }
//                    }
//                });
//
//
//            }
//        });
//
//
//
//    }

