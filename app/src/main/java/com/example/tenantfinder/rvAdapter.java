package com.example.tenantfinder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rvAdapter extends RecyclerView.Adapter <rvAdapter.MyViewHolder> {
        Context rvctx;
        ArrayList<ReviewTnt> reviewTntArrayList;
        Activity activity;

    public rvAdapter(Context rvctx, ArrayList<ReviewTnt> reviewTntArrayList, Activity activity) {
        this.rvctx = rvctx;
        this.reviewTntArrayList = reviewTntArrayList;
        this.activity = activity;
    }


    @NonNull
    @Override
    public rvAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(rvctx).inflate(R.layout.review_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rvAdapter.MyViewHolder holder, int position) {

        ReviewTnt reviewTnt = reviewTntArrayList.get(position);
        holder.username.setText(reviewTnt.name);
        holder.number.setText(reviewTnt.numbertnt);

    }

    @Override
    public int getItemCount() {
        return reviewTntArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView username, number;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.usernameId);
            number = itemView.findViewById(R.id.numberTnt);
            //deleteBtn = deleteBtn;
        }
    }
}

