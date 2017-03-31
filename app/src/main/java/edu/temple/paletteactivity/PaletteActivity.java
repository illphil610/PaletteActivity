package edu.temple.paletteactivity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class PaletteActivity extends Activity implements PalletteFragment.PalletteInterface {

    CanvasFragment canvasFragment;
    PalletteFragment palletteFragment;
    boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPanes = (findViewById(R.id.canvas_fragment) != null);

        canvasFragment = new CanvasFragment();
        palletteFragment = new PalletteFragment();

        //Load PaletteFragment by default
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.palette_fragment, palletteFragment);
        fragmentTransaction.commit();

        if(twoPanes) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.canvas_fragment, canvasFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void changeCanvasColor(String color) {

        /*hey joey! So I think this is where the issue lies...or something about this code and what
        it calls.  If i comment out the canvas.changeBackground.... and allow the doTrans to run then
        it will go to the next activity but that breaks the ability to run this app in landscape mode.
        If i comment out the doTrans, then it works in landscape mode but breaks when running on small devices
        in portrait mode.  PREEZ HALP! lol....
        */

        doTransition();
        //canvasFragment.changeBackgroundColor(color);

    }

    public void doTransition(){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.palette_fragment, canvasFragment)
                .addToBackStack(null)
                .commit();
    }
}

