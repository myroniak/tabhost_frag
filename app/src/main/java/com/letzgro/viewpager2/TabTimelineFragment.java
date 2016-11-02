package com.letzgro.viewpager2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.letzgro.viewpager2.adapters.AdapterLoads;
import com.letzgro.viewpager2.model.Loads;

import java.util.ArrayList;

public class TabTimelineFragment extends Fragment {

    /**
     * Define global variables over here
     */

    ArrayList<Loads> mLoadsArrayList;
    ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mLoadsArrayList = new ArrayList<>();

        mLoadsArrayList.add(new Loads("L1: P/U 1 LD99875", "08/05/16", "Trammo, Inc. Chemicals Division",
                "One Rockefeller Plaza, 9th floor, New York, NY 10020-2078", "+14567347853"));

        AdapterLoads adapterLoads = new AdapterLoads(getActivity(), mLoadsArrayList);
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.tab_timeline_view, container, false);

        mListView = (ListView) rootView.findViewById(R.id.listView);

        mListView.setAdapter(adapterLoads);
        return rootView;
    }

}