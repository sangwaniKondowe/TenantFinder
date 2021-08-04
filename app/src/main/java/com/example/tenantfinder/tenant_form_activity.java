package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tenant_form_activity extends AppCompatActivity {

    EditText username, email, password, reenterPassword;
    Button signUp;
    String tUserName, tEmail, tPassword, tConfPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_form);

        username = findViewById(R.id.tntname);
        email = findViewById(R.id.tntEmail);
        password = findViewById(R.id.tntPassword);
        reenterPassword = findViewById(R.id.tnt_confirmPassword);
        signUp = findViewById(R.id.btn_signup_send_request_tnt);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkDataEntered()){
                    Toast.makeText(tenant_form_activity.this, "Success!", Toast.LENGTH_SHORT).show();
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
            tUserName = null;
        }else {
            tUserName = username.getText().toString().trim();
        }
        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
            tEmail = null;
        } else {
            tEmail = email.getText().toString().trim();
        }
        if(password.getText().toString().length() == 0){
            password.setError("Password not entered");
            tPassword = null;
        } else if(password.getText().toString().length() < 8) {
            password.setError("Password should be at least of 8 characters");
        } else {
            tPassword = password.getText().toString().trim();
        }
        if(reenterPassword.getText().toString().length() == 0){
            reenterPassword.setError("Please confirm password!");
            tConfPassword = null;
        } else if (!password.getText().toString().equals(reenterPassword.getText().toString())){
            reenterPassword.setError("Password Not matched!");
            return password == reenterPassword;
        }else {
            tConfPassword = reenterPassword.getText().toString().trim();
        }

        return tUserName != null && tEmail != null && tPassword != null && reenterPassword != null;


    }
}