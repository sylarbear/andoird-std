package com.example.e_commerce_app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class OnboardingActivity extends AppCompatActivity {
    private final int[] screens = {
            R.drawable.screen_onboarding_1,
            R.drawable.screen_onboarding_2,
            R.drawable.screen_onboarding_3
    };

    private int currentPage = 0;
    private ImageView screenImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyWhiteSystemBars();
        setContentView(R.layout.activity_onboarding);

        screenImage = findViewById(R.id.imageScreen);

        findViewById(R.id.rootOnboarding).setOnClickListener(v -> goNext());
        findViewById(R.id.hotspotSkip).setOnClickListener(v -> openSignIn());
        findViewById(R.id.hotspotPrev).setOnClickListener(v -> {
            if (currentPage > 0) {
                currentPage--;
                renderPage();
            }
        });
        findViewById(R.id.hotspotNext).setOnClickListener(v -> goNext());

        renderPage();
    }

    private void renderPage() {
        screenImage.setImageResource(screens[currentPage]);
    }

    private void openSignIn() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }

    private void goNext() {
        if (currentPage == screens.length - 1) {
            openSignIn();
        } else {
            currentPage++;
            renderPage();
        }
    }

    private void applyWhiteSystemBars() {
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
