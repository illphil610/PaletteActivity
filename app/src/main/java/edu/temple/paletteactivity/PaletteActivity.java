package edu.temple.paletteactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import static edu.temple.paletteactivity.R.id.listView;

public class PaletteActivity extends Activity {
    
    LinearLayout myLayout;
    MyAdapter myAdapter;
    GridView myList;
    String message = "message key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (LinearLayout) findViewById(R.id.activity_main);

        final ArrayList<String> myColors = new ArrayList<>();
        myColors.add("White");
        myColors.add("Blue");
        myColors.add("Green");
        myColors.add("Olive");
        myColors.add("Red");
        myColors.add("Maroon");
        myColors.add("Yellow");
        myColors.add("Purple");
        myColors.add("Cyan");
        myColors.add("Gray");
        myColors.add("DarkGrey");
        myColors.add("Silver");
        myColors.add("Magenta");
        myColors.add("Black");

        Resources res = getResources();
        final String[] colors = res.getStringArray(R.array.color_array);
        final String[] actualColors = res.getStringArray(R.array.actual_color_array);


        myAdapter= new MyAdapter(PaletteActivity.this, colors, actualColors);

        myList = (GridView) findViewById(listView);

        myList.setAdapter(myAdapter);

        AdapterView.OnItemClickListener listListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent newActivityIntent = new Intent(PaletteActivity.this, CanvasActivity.class);

                //String colorSelection = myColors.get(position);

                newActivityIntent.putExtra(message, actualColors[position]);

                startActivity(newActivityIntent);
            }
        };
        myList.setOnItemClickListener(listListener);
    }
}
