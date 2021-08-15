package com.example.tenantfinder;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class myNotAdapter extends RecyclerView.Adapter <myNotAdapter.MyViewHolder> {

    Context context;
    ArrayList<Notificat> notificatArrayList;
    Activity activity;

    public myNotAdapter(Context context, ArrayList<Notificat> notificatArrayList, Activity activity) {
        this.context = context;
        this.notificatArrayList = notificatArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public myNotAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.notifications_layout, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Notificat notificat = notificatArrayList.get(position);
        holder.text.setText(notificat.note);
       // holder.notificationOption.setImageResource(notificat.vertAvatar);

        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.notf, null);

        alert.setView(view);
        AlertDialog r = alert.create();

        Window dlg = r.getWindow();
        WindowManager.LayoutParams wlp = dlg.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        //wlp.flags &=
        dlg.setAttributes(wlp);
        holder.notificationOption.setOnClickListener(v->{
            r.show();
        });


    }

    @Override
    public int getItemCount() {
        return notificatArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView notificationOption;
        LinearLayout ll;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tv_notification_holder);
            notificationOption = itemView.findViewById(R.id.notification_option);
        }
    }
}
