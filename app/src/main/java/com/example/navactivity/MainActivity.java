package com.example.navactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

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


        //steo 1 first setup toolbar
        setSupportActionBar(toolbar);

                                            //this constructor takes five paremeter( activity  ,drawer ,toolbar "refernce ,2 flags close open takes integer )
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar ,R.string.OpenDrawer,R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

//                int id=item.getItemId();
//                if(id==R.id.optfeat1){
//
//                } else if (id==R.id.optfeat2) {
//
//                } else if (id==R.id.optfeat3) {
//
//                }


                return true;
            }
        });

    }
}