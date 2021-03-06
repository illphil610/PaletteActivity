package edu.temple.paletteactivity;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    FrameLayout canvasFrame;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_canvas, container, false);

        canvasFrame = (FrameLayout) view.findViewById(R.id.canvas_frame);

        return view;
    }

    public void changeBackgroundColor(String color) {
        if(canvasFrame != null)
            canvasFrame.setBackgroundColor(Color.parseColor(color));
    }
}