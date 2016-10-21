package com.letzgro.viewpager2.fragmentcontainer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.letzgro.viewpager2.R;
import com.letzgro.viewpager2.TabHostFragment;
import com.letzgro.viewpager2.adapters.AdapterTrip;
import com.letzgro.viewpager2.fragment.BaseContainerFragment;
import com.letzgro.viewpager2.model.Trip;

import java.util.ArrayList;

public class TripFragment extends Fragment {

    /**
     * Define global variables over here
     */
    //private ProgressDialog pDialog;
    String[] names = {"Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей"};
    ArrayList<Trip> mTripArrayList;
    AdapterTrip mAdapterTrip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab2_view, container, false);
        customActionBar();
      /*  Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);*/

        ListView lvMain = (ListView) rootView.findViewById(R.id.lvMain);

        mTripArrayList = new ArrayList<>();
        mTripArrayList.add(new Trip("TR159681", "Laredo, TX", "Trace, CA", "08/05/16", "08/09/16", "scheduled", 1, 3));
        mTripArrayList.add(new Trip("TR159681", "Laredo, TX", "Trace, CA", "08/05/16", "08/09/16", "in-transit", 2, 5));
        // создаем адаптер

        mAdapterTrip = new AdapterTrip(getActivity(), mTripArrayList);


        //  ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, names);

        lvMain.setAdapter(mAdapterTrip);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {

                TabHostFragment fragment = new TabHostFragment();
                // if U need to pass some data
                Bundle bundle = new Bundle();

                fragment.setArguments(bundle);
                ((BaseContainerFragment) getParentFragment()).replaceFragment(fragment, true);
            }
        });
        return rootView;
    }


    private void customActionBar() {

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_actionbar_trip_1);
        ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        p.gravity = Gravity.CENTER;


    }
}