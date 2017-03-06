package edu.temple.paletteactivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    //ArrayList<String> myColors;
    Context context;
    private String[] colors;
    private String[] actualColors;

    public MyAdapter(Context context, String[] colors, String[] actualColors ){
        this.context = context;
        this.colors = colors;
        this.actualColors = actualColors;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //Will create a TextView and set the background color
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView = new TextView(context);
        textView.setText(this.colors[position]);
        //textView.setTextSize(35);
        textView.setBackgroundColor(Color.parseColor(actualColors[position]));

        return textView;

    }
}