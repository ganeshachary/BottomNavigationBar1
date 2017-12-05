package com.comforttechno.bottomnavigationbar1.Helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.comforttechno.bottomnavigationbar1.Tab1;
import com.comforttechno.bottomnavigationbar1.Tab2;
import com.comforttechno.bottomnavigationbar1.Tab3;

/**
 * Created by ALex on 11/22/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm , int NumofTabs) {
        super(fm);
        this.mNumOfTabs = NumofTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();
                return tab2;
            case 2:
                Tab3 tab3 = new Tab3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
