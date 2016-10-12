package com.letzgro.viewpager2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.letzgro.viewpager2.R;

public class EditProfileFragment extends Fragment {

    /**
     * Define global variables over here
     */
    //private ProgressDialog pDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        customActionBar();

        View rootView = inflater.inflate(R.layout.edit_profile, container, false);

        Button btn = (Button) rootView.findViewById(R.id.buttonE);
        Button btnP = (Button) rootView.findViewById(R.id.buttonP);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ChangeEmailFragment fragment = new ChangeEmailFragment();
                Bundle bundle = new Bundle();
                fragment.setArguments(bundle);
                ((BaseContainerFragment) getParentFragment()).replaceFragment(fragment, true);
            }
        });

        btnP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ChangePasswordFragment fragment = new ChangePasswordFragment();
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
        actionBar.setCustomView(R.layout.custom_actionbar_edit_profile);
        ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        p.gravity = Gravity.CENTER;
    }
}