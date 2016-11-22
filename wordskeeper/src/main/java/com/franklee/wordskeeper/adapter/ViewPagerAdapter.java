package com.franklee.wordskeeper.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/22.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position){
        return mFragmentList.get(position);
    }

    @Override
    public int getCount(){
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment){
        mFragmentList.add(fragment);
    }
}
