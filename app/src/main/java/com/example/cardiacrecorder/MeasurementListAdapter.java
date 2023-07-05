package com.example.cardiacrecorder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

/**
 * This is an adapter for custom list view
 */
public class MeasurementListAdapter extends ArrayAdapter<MeasurementModelClass> {
    private Activity context;
    private List<MeasurementModelClass> measurementList;

    public MeasurementListAdapter(Activity context, List<MeasurementModelClass> measurementList)
    {
        super(context, R.layout.measurement_list, measurementList);
        this.context = context;
        this.measurementList = measurementList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.measurement_list,null,true);

        TextView textViewSystolic = (TextView) listViewItem.findViewById(R.id.textViewSysListId);
        TextView textViewDiastolic = (TextView) listViewItem.findViewById(R.id.textViewDiasListId);
        TextView textViewHeartRate = (TextView) listViewItem.findViewById(R.id.textViewHrtListId);
        TextView textViewDate = (TextView) listViewItem.findViewById(R.id.textViewDateListId);

        MeasurementModelClass measurement = measurementList.get(position);


        textViewSystolic.setText("Systolic: "+measurement.getSystolic());
        textViewDiastolic.setText("Diastolic: "+measurement.getDiastolic());
        textViewHeartRate.setText("Heart Rate: "+measurement.getHeartRate());
        textViewDate.setText("Date: "+measurement.getDate());

        if(Integer.parseInt(getItem(position).getSystolic().toString())>140 || Integer.parseInt(getItem(position).getDiastolic().toString())>90)
        {
            listViewItem.setBackground(ContextCompat.getDrawable(context, R.drawable.rounded_corner_red));
        }
        else if(Integer.parseInt(getItem(position).getSystolic().toString())<90 || Integer.parseInt(getItem(position).getDiastolic().toString())<60)
        {
            listViewItem.setBackground(ContextCompat.getDrawable(context, R.drawable.rounded_corner_yellow));
        }
        else
            listViewItem.setBackground(ContextCompat.getDrawable(context, R.drawable.rounded_corner_green));
        return listViewItem;
    }
}