package edu.temple.paletteactivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class PaletteActivity extends Activity implements PalletteFragment.PalletteInterface {

    CanvasFragment canvasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        canvasFragment = new CanvasFragment();

        addFragment(new PalletteFragment(), R.id.palette_fragment);
        addFragment(canvasFragment, R.id.canvas_fragment);

    }

    private void addFragment(Fragment fragment, int containerId) {
        getFragmentManager().beginTransaction().replace(containerId, fragment).commit();
    }

    @Override
    public void changeCanvasColor(String color){
        canvasFragment.changeBackgroundColor(color);
    }

}

