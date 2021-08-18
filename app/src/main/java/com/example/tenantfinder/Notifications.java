package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Notifications extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Notificat> notificatArrayList;
    myNotAdapter myNotAdapter;
    String[] notificatNote;
    int[] avatarId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.RecyclerViewNotification);
        LinearLayoutManager r = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(r);
        recyclerView.setHasFixedSize(true);

        notificatArrayList = new ArrayList<Notificat>();

         myNotAdapter = new myNotAdapter(this,notificatArrayList, this);
         recyclerView.setAdapter(myNotAdapter);

       //  DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(), r.getOrientation());
       //  recyclerView.addItemDecoration(decoration);
         notificatNote = new String[] {
                 "The user ---- has requested to book place -----.",
                 " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                 "Mauris sit amet massa vitae tortor condimentum lacinia quis.",
                 "orci porta non pulvinar neque laoreet suspendisse interdum",
                 "it amet nisl purus in mollis nunc. Eget est lorem ipsum d",
                 "it amet nisl purus in mollis nunc. Eget est lorem ipsum ipsum ips.",
                 "it amet nisl purus in mollis nunc. Eget est lorem ipsum d",
                 "it amet nisl purus in mollis nunc. Eget est lorem ipsum ipsum ips.",
         };
         
         getData();

    }

    private void getData() {

        for (int i=0; i < notificatNote.length; i++) {
            Notificat notificat = new Notificat(notificatNote[i]);
            notificatArrayList.add(notificat);
        }

        myNotAdapter.notifyDataSetChanged();
    }
}