package com.example.armand.quiestlepluscher.screen;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.armand.quiestlepluscher.R;

/**
 * Created by armand on 25/06/2018.
 */

public class Connexion extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

    }
}
