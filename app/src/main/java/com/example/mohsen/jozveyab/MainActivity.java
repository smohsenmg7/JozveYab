package com.example.mohsen.jozveyab;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        drawer = findViewById(R.id.drawer_layout);
//        باز و بسته شدن منو و آیکون همبرگر
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navication_drawer_open, R.string.navication_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_user_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                                , new UserProfileFragment()).commit();
                    case R.id.nav_category:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                                , new CategoryFragment()).commit();
                    case R.id.nav_buy:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                                , new BoughtFragment()).commit();
                    case R.id.nav_download:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                                , new DownloadFragment()).commit();
                    case R.id.nav_favorite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                                , new FavoriteFragment()).commit();
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new CategoryFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_category);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }
}
