package com.letzgro.viewpager2.fragmentcontainer;

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
import com.letzgro.viewpager2.fragment.BaseContainerFragment;
import com.letzgro.viewpager2.fragment.EditProfileFragment;

public class ProfileFragment extends Fragment {

    /**
     * Define global variables over here
     */
    //private ProgressDialog pDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.talk, container, false);
        customActionBar();
        Button btn = (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Here TalkDetail is name of class that needs to open
                EditProfileFragment fragment = new EditProfileFragment();
                // if U need to pass some data
                Bundle bundle = new Bundle();
                 //bundle.putSerializable("l",);
               /*     bundle.putString("title", m_ArrayList.get(arg2).title);
                    bundle.putString("largeimg", m_ArrayList.get(arg2).largeimg);
                    bundle.putString("excert", m_ArrayList.get(arg2).excert);
                    bundle.putString("description", m_ArrayList.get(arg2).description);
                    bundle.putString("cat", m_ArrayList.get(arg2).cat);*/
                //bundle.putInt("postid", m_ArrayList.get(arg2).postid);

                fragment.setArguments(bundle);
                ((BaseContainerFragment) getParentFragment()).replaceFragment(fragment, true);
            }
        });

        return rootView;
    }

    private void customActionBar() {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.custom_actionbar_profile);
        ActionBar.LayoutParams p = new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        p.gravity = Gravity.CENTER;
    }

}