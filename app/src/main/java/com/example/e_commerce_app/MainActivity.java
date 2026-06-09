package com.example.e_commerce_app;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
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

        viewPager = findViewById(R.id.viewPager);
        navHome = findViewById(R.id.navHome);
        navOrders = findViewById(R.id.navOrders);
        navChat = findViewById(R.id.navChat);
        navCart = findViewById(R.id.navCart);
        navProfile = findViewById(R.id.navProfile);

        viewPager.setAdapter(new TabAdapter(this));
        viewPager.setUserInputEnabled(false);

        navHome.setOnClickListener(v -> selectTab(0));
        navOrders.setOnClickListener(v -> selectTab(1));
        navChat.setOnClickListener(v -> selectTab(2));
        navCart.setOnClickListener(v -> selectTab(3));
        navProfile.setOnClickListener(v -> selectTab(4));

        selectTab(0);
    }

    private void selectTab(int position) {
        viewPager.setCurrentItem(position, false);
        switch (position) {
            case 0:
                updateSelectedNav(navHome);
                break;
            case 1:
                updateSelectedNav(navOrders);
                break;
            case 2:
                updateSelectedNav(navChat);
                break;
            case 3:
                updateSelectedNav(navCart);
                break;
            case 4:
                updateSelectedNav(navProfile);
                break;
            default:
                updateSelectedNav(navHome);
                break;
        }
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
