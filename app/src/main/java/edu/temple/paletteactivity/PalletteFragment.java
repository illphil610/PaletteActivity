package edu.temple.paletteactivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PalletteFragment extends Fragment {

    GridView gridView;
    PalletteInterface parentInt;

    public PalletteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pallette, container, false);

        gridView = (GridView) view.findViewById(R.id.grid_view);
        parentInt = (PalletteInterface) getContext();

        //Used for the spanish translation part of the app
        Resources res = getResources();
        final String[] colors = res.getStringArray(R.array.color_array);
        final String[] actualColors = res.getStringArray(R.array.actual_color_array);

        final MyAdapter myAdapter = new MyAdapter(getActivity(), colors, actualColors);

        gridView.setAdapter(myAdapter);

        AdapterView.OnItemClickListener listListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String color = actualColors[position];
                parentInt.changeCanvasColor(color);
            }
        };

        gridView.setOnItemClickListener(listListener);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(activity instanceof PalletteInterface) {
            parentInt = (PalletteInterface) activity;
        } else {
            throw new RuntimeException("Not Implemented");
        }
    }

    public interface PalletteInterface{
        void changeCanvasColor(String color);
    }
}
