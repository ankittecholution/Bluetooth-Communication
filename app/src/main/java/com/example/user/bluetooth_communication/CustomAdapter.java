package com.example.user.bluetooth_communication;


import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CustomAdapter extends ArrayAdapter<LinkedHashMap<DeviesModel, BluetoothDevice>> {


    private ArrayList<LinkedHashMap<DeviesModel, BluetoothDevice>> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
    }

    public CustomAdapter(ArrayList<LinkedHashMap<DeviesModel, BluetoothDevice>> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;

    }


    private int lastPosition = -1;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final LinkedHashMap<DeviesModel, BluetoothDevice> data = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.macaddress);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        viewHolder.txtName.setText((new ArrayList<DeviesModel>(data.keySet())).get(position).getDevies_name());
        viewHolder.txtType.setText((new ArrayList<DeviesModel>(data.keySet())).get(position).getDevies_mac());

        Log.i("test",(new ArrayList<DeviesModel>(data.keySet())).get(position).getDevies_name());
        // Return the completed view to render on screen
        return convertView;
    }
}
