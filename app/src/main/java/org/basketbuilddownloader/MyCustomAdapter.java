package org.basketbuilddownloader;


import android.Manifest;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MyCustomAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final File[] file;

    public MyCustomAdapter(Context context, String[] values, File[] file) {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
        this.file = file;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);
        // Change the icon for Windows and iPhone
        String s = values[position];
        for (int j = 0; j < file.length; j++) {

            if (s.equals(file[j].getName())) {
                Log.w("BasketBuild","have file: "+s);
                textView.setTextColor(R.color.disabledText);
                rowView.setEnabled(false);
            }
        }


        return rowView;
    }
}