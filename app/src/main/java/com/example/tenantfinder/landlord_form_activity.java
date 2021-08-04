package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class landlord_form_activity extends AppCompatActivity {

    EditText username, email, phoneNumber, password, reenterPassword;
    Button signUp;
    String mUserName, mEmail, mPhoneNumber, mPassword, mConfPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_form);

        username = findViewById(R.id.tntname);
        email = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.landlord_phone);
        password = findViewById(R.id.tntPassword);
        reenterPassword = findViewById(R.id.tnt_confirmPassword);
        signUp = findViewById(R.id.btn_signup_send_request);
        
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkDataEntered()){
                    Toast.makeText(landlord_form_activity.this, "Success!", Toast.LENGTH_SHORT).show();
                };
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean checkDataEntered() {
        if (isEmpty(username)) {
            username.setError("Username cannot be empty");
            mUserName = null;
        }else {
            mUserName = username.getText().toString().trim();
        }
        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
            mEmail = null;
        } else {
            mEmail = email.getText().toString().trim();
        }
        if (phoneNumber.getText().toString().length() == 0) {
            phoneNumber.setError("Enter a phone number!");
            mPhoneNumber = null;
        } else {
            mPhoneNumber = phoneNumber.getText().toString().trim();
        }
        if(password.getText().toString().length() == 0){
            password.setError("Password not entered");
            mPassword = null;
        } else if(password.getText().toString().length() < 8) {
            password.setError("Password should be at least of 8 characters");
        } else {
            mPassword = password.getText().toString().trim();
        }
        if(reenterPassword.getText().toString().length() == 0){
            reenterPassword.setError("Please confirm password!");
            mConfPassword = null;
        } else if (!password.getText().toString().equals(reenterPassword.getText().toString())){
            reenterPassword.setError("Password Not matched!");
            return password == reenterPassword;
        }else {
            mConfPassword = reenterPassword.getText().toString().trim();
        }

        return mUserName != null && mEmail != null && mPhoneNumber != null && mPassword != null && reenterPassword != null;

}





    public void onClickSignUp(View view) {
        Intent intent = new Intent(this, tenant_form_activity.class);
        startActivity(intent);
    }
}