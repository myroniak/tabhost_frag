package com.letzgro.viewpager2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.letzgro.viewpager2.R;
import com.letzgro.viewpager2.model.Trip;

import java.util.ArrayList;

/**
 * Created by bomko on 18.10.16.
 */

public class AdapterTrip extends BaseAdapter {
    private Context mContext;
    private ArrayList<Trip> mTripArrayList;

    public AdapterTrip(Context context, ArrayList<Trip> tripArrayList) {
        mContext = context;
        mTripArrayList = tripArrayList;
    }

    @Override
    public int getCount() {
        return mTripArrayList.size();
    }

    @Override
    public Trip getItem(int position) {
        return mTripArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private static class ViewHolder {
        TextView mCountryFrom, mCountryTo, mDateStart, mDateEnd,
                mName, mCountLoads, mCountStops, mStatus;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        Trip trip = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_trip, viewGroup, false);
            viewHolder = new ViewHolder();

            viewHolder.mCountryFrom = (TextView) convertView.findViewById(R.id.tvCountryFrom);
            viewHolder.mCountryTo = (TextView) convertView.findViewById(R.id.tvCountryTo);
            viewHolder.mDateStart = (TextView) convertView.findViewById(R.id.tvDateStart);
            viewHolder.mDateEnd = (TextView) convertView.findViewById(R.id.tvDateEnd);
            viewHolder.mName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.mCountLoads = (TextView) convertView.findViewById(R.id.tvCountLoads);
            viewHolder.mCountStops = (TextView) convertView.findViewById(R.id.tvCountStops);
            viewHolder.mStatus = (TextView) convertView.findViewById(R.id.tvStatus);

            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.mCountryFrom.setText(trip.getCountryFrom());
        viewHolder.mCountryTo.setText(trip.getCountryTo());
        viewHolder.mDateStart.setText(trip.getDateStart());
        viewHolder.mDateEnd.setText(trip.getDateEnd());
        viewHolder.mName.setText(trip.getName());
        viewHolder.mCountLoads.setText("" + trip.getCountLoads());
        viewHolder.mCountStops.setText("" + trip.getCountStops());
        viewHolder.mStatus.setText(trip.getStatus());

        return convertView;
    }
}