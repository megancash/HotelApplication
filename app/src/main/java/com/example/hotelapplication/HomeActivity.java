//Student Name: Megan Cash
//Student Number: C19317723
//ASSIGNMENT 3
package com.example.hotelapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
                Toast.makeText(HomeActivity.this, "You have successfully logged out!", Toast.LENGTH_SHORT).show();
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

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}