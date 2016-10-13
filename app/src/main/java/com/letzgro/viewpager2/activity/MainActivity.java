package com.letzgro.viewpager2.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec(TAB_1_TAG).setIndicator("Chat", getResources().getDrawable(R.mipmap.ic_launcher)), ChatFragment.class, null);
       // mTabHost.addTab(mTabHost.newTabSpec(TAB_1_TAG).setIndicator("Chat"), ChatFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_2_TAG).setIndicator("Trip"), TripFragmentContainer.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_3_TAG).setIndicator("Item3"), Tab3Fragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_4_TAG).setIndicator("Item4"), Tab4Fragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAB_5_TAG).setIndicator("Profile"), ProfileFragmentContainer.class, null);

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
        if (!isPopFragment) {
            finish();
        }
    }


}