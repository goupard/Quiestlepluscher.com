package com.example.armand.quiestlepluscher.screen;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.armand.quiestlepluscher.R;

/**
 * Created by armand on 15/06/2018.
 */

public class Inscription extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription__screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    }


}
