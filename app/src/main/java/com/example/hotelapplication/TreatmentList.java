//Student Name: Megan Cash
//Student Number: C19317723
//Assignment 3 - Hotel Application
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

//FOR SPA TREATMENTS BOOKED
public class TreatmentList extends AppCompatActivity {

    //Variables
    RecyclerView recyclerView2;
    ArrayList<SpaTreatment> list2;
    DatabaseReference treatments;
    MyAdapter2 adapter2;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(TreatmentList.this, SpaActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_list);

        getSupportActionBar().setTitle("Spa Treatment Bookings:");

        recyclerView2 = findViewById(R.id.recyclerView2);
        treatments = FirebaseDatabase.getInstance().getReference("Spa Treatments");
        list2 = new ArrayList<>();
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        adapter2 = new MyAdapter2(this, list2);
        recyclerView2.setAdapter(adapter2);

        treatments.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot2) {
                for (DataSnapshot dataSnapshot2 : snapshot2.getChildren()) {
                    SpaTreatment spaTreatment = dataSnapshot2.getValue(SpaTreatment.class);
                    list2.add(spaTreatment);
                }
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}