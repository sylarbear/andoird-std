package com.example.e_commerce_app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyWhiteSystemBars();
        setContentView(R.layout.activity_sign_in);

        EditText usernameInput = findViewById(R.id.inputUsername);
        EditText passwordInput = findViewById(R.id.inputPassword);

        findViewById(R.id.buttonLogin).setOnClickListener(v -> {
            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString().trim();

            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Login database is not implemented yet", Toast.LENGTH_SHORT).show();
        });
        findViewById(R.id.textForgotPassword).setOnClickListener(v ->
                startActivity(new Intent(this, ForgotPasswordActivity.class)));
        findViewById(R.id.textSignUp).setOnClickListener(v ->
                startActivity(new Intent(this, SignUpActivity.class)));
        findViewById(R.id.rootSignIn).setOnTouchListener((view, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP && isSignUpArea(event, view)) {
                startActivity(new Intent(this, SignUpActivity.class));
                return true;
            }
            return false;
        });
    }

    private boolean isSignUpArea(MotionEvent event, View root) {
        float xRatio = event.getX() / root.getWidth();
        float yRatio = event.getY() / root.getHeight();
        return xRatio >= 0.2f && yRatio >= 0.68f && yRatio <= 0.9f;
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
