package com.example.foodhub.fragment.FragmentAdapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.foodhub.fragment.CartFragment;
import com.example.foodhub.fragment.FavoritesFragment;
import com.example.foodhub.fragment.HomeFragment;
import com.example.foodhub.fragment.MapsFragment;


public class FragmentAdapter extends FragmentPagerAdapter {
    private Context myContext;
    private int totalTabs;

    public FragmentAdapter(Context context, FragmentManager fragmentManager, int totalTabs) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.myContext = context;
        this.totalTabs = totalTabs;

    }


    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new MapsFragment();
            case 2:
                return new CartFragment();
            case 3:
                return new FavoritesFragment();
            default:
                return new FavoritesFragment();
        }
    }


    @Override
    public int getCount() {
        return totalTabs;
    }


}
