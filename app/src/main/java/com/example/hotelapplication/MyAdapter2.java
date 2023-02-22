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

//FOR SPA TREATMENT ACTIVITY
public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    Context context2;
    ArrayList<SpaTreatment> list2;

    public MyAdapter2(Context context2, ArrayList<SpaTreatment> list2) {
        this.context2 = context2;
        this.list2 = list2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context2).inflate(R.layout.treatmententry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder2, int position) {
        SpaTreatment spaTreatment = list2.get(position);
        holder2.name.setText(spaTreatment.getName());
        holder2.roomNumber.setText(spaTreatment.getRoomNumber());
        holder2.number.setText(spaTreatment.getNumber());
        holder2.treatment.setText(spaTreatment.getTreatment());
        holder2.paymentType.setText(spaTreatment.getPaymentType());
        holder2.date.setText(spaTreatment.getDate());
        holder2.time.setText(spaTreatment.getTime());
    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, roomNumber, number, treatment, paymentType, date, time;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textname);
            roomNumber = itemView.findViewById(R.id.textroomNumber);
            number = itemView.findViewById(R.id.textphoneNumber);
            treatment = itemView.findViewById(R.id.textorder);
            date = itemView.findViewById(R.id.textdate);
            time = itemView.findViewById(R.id.texttime);
            paymentType = itemView.findViewById(R.id.textpaymenttype);

        }
    }
}