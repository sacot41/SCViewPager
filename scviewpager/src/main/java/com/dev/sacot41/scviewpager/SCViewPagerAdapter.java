package com.dev.sacot41.scviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Samuel on 2015-07-06.
 */

public class SCViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<SCViewPagerFragment> mFragmentList;

    private int mNumberOfPage = 0;
    private int mBackgroundColor;

    public SCViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
    }

    public void setNumberOfPage(int numberOfPage) {
        mNumberOfPage = numberOfPage;
    }

    public void setFragmentBackgroundColor(int colorResource) {
        mBackgroundColor = colorResource;
    }

    @Override
    public Fragment getItem(int position) {

        SCViewPagerFragment fragment = null;

        if (mFragmentList.size()-1 >= position) fragment = mFragmentList.get(position);

        if (fragment == null) {
            fragment = new SCViewPagerFragment();
            fragment.setBackground(mBackgroundColor);
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return mNumberOfPage;
    }

    public static class SCViewPagerFragment extends Fragment {

        private int color;

        public SCViewPagerFragment() {
            this.color = R.color.white;
        }

        public void setBackground(int inColor) {
            this.color = inColor;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            LinearLayout view = new LinearLayout(getActivity());
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            view.setOrientation(LinearLayout.VERTICAL);
            view.setBackgroundColor(getResources().getColor(this.color));
            return view;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }
    }

}
