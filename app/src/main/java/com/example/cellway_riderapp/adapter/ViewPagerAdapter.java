package com.example.cellway_riderapp.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cellway_riderapp.fragments.DayAfterTomorrowFragment;
import com.example.cellway_riderapp.fragments.TodayFragment;
import com.example.cellway_riderapp.fragments.TomorrowFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public ViewPagerAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TodayFragment todayFragment = new TodayFragment();
                return todayFragment;
            case 1:
                TomorrowFragment tomorrowFragment = new TomorrowFragment();
                return tomorrowFragment;
            case 2:
                DayAfterTomorrowFragment dayTomorrow = new DayAfterTomorrowFragment();
                return dayTomorrow;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
