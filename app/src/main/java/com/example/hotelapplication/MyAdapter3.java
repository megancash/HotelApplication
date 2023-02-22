package com.example.hotelapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//FOR RESERVATION ACTIVITY
public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {
    Context context3;
    ArrayList<Reservation> list3;

    public MyAdapter3(Context context3, ArrayList<Reservation> list3) {
        this.context3=context3;
        this.list3=list3;
    }
    @NonNull
    @Override
    public MyAdapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v3 = LayoutInflater.from(context3).inflate(R.layout.reservationentry,parent,false);
        return new MyAdapter3.MyViewHolder(v3);
    }
    @Override
    public void onBindViewHolder(@NonNull MyAdapter3.MyViewHolder holder, int position) {
        Reservation reservation=list3.get(position);
        holder.fullName1.setText(reservation.getFullName1());
        holder.roomNumber1.setText(reservation.getRoomNumber1());
        holder.phoneNumber1.setText(reservation.getPhoneNumber1());
        holder.numberOfGuests1.setText(reservation.getNumberOfGuests1());
        holder.date1.setText(reservation.getDate1());
        holder.time1.setText(reservation.getTime1());
    }

    @Override
    public int getItemCount() {
        return list3.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fullName1, roomNumber1, phoneNumber1, numberOfGuests1, date1, time1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName1= itemView.findViewById(R.id.textname1);
            roomNumber1= itemView.findViewById(R.id.textroomNumber1);
            phoneNumber1= itemView.findViewById(R.id.textphoneNumber1);
            numberOfGuests1= itemView.findViewById(R.id.textnumberofguests1);
            date1= itemView.findViewById(R.id.textdate1);
            time1= itemView.findViewById(R.id.texttime1);

        }
    }
}
