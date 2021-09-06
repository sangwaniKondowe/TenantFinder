package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class View_Remove extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ReviewTnt> reviewTntArrayList;
    rvAdapter rvAdapter;
    String[] userName;
    String[] numBer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_remove);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.RecyclerViewPurgeView);
        LinearLayoutManager r = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(r);
        recyclerView.setHasFixedSize(true);

        reviewTntArrayList = new ArrayList<ReviewTnt>();
        rvAdapter = new rvAdapter(this, reviewTntArrayList, this);
        recyclerView.setAdapter(rvAdapter);

//        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(), r.getOrientation());
//        recyclerView.addItemDecoration(decoration);

        userName = new String[] {
                "Lorem",
                "Sed",
                "Mauris",
                "Orci",
                "Peter",
                "Jim",
                "Kerry",
                "Gwen",
        };

        numBer = new String[] {
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
        };

        getData();

    }

    private void getData() {

        for (int i=0; i < userName.length; i++) {
            ReviewTnt reviewTnt = new ReviewTnt(userName[i], numBer[i] );
            reviewTntArrayList.add(reviewTnt);
        }

        rvAdapter.notifyDataSetChanged();
    }

    }
