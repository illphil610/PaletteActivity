package edu.temple.paletteactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<String> myColors;
    Context context;

    public MyAdapter(Context context, ArrayList colors){
        this.context = context;
        this.myColors = colors;
    }

    @Override
    public int getCount() {
        return myColors.size();
    }

    @Override
    public Object getItem(int position) {
        return myColors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //Will create a TextView and set the background color
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView = new TextView(context);
        textView.setText(myColors.get(position));
        textView.setTextSize(35);
        textView.setBackgroundColor(Color.parseColor(myColors.get(position)));

        return textView;

    }
}