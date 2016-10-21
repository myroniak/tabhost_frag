package com.letzgro.viewpager2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class TabHostFragment extends Fragment {

    private FragmentTabHost mTabHost;

    //Mandatory Constructor
    public TabHostFragment() {
    }

/*
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
*/

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab8_view, container, false);

        mTabHost = (FragmentTabHost) rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("loads").setIndicator(createTabIndicator(mTabHost, "by loads", 0)), TabLoadsFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("chronological").setIndicator(createTabIndicator(mTabHost, "chronological", 0)), TabChronogicalFragment.class, null);

        return rootView;
    }

    public View createTabIndicator(TabHost tabHost, String textResource, int iconResource) {
        View tabIndicator = LayoutInflater.from(getActivity()).inflate(R.layout.tab_indicator, tabHost.getTabWidget(), false);
        ((TextView) tabIndicator.findViewById(android.R.id.title)).setText(textResource);
        ((ImageView) tabIndicator.findViewById(android.R.id.icon)).setImageResource(iconResource);
        return tabIndicator;
    }
}