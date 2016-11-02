package com.letzgro.viewpager2.adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.letzgro.viewpager2.R;
import com.letzgro.viewpager2.model.CustomPoint;
import com.letzgro.viewpager2.model.Trip;
import com.letzgro.viewpager2.view.LineView;

import java.util.ArrayList;

import static com.letzgro.viewpager2.R.id.linechart;
import static com.letzgro.viewpager2.view.LineView.points;

/**
 * Created by bomko on 18.10.16.
 */

public class AdapterTrip extends BaseAdapter {

    Paint mPaintGreen, mPaintRed;


    float startPoint = 10;
    float endPoint;

    float count = 5;
    float averageSize;



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
        LineView mLineView;
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
            viewHolder.mLineView = (LineView) convertView.findViewById(linechart);
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

        line(viewHolder);

        return convertView;
    }


    public void line(final ViewHolder viewHolder) {

        final LineView graph = viewHolder.mLineView;


        mPaintGreen = new Paint();
        mPaintRed = new Paint();

        mPaintGreen.setColor(Color.GREEN);
        mPaintRed.setColor(Color.RED);

        ViewTreeObserver vto = graph.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int width = viewHolder.mLineView.getWidth();
                graph.measure(width, 5);

                graph.setStartX(0);
                graph.setStartY(10);
                graph.setStopY(10);
                graph.setStopX(width);

                averageSize = width / (count - 1);
                endPoint = width - 10;
                points = new ArrayList<CustomPoint>();
                points.add(new CustomPoint(startPoint, 10, mPaintGreen));
                points.add(new CustomPoint(averageSize, 10, mPaintRed));
                points.add(new CustomPoint(averageSize * 2, 10, mPaintGreen));
                points.add(new CustomPoint(averageSize * 3, 10, mPaintGreen));
                points.add(new CustomPoint(endPoint, 10, mPaintRed));

            }
        });

    }
}