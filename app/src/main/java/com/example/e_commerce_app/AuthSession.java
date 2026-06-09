package com.example.e_commerce_app;

import android.content.Context;
import android.content.SharedPreferences;

public final class AuthSession {
    private static final String PREFS_NAME = "auth_session";
    private static final String KEY_LOGGED_IN = "is_logged_in";

    private AuthSession() {
    }

    public static boolean isLoggedIn(Context context) {
        return prefs(context).getBoolean(KEY_LOGGED_IN, false);
    }

    public static void setLoggedIn(Context context, boolean loggedIn) {
        prefs(context).edit().putBoolean(KEY_LOGGED_IN, loggedIn).apply();
    }

    private static SharedPreferences prefs(Context context) {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }
}
