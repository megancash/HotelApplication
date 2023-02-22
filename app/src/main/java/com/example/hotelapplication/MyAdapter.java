//Student Name: Megan Cash
//Student Number: C19317723
//Assignment 3 - Hotel Application
package com.example.hotelapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//FOR ROOM SERVICE ACTIVITY
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<RoomServiceOrder> list;

    public MyAdapter(Context context, ArrayList<RoomServiceOrder> list) {
        this.context=context;
        this.list=list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v2 = LayoutInflater.from(context).inflate(R.layout.orderentry,parent,false);
        return new MyViewHolder(v2);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         RoomServiceOrder roomServiceOrder=list.get(position);
         holder.name.setText(roomServiceOrder.getName());
         holder.roomNumber.setText(roomServiceOrder.getRoomNumber());
         holder.phoneNumber.setText(roomServiceOrder.getPhoneNumber());
         holder.order.setText(roomServiceOrder.getOrder());
         holder.paymentType.setText(roomServiceOrder.getPaymentType());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, roomNumber, phoneNumber, order, paymentType;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.textname);
            roomNumber= itemView.findViewById(R.id.textroomNumber);
            phoneNumber= itemView.findViewById(R.id.textphoneNumber);
            order= itemView.findViewById(R.id.textorder);
            paymentType= itemView.findViewById(R.id.textpaymenttype);

        }
    }
}
