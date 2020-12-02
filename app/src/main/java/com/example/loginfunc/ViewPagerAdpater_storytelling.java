package com.example.loginfunc;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdpater_storytelling extends FragmentPagerAdapter {
    private StorytellingActivity activity;
    public ViewPagerAdpater_storytelling(@NonNull FragmentManager fm, StorytellingActivity activity) {
        super(fm);

        this.activity = activity;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragStory1.newInstance();
            case 1:
                return FragStory2.newInstance();
            case 2:
                return FragStory3.newInstance(activity);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
