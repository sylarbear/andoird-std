package com.example.e_commerce_app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageScreenActivity extends AppCompatActivity {
    public static final String SCREEN_GET_STARTED = "get_started";
    public static final String SCREEN_HOME = "home";
    public static final String SCREEN_TRENDING = "trending";
    public static final String SCREEN_SHOP = "shop";
    public static final String SCREEN_PROFILE = "profile";
    public static final String SCREEN_CHECKOUT = "checkout";
    public static final String SCREEN_PLACE_ORDER = "place_order";
    public static final String SCREEN_SHIPPING = "shipping";
    public static final String SCREEN_SUCCESSFULLY = "successfully";

    private static final String EXTRA_SCREEN = "screen";
    private String screen;

    public static Intent createIntent(Context context, String screen) {
        Intent intent = new Intent(context, ImageScreenActivity.class);
        intent.putExtra(EXTRA_SCREEN, screen);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyFullscreenBars();
        setContentView(R.layout.activity_image_screen);

        screen = getIntent().getStringExtra(EXTRA_SCREEN);
        if (screen == null) {
            screen = SCREEN_GET_STARTED;
        }

        renderScreen();
        bindNavigation();
    }

    private void renderScreen() {
        ImageView imageFullScreen = findViewById(R.id.imageFullScreen);
        ScrollView scrollScreen = findViewById(R.id.scrollScreen);
        ImageView imageScrollableScreen = findViewById(R.id.imageScrollableScreen);

        int drawable = drawableForScreen(screen);
        if (isScrollable(screen)) {
            imageFullScreen.setVisibility(View.GONE);
            scrollScreen.setVisibility(View.VISIBLE);
            imageScrollableScreen.setImageResource(drawable);
        } else {
            scrollScreen.setVisibility(View.GONE);
            imageFullScreen.setVisibility(View.VISIBLE);
            imageFullScreen.setImageResource(drawable);
        }

        findViewById(R.id.hotspotBottomNav).setVisibility(showBottomNavHotspots(screen) ? View.VISIBLE : View.GONE);
    }

    private void bindNavigation() {
        findViewById(R.id.hotspotTopLeft).setOnClickListener(v -> finish());
        findViewById(R.id.hotspotTopRight).setOnClickListener(v -> open(SCREEN_PLACE_ORDER));
        findViewById(R.id.hotspotPrimary).setOnClickListener(v -> open(nextScreen(screen)));

        findViewById(R.id.navHome).setOnClickListener(v -> open(SCREEN_HOME));
        findViewById(R.id.navWishlist).setOnClickListener(v -> open(SCREEN_TRENDING));
        findViewById(R.id.navCart).setOnClickListener(v -> open(SCREEN_PLACE_ORDER));
        findViewById(R.id.navSearch).setOnClickListener(v -> open(SCREEN_TRENDING));
        findViewById(R.id.navProfile).setOnClickListener(v -> open(SCREEN_PROFILE));
    }

    private void open(String next) {
        startActivity(createIntent(this, next));
    }

    private String nextScreen(String current) {
        switch (current) {
            case SCREEN_GET_STARTED:
                return SCREEN_HOME;
            case SCREEN_HOME:
                return SCREEN_TRENDING;
            case SCREEN_TRENDING:
                return SCREEN_SHOP;
            case SCREEN_SHOP:
                return SCREEN_CHECKOUT;
            case SCREEN_PROFILE:
                return SCREEN_CHECKOUT;
            case SCREEN_CHECKOUT:
                return SCREEN_PLACE_ORDER;
            case SCREEN_PLACE_ORDER:
                return SCREEN_SHIPPING;
            case SCREEN_SHIPPING:
                return SCREEN_SUCCESSFULLY;
            case SCREEN_SUCCESSFULLY:
            default:
                return SCREEN_HOME;
        }
    }

    private int drawableForScreen(String current) {
        switch (current) {
            case SCREEN_HOME:
                return R.drawable.screen_home_page;
            case SCREEN_TRENDING:
                return R.drawable.screen_trending_products;
            case SCREEN_SHOP:
                return R.drawable.screen_shop_page;
            case SCREEN_PROFILE:
                return R.drawable.screen_profile;
            case SCREEN_CHECKOUT:
                return R.drawable.screen_checkout;
            case SCREEN_PLACE_ORDER:
                return R.drawable.screen_place_order;
            case SCREEN_SHIPPING:
                return R.drawable.screen_shipping;
            case SCREEN_SUCCESSFULLY:
                return R.drawable.screen_successfully;
            case SCREEN_GET_STARTED:
            default:
                return R.drawable.screen_get_started;
        }
    }

    private boolean isScrollable(String current) {
        return SCREEN_HOME.equals(current)
                || SCREEN_TRENDING.equals(current)
                || SCREEN_SHOP.equals(current)
                || SCREEN_PROFILE.equals(current);
    }

    private boolean showBottomNavHotspots(String current) {
        return SCREEN_HOME.equals(current)
                || SCREEN_TRENDING.equals(current)
                || SCREEN_PLACE_ORDER.equals(current)
                || SCREEN_SHIPPING.equals(current)
                || SCREEN_SUCCESSFULLY.equals(current);
    }

    private void applyFullscreenBars() {
        Window window = getWindow();
        window.setStatusBarColor(Color.WHITE);
        window.setNavigationBarColor(Color.WHITE);
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }
}
