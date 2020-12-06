package com.example.loginfunc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdpater extends FragmentPagerAdapter {
    private GuideActivity activity;

    public ViewPagerAdpater(@NonNull FragmentManager fm, GuideActivity activity) {
        super(fm);

        this.activity = activity;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragMonday.newInstance(activity);
            case 1:
                return FragTuesday.newInstance(activity);
            case 2:
                return FragWednesday.newInstance(activity);
            case 3:
                return FragThursday.newInstance(activity);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    //상단 탭 레이아웃 인디케이터 선언
}
