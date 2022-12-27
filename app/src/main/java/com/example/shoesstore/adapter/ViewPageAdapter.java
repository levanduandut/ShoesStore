package com.example.shoesstore.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.shoesstore.activity.OnBroardingFragment;
import com.example.shoesstore.activity.OnBroardingFragment1;
import com.example.shoesstore.activity.OnBroardingFragment2;

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OnBroardingFragment();
            case 1:
                return new OnBroardingFragment1();
            case 2:
                return new OnBroardingFragment2();
            default:
                return new OnBroardingFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
