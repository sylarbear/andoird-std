package com.example.e_commerce_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.e_commerce_app.fragments.CartFragment;
import com.example.e_commerce_app.fragments.ChatFragment;
import com.example.e_commerce_app.fragments.HomeFragment;
import com.example.e_commerce_app.fragments.OrdersFragment;
import com.example.e_commerce_app.fragments.ProfileFragment;

public class TabAdapter extends FragmentStateAdapter {
    public TabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new OrdersFragment();
            case 2:
                return new ChatFragment();
            case 3:
                return new CartFragment();
            case 4:
                return new ProfileFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
