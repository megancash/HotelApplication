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

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

//Dinner Reservation Screen
public class ExploreActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    private FloatingActionButton floatingActionButton;
    private DrawerLayout drawerLayout;

    //ListView
    ListView places;
    String placesInKildare[] = {" ", "                    Top Sights in Kildare:              ", " ", "• Punchestown Racecourse: 8 minutes",
            "• Mondello Park: 16 minutes", "• Curragh Racecourse: 19 minutes", "• White Water Shopping centre: 19 minutes",
            "• Arthur Guinness viewPoint: 20 minutes ", "• Kildare Village: 21 minutes", "• Irish National Stud: 22 minutes"
            , "   ", " ", "              Popular Restaurants in Naas:              ", " ", "• Rustic Italian", "• Lock 13", "• The Monread Lodge", "• Lemongrass Fusion", "• 33 South Main Bar & Grill"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        //NAVIGATION LAYOUT
        //To get the actionBar to not display on the Home screen
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        drawerLayout = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView = findViewById(R.id.navigation_view2);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_draw_open, R.string.navigation_draw_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.home);
        }

        //EXPLORE KILDARE
        //To display list of places to visit and to dine in
        places = findViewById(R.id.list);
        ArrayAdapter<String> arr;
        arr = new ArrayAdapter<String>(this, R.layout.list_items, placesInKildare);
        places.setAdapter(arr);

        //GoogleMaps will be launched when Floating Action Button is pressed.
        floatingActionButton = findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ExploreActivity.this, GoogleMapsActivity.class);
                startActivity(i);
            }

        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
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
                Toast.makeText(ExploreActivity.this, "You have successfully logged out!", Toast.LENGTH_SHORT).show();
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
            case R.id.weather: //To bring user to Weather page when the weather menu item is selected.
                Intent intent8 = new Intent(this, WeatherActivity.class);
                startActivity(intent8);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}