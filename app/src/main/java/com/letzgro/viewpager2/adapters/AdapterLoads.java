package com.letzgro.viewpager2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.letzgro.viewpager2.R;
import com.letzgro.viewpager2.model.Loads;

import java.util.ArrayList;

/**
 * Created by bomko on 01.11.16.
 */

public class AdapterLoads extends BaseAdapter {

    ArrayList<Loads> mLoadsArrayList;
    Context mContext;

    public AdapterLoads(Context context, ArrayList<Loads> tripArrayList) {
        mContext = context;
        mLoadsArrayList = tripArrayList;
    }

    @Override
    public int getCount() {
        return mLoadsArrayList.size();
    }

    @Override
    public Loads getItem(int position) {
        return mLoadsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class ViewHolder {
        TextView mName, mDate, mCity, mLocation, mPhone;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        Loads trip = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_loads, viewGroup, false);
            viewHolder = new ViewHolder();

            viewHolder.mName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.mDate = (TextView) convertView.findViewById(R.id.tvDate);
            viewHolder.mCity = (TextView) convertView.findViewById(R.id.tvCity);
            viewHolder.mLocation = (TextView) convertView.findViewById(R.id.tvLocation);
            viewHolder.mPhone = (TextView) convertView.findViewById(R.id.tvPhone);
            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mName.setText(trip.getName());
        viewHolder.mDate.setText(trip.getDate());
        viewHolder.mCity.setText(trip.getCity());
        viewHolder.mLocation.setText(trip.getLocation());
        viewHolder.mPhone.setText(trip.getPhone());

        return convertView;
    }
}