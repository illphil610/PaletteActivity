package edu.temple.paletteactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        this.setTitle("Canvas Activity");

        LinearLayout myLayout = (LinearLayout) findViewById(R.id.activity_canvas);

        Intent myIntent = getIntent();

        String message = myIntent.getStringExtra("message key");

        myLayout.setBackgroundColor(Color.parseColor(message));
    }
}
