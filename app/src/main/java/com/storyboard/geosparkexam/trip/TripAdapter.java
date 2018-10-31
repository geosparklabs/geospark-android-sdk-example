package com.storyboard.geosparkexam.trip;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.geospark.lib.GeoSpark;
import com.geospark.lib.callback.GeoSparkTripCallBack;
import com.geospark.lib.model.GeoSparkError;
import com.geospark.lib.model.GeoSparkTrip;
import com.geospark.lib.model.GeoSparkTrips;
import com.storyboard.geosparkexam.R;
import com.storyboard.geosparkexam.presistence.GeosparkLog;

import java.util.ArrayList;
import java.util.List;

public class TripAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<GeoSparkTrips> mGeoLog = new ArrayList<>();

    TripAdapter(Context context) {
        this.mContext = context;
    }

    void addAllItem(List<GeoSparkTrips> lst) {
        mGeoLog.clear();
        mGeoLog.addAll(lst);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_item, parent, false);
        vh = new ItemHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final GeoSparkTrips geoSparkTrips = mGeoLog.get(position);
        ((ItemHolder) holder).mTxtId.setText(geoSparkTrips.getTripId());
        ((ItemHolder) holder).mTxtDate.setText(geoSparkTrips.getTripStartedAt());
        ((ItemHolder) holder).mTxtStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GeoSpark.endTrip(mContext, geoSparkTrips.getTripId(), new GeoSparkTripCallBack() {
                    @Override
                    public void onSuccess(GeoSparkTrip geoSparkTrip) {
                        GeosparkLog.getInstance(mContext).createLog("Trip ended", geoSparkTrips.getTripId());
                        Toast.makeText(mContext, "Trip successfully ended.", Toast.LENGTH_SHORT).show();
                        removeItem(position);
                    }

                    @Override
                    public void onFailure(GeoSparkError geoSparkError) {
                        GeosparkLog.getInstance(mContext).createLog("Trip ended error", geoSparkTrips.getTripId() + " " + geoSparkError.getErrorCode() + " " + geoSparkError.getErrorMessage());
                        Toast.makeText(mContext, geoSparkError.getErrorCode() + " " + geoSparkError.getErrorMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void removeItem(int position) {
        mGeoLog.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mGeoLog.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        private TextView mTxtId;
        private TextView mTxtDate;
        private TextView mTxtStop;

        ItemHolder(View itemView) {
            super(itemView);
            mTxtId = itemView.findViewById(R.id.txt_id);
            mTxtDate = itemView.findViewById(R.id.txt_date);
            mTxtStop = itemView.findViewById(R.id.txt_stop);
        }
    }
}
