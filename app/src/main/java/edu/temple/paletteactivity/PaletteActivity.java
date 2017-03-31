package edu.temple.paletteactivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class PaletteActivity extends Activity implements PalletteFragment.PalletteInterface {

    CanvasFragment canvasFragment;
    boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPanes = (findViewById(R.id.canvas_fragment) != null);

        canvasFragment = new CanvasFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.palette_fragment, new PalletteFragment());
        fragmentTransaction.commit();

        if(twoPanes) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.canvas_fragment, canvasFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void changeCanvasColor(String color) {
        if(!twoPanes) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.palette_fragment, canvasFragment)
                    .addToBackStack(null).commit();

            getFragmentManager().executePendingTransactions();
        }
        canvasFragment.changeBackgroundColor(color);
    }
}

