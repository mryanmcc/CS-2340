package TEAM79b.m4.controller;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import TEAM79b.m4.R;

/**
 * Pop up screen from entering invalid login info
 */
public class BadIdScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_id_screen);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;

        getWindow().setLayout((int) (width * .8), 350);
    }

}
