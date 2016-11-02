package com.letzgro.viewpager2.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.letzgro.viewpager2.R;
import com.letzgro.viewpager2.fragment.BaseContainerFragment;
import com.letzgro.viewpager2.fragment.ChatFragment;
import com.letzgro.viewpager2.fragment.Tab3Fragment;
import com.letzgro.viewpager2.fragment.Tab4Fragment;
import com.letzgro.viewpager2.fragmentcontainer.ProfileFragmentContainer;
import com.letzgro.viewpager2.fragmentcontainer.TripFragmentContainer;

public class MainActivity extends AppCompatActivity {

    private static final String TAB_1_TAG = "tab_1";
    private static final String TAB_2_TAG = "tab_2";
    private static final String TAB_3_TAG = "tab_3";
    private static final String TAB_4_TAG = "tab_4";
    private static final String TAB_5_TAG = "tab_5";
    private FragmentTabHost mTabHost;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
    }

    private void initView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec(TAB_1_TAG).setIndicator(createTabIndicator(mTabHost, "Chat", R.drawable.ic_chat_brown_600_18dp)), ChatFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_2_TAG).setIndicator(createTabIndicator(mTabHost, "Trips", R.drawable.ic_compare_arrows_brown_500_18dp)), TripFragmentContainer.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_3_TAG).setIndicator(createTabIndicator(mTabHost, "Item 3", R.drawable.ic_hourglass_empty_brown_500_18dp)), Tab3Fragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_4_TAG).setIndicator(createTabIndicator(mTabHost, "Item 4", R.drawable.ic_hourglass_empty_brown_500_18dp)), Tab4Fragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_5_TAG).setIndicator(createTabIndicator(mTabHost, "Profile", R.drawable.ic_chat_brown_600_18dp)), ProfileFragmentContainer.class, null);

            /* Increase tab height programatically
             * tabs.getTabWidget().getChildAt(1).getLayoutParams().height = 150;
             */

        for (int i = 0; i < mTabHost.getTabWidget().getChildCount(); i++) {
            final TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            if (tv == null)
                continue;
            else
                tv.setTextSize(10);
        }
    }

    @Override
    public void onBackPressed() {
        boolean isPopFragment = false;
        String currentTabTag = mTabHost.getCurrentTabTag();
        try {
            if (currentTabTag.equals(TAB_1_TAG)) {
                isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_1_TAG)).popFragment();
            } else if (currentTabTag.equals(TAB_2_TAG)) {
                isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_2_TAG)).popFragment();
            } else if (currentTabTag.equals(TAB_3_TAG)) {
                isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_3_TAG)).popFragment();
            } else if (currentTabTag.equals(TAB_4_TAG)) {
                isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_4_TAG)).popFragment();
            } else if (currentTabTag.equals(TAB_5_TAG)) {
                isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_5_TAG)).popFragment();
            }
        } catch (ClassCastException e) {

        }
        if (!isPopFragment) {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);        }
    }

    public View createTabIndicator(TabHost tabHost, String textResource, int iconResource) {
        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, tabHost.getTabWidget(), false);
        ((TextView) tabIndicator.findViewById(android.R.id.title)).setText(textResource);
        ((ImageView) tabIndicator.findViewById(android.R.id.icon)).setImageResource(iconResource);
        return tabIndicator;
    }

}