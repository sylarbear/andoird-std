package com.example.e_commerce_app;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.e_commerce_app.fragments.CartFragment;
import com.example.e_commerce_app.fragments.ChatFragment;
import com.example.e_commerce_app.fragments.HomeFragment;
import com.example.e_commerce_app.fragments.OrdersFragment;
import com.example.e_commerce_app.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    private LinearLayout navHome;
    private LinearLayout navOrders;
    private LinearLayout navChat;
    private LinearLayout navCart;
    private LinearLayout navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applySystemBars();
        setContentView(R.layout.activity_main);

        navHome = findViewById(R.id.navHome);
        navOrders = findViewById(R.id.navOrders);
        navChat = findViewById(R.id.navChat);
        navCart = findViewById(R.id.navCart);
        navProfile = findViewById(R.id.navProfile);

        navHome.setOnClickListener(v -> showFragment(new HomeFragment(), navHome));
        navOrders.setOnClickListener(v -> showFragment(new OrdersFragment(), navOrders));
        navChat.setOnClickListener(v -> showFragment(new ChatFragment(), navChat));
        navCart.setOnClickListener(v -> showFragment(new CartFragment(), navCart));
        navProfile.setOnClickListener(v -> showFragment(new ProfileFragment(), navProfile));

        if (savedInstanceState == null) {
            showFragment(new HomeFragment(), navHome);
        }
    }

    private void showFragment(Fragment fragment, LinearLayout selectedNav) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
        updateSelectedNav(selectedNav);
    }

    private void updateSelectedNav(LinearLayout selectedNav) {
        navHome.setAlpha(navHome == selectedNav ? 1f : 0.68f);
        navOrders.setAlpha(navOrders == selectedNav ? 1f : 0.68f);
        navChat.setAlpha(navChat == selectedNav ? 1f : 0.68f);
        navCart.setAlpha(navCart == selectedNav ? 1f : 0.68f);
        navProfile.setAlpha(navProfile == selectedNav ? 1f : 0.68f);
    }

    private void applySystemBars() {
        Window window = getWindow();
        window.setStatusBarColor(Color.WHITE);
        window.setNavigationBarColor(Color.WHITE);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
}
