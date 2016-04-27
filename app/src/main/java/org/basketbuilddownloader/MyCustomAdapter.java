package org.basketbuilddownloader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.rowlayout, parent, false);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.label);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String s = values[position];
        holder.text.setText(s);

        for (int j = 0; j < file.length; j++) {

            if (s.equals(file[j].getName())) {
                //Log.w("BasketBuild","have file: "+s);
                holder.text.setTextColor(R.color.disabledText);
                convertView.setEnabled(false);
            }
        }


        return convertView;
    }

    static class ViewHolder {
        TextView text;
    }

}