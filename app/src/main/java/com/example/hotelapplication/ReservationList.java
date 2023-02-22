package com.example.hotelapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ReservationList extends AppCompatActivity {

    //FOR DINNER RESERVATIONS
    RecyclerView recyclerView1;
    ArrayList<Reservation> list3;
    DatabaseReference reservations;
    MyAdapter3 adapter3;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ReservationList.this, ReservationActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_list);

        getSupportActionBar().setTitle("Dinner Reservations");

        recyclerView1 = findViewById(R.id.recyclerView1);
        reservations = FirebaseDatabase.getInstance().getReference("Dinner Reservations");
        list3 = new ArrayList<>();
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        adapter3 = new MyAdapter3(this, list3);
        recyclerView1.setAdapter(adapter3);

        reservations.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot3) {
                for (DataSnapshot dataSnapshot3 : snapshot3.getChildren()) {
                    Reservation reservation = dataSnapshot3.getValue(Reservation.class);
                    list3.add(reservation);
                }
                adapter3.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}