package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn = (Button) findViewById(R.id.button);

        btn3.setOnClickListener(v -> {
            Intent intent3 = new Intent(MainActivity.this, landlord_form_activity.class);
            startActivity(intent3);
        });
        btn2.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity.this, Login.class);
            startActivity(intent2);
        });
        btn.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity.this, Login.class);
            startActivity(intent2);
        });
    }
}


//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button3:
//                Intent intent3 = new Intent(MainActivity.this, SignUp.class);
//                startActivity(intent3);
//                break;
//            case R.id.button2:
//            case R.id.button:
//                Intent intent2 = new Intent(MainActivity.this, Login.class);
//                startActivity(intent2);
//                break;
//        }
//        if(v.getId() == R.id.button3) {
//            Intent intent3 = new Intent(MainActivity.this, SignUp.class);
//            startActivity(intent3);
//        }
//        else {
//            Intent intent2 = new Intent(MainActivity.this, Login.class);
//            startActivity(intent2);
//    }

