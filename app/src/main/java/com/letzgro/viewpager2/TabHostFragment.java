package com.letzgro.viewpager2;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.letzgro.viewpager2.fragment.BaseContainerFragment;
import com.letzgro.viewpager2.fragment.CheckIn;
import com.letzgro.viewpager2.fragmentcontainer.TripFragment;
import com.letzgro.viewpager2.model.Trip;
import com.letzgro.viewpager2.view.LineView;


public class TabHostFragment extends Fragment {

    private FragmentTabHost mTabHost;

    Paint mPaintGreen, mPaintRed;

    LineView graph;
    float startPoint = 10;
    float endPoint;

    float count = 5;
    float averageSize;


    TextView mTextViewStartDate, mTextViewEndDate, mTextViewCountryFrom, mTextViewCountryTo,
            mTextViewCountLoads, mTextViewCountStops, mTextViewStatus, mTextViewName;

    //Mandatory Constructor
    public TabHostFragment() {
    }

    /*
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

        }
    */
    Trip trip;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        customActionBar();
        View rootView = inflater.inflate(R.layout.tab8_view, container, false);

        trip = getArguments().getParcelable("item");

        mTabHost = (FragmentTabHost) rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("timeline").setIndicator(createTabIndicator(mTabHost, "timeline", 0)), TabTimelineFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("loads").setIndicator(createTabIndicator(mTabHost, "by loads", 0)), TabByLoadsFragment.class, null);

        mTextViewStartDate = (TextView) rootView.findViewById(R.id.tvDateStart);
        mTextViewEndDate = (TextView) rootView.findViewById(R.id.tvDateEnd);
        mTextViewCountryFrom = (TextView) rootView.findViewById(R.id.tvCountryFrom);
        mTextViewCountryTo = (TextView) rootView.findViewById(R.id.tvCountryTo);
        mTextViewCountLoads = (TextView) rootView.findViewById(R.id.tvCountLoads);
        mTextViewCountStops = (TextView) rootView.findViewById(R.id.tvCountStops);
        mTextViewStatus = (TextView) rootView.findViewById(R.id.tvStatus);
        mTextViewName = (TextView) rootView.findViewById(R.id.tvName);

        if (trip != null) {
            mTextViewStartDate.setText(trip.getDateStart());
            mTextViewEndDate.setText(trip.getDateEnd());
            mTextViewCountryFrom.setText(trip.getCountryFrom());
            mTextViewCountryTo.setText(trip.getCountryTo());
            mTextViewCountLoads.setText("" + trip.getCountLoads());
            mTextViewCountStops.setText("" + trip.getCountStops());
            mTextViewStatus.setText(trip.getStatus());
            mTextViewName.setText("");
        }


        graph = (LineView) rootView.findViewById(R.id.linechart);


        mPaintGreen = new Paint();
        mPaintRed = new Paint();

        mPaintGreen.setColor(Color.GREEN);
        mPaintRed.setColor(Color.RED);

        ViewTreeObserver vto = graph.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int width = graph.getWidth();
                graph.measure(width, 5);

                graph.setStartX(0);
                graph.setStartY(10);
                graph.setStopY(10);
                graph.setStopX(width);

                averageSize = width / (count - 1);
                endPoint = width - 10;

               /* points.add(new CustomPoint(startPoint, 10, mPaintGreen));
                points.add(new CustomPoint(averageSize, 10, mPaintRed));
                points.add(new CustomPoint(averageSize * 2, 10, mPaintGreen));
                points.add(new CustomPoint(averageSize * 3, 10, mPaintGreen));
                points.add(new CustomPoint(endPoint, 10, mPaintRed));*/

            }
        });


        return rootView;
    }

    public View createTabIndicator(TabHost tabHost, String textResource, int iconResource) {
        View tabIndicator = LayoutInflater.from(getActivity()).inflate(R.layout.tab_indicator, tabHost.getTabWidget(), false);
        ((TextView) tabIndicator.findViewById(android.R.id.title)).setText(textResource);
        ((ImageView) tabIndicator.findViewById(android.R.id.icon)).setImageResource(iconResource);
        return tabIndicator;
    }

    private void customActionBar() {

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        LayoutInflater inflater = LayoutInflater.from(this.getActivity());
        View v = inflater.inflate(R.layout.custom_actionbar_timeline_loads, null);

        trip = getArguments().getParcelable("item");

        ((TextView) v.findViewById(R.id.title)).setText(trip.getName());
        ( v.findViewById(R.id.btn_all_trip)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TripFragment fragment = new TripFragment();
                // if U need to pass some data
                Bundle bundle = new Bundle();
                fragment.setArguments(bundle);
                ((BaseContainerFragment) getParentFragment()).replaceFragment(fragment, true);
            }
        });


        ( v.findViewById(R.id.btnCheckIn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckIn fragment = new CheckIn();
                // if U need to pass some data
                Bundle bundle = new Bundle();
                fragment.setArguments(bundle);
                ((BaseContainerFragment) getParentFragment()).replaceFragment(fragment, true);
            }
        });

        actionBar.setCustomView(v);
        ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        p.gravity = Gravity.CENTER;

    }


}