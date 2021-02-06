package com.example.dms;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dms.ui.ChangePasswordFragment;
import com.example.dms.ui.DashboardFragment;
import com.example.dms.ui.NewcustomerFragment;
import com.example.dms.ui.NeworderFragment;
import com.example.dms.ui.ProductsFragment;
import com.example.dms.ui.PromotionFragment;
import com.example.dms.ui.VisitCustomerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private TextView txtviewname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        /// set tên cho header view
        View headerView = navigationView.getHeaderView(0);
        txtviewname = (TextView) headerView.findViewById(R.id.textViewname);
        Intent intent = getIntent();
        String sessionname = intent.getStringExtra("sessionname");
        txtviewname.setText(sessionname);

        ///
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DashboardFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_dashboard);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DashboardFragment()).commit();
                break;
            case R.id.nav_visit_customer:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new VisitCustomerFragment()).commit();
                break;
            case R.id.nav_makeneworder:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NeworderFragment()).commit();
                break;
            case R.id.nav_promotions:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PromotionFragment()).commit();
                break;
            case R.id.nav_products:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProductsFragment()).commit();
                break;
            case R.id.nav_newcustomer:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NewcustomerFragment()).commit();
                break;
            case R.id.nav_changepassword:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ChangePasswordFragment()).commit();
                break;
            case R.id.nav_logout:
                Toast.makeText(Main2Activity.this, "Log Out!",
                        Toast.LENGTH_LONG).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
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