package com.example.drunkmeter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class EntriesAdapter extends ArrayAdapter<PastResEntry> {


    private static final String TAG = "PersonListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;


    private static class ViewHolder {
        ImageView ratingImage;
        TextView dateAndTime;
        TextView rating;
    }


    public EntriesAdapter(Context context, int resource, ArrayList<PastResEntry> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String date = getItem(position).getDate();
        String time = getItem(position).getTime();
        String rating = getItem(position).getRating();

        PastResEntry entry = new PastResEntry(date, time, rating);

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;


        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.dateAndTime = (TextView) convertView.findViewById(R.id.dateAndtime);
            holder.rating = (TextView) convertView.findViewById(R.id.rating);

            result = convertView;

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        holder.dateAndTime.setText(entry.getDateAndTime());
        holder.rating.setText(entry.getRating());

        return convertView;
    }
}
