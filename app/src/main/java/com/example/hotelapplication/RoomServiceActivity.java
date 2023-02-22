//Student Name: Megan Cash
//Student Number: C19317723
//ASSIGNMENT 3
package com.example.hotelapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//Room Service Screen
public class RoomServiceActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    Button orderButton, orderView;
    EditText inputGuestName,  inputRoomNumber, inputNumber, inputOrder, inputPaymentType;

    DatabaseReference orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_service);

        //NAVIGATION LAYOUT
        //To get the actionBar to not display on the Home screen
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawerLayout = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView=findViewById(R.id.navigation_view2);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_draw_open,R.string.navigation_draw_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState==null)
        {
            navigationView.setCheckedItem(R.id.home);
        }

        //ROOM SERVICE
        orderView = findViewById(R.id.orderView);
        orderButton = findViewById(R.id.orderButton);
        inputPaymentType= findViewById(R.id.inputPaymentType);
        inputOrder= findViewById(R.id.inputOrder);
        inputNumber= findViewById(R.id.inputNumber);
        inputRoomNumber= findViewById(R.id.inputRoomNumber);
        inputGuestName= findViewById(R.id.inputGuestName);
        orders= FirebaseDatabase.getInstance().getReference();

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertData();
            }

        });

        orderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RoomServiceActivity.this, OrderList.class));
                finish();
            }
        });

    }

    private void InsertData() {
        String name = inputGuestName.getText().toString();
        String roomNumber = inputRoomNumber.getText().toString();
        String phoneNumber = inputNumber.getText().toString();
        String order = inputOrder.getText().toString();
        String paymentType = inputPaymentType.getText().toString();
        String id = orders.push().getKey();

        RoomServiceOrder roomServiceOrder = new RoomServiceOrder(name, roomNumber, phoneNumber, order, paymentType);
        orders.child("Room Service Orders").child(id).setValue(roomServiceOrder)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RoomServiceActivity.this, "Your room service has been ordered", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.home: //To bring user to Home page when home menu item is selected.
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.profile: //To bring user to Profile page when profile menu item is selected.
                Intent intent2 = new Intent(this, ProfileActivity.class);
                startActivity(intent2);
                break;
            case R.id.logout: //To bring user to Login page when profile menu item is selected.
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(RoomServiceActivity.this, "You have successfully logged out!", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.dinner_reservation: //To bring user to Dinner Reservation page when reservation menu item is selected.
                Intent intent4 = new Intent(this, ReservationActivity.class);
                startActivity(intent4);
                break;
            case R.id.room_service: //To bring user to Room Service page when room service menu item is selected.
                Intent intent5 = new Intent(this, RoomServiceActivity1.class);
                startActivity(intent5);
                break;
            case R.id.spa: //To bring user to Spa page when spa menu item is selected.
                Intent intent6 = new Intent(this, SpaActivity1.class);
                startActivity(intent6);
                break;
            case R.id.explore: //To bring user to Explore page when explore menu item is selected.
                Intent intent7 = new Intent(this, ExploreActivity.class);
                startActivity(intent7);
                break;
            case R.id.weather: //To bring user to weather page when weather menu item is selected.
                Intent intent8 = new Intent(this, WeatherActivity.class);
                startActivity(intent8);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}