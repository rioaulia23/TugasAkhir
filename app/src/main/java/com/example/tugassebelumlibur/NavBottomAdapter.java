package com.example.tugassebelumlibur;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.tugassebelumlibur.Allfragment.Kedua;
import com.example.tugassebelumlibur.Allfragment.Ketiga;
import com.example.tugassebelumlibur.Allfragment.Pertama;


public class NavBottomAdapter extends FragmentPagerAdapter {
    final int RG = 3;
    private Fragment currentFragment;

    public NavBottomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0: {
                currentFragment = Pertama.newInstance(0);
            }
            break;
            case 1: {
                currentFragment = Kedua.newInstance(1);
            }
            break;
            case 2: {
                currentFragment = Ketiga.newInstance(2);
            }
            break;

        }
        return currentFragment;
    }

    @Override
    public int getCount() {
        return RG;
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
    }

    public Fragment getCurrentFragment() {
        return currentFragment;
    }
}