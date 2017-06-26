package com.sumanastani.np.glirtproject.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2/1/2017.
 */
/*this adapter defines the fragemtn pager adapter*/
    /*adapter acts as a link be
tween data and activity here we use Fragement pager adapter to implement fragment
    * arraylist is used to store different fragments and fragment title
    * getitem returen posion of fragments
    * getcount dreturn size or no of fragment present
    * getpageTitle is ust to get the page tab title
    *
    *
    * here we define optional addFragment metthod wiht
    * @param fragment and string
    *this method is used in mainactiviyt to add in tagpager adapter.. we add fragment and title here*/

public class TabpagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    TabpagerAdapter mtabpagerAdapter;

    public TabpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mFragmentTitleList.get(position);
    }

    /*this is addFragment method is used in Mainactivity inside setupViewPagerAdapter*/
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
}
