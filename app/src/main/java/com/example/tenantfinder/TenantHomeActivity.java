package com.example.tenantfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TenantHomeActivity extends AppCompatActivity {

    BottomNavigationView tenantBottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_home);

        tenantBottomNav = findViewById(R.id.tenant_bottom_navigation_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.fragment_tenant_discover, R.id.fragment_tenant_me, R.id.fragment_tenant_my_room)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.tenant_nav_fragment_host);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(tenantBottomNav, navController);
    }
}