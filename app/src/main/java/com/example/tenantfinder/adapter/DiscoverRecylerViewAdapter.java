package com.example.tenantfinder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tenantfinder.R;
import com.example.tenantfinder.model.DiscoverModel;

import java.util.ArrayList;
import java.util.List;

public class DiscoverRecylerViewAdapter  extends RecyclerView.Adapter<DiscoverRecylerViewAdapter.MyViewHolder> {

    List<DiscoverModel> discoverModelList = new ArrayList<>();
    Context ctx;

    TextView tvTitle, tvPrice;
    Button btnBook;
    ImageView ivAvatar;

    public DiscoverRecylerViewAdapter(List<DiscoverModel> discoverModelList, Context ctx) {
        this.discoverModelList = discoverModelList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.discover_item_view, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public int getItemCount() {
        return discoverModelList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        tvTitle.setText(discoverModelList.get(position).getTitle());
        tvPrice.setText(discoverModelList.get(position).getPrice());

    }

    public  class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_discover_title);
            tvPrice = itemView.findViewById(R.id.tv_discover_price);
            btnBook = itemView.findViewById(R.id.btn_discover_book);
            ivAvatar = itemView.findViewById(R.id.iv_discover_avatar);
        }
    }


}
