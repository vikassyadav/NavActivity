package com.example.navactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigatioView);
        toolbar = findViewById(R.id.toolbar);


        //step 1 first setup toolbar
        setSupportActionBar(toolbar);

        //this constructor takes five paremeter( activity  ,drawer ,toolbar "refernce ,2 flags close open takes integer )
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        loadFragement(new AFragment());//to open some default fragement

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.feat1) {             //switch case can be used here

                } else if (id == R.id.feat2) {
                    Toast.makeText(MainActivity.this, "calllogs", Toast.LENGTH_SHORT).show();
                    loadFragement(new AFragment());

                } else if (id == R.id.feat3) {
                    Toast.makeText(MainActivity.this, "f2", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.feat4) {
                    Toast.makeText(MainActivity.this, "f3", Toast.LENGTH_SHORT).show();

                } else if (id == R.id.feat5) {
                    Toast.makeText(MainActivity.this, "f4", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "f5", Toast.LENGTH_SHORT).show();

                }

                drawerLayout.closeDrawer(GravityCompat.START); //when any feature is open drawer will get close

                return true;
            }
        });
    }

    @Override
    //check if drawer is open then when backpressed first drawer will get backed
    public void onBackPressed() {
//        super.onBackPressed();
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed(); //if there is nothing(stack) to get back then home screen apper app is closed
        }
    }

    private  void loadFragement(Fragment fragment) {
            FragmentManager fm =getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.container ,  fragment);
            ft.commit();
        }

    }
