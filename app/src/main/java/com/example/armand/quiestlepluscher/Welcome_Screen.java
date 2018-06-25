package com.example.armand.quiestlepluscher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.armand.quiestlepluscher.Screen.Connexion;
import com.example.armand.quiestlepluscher.Screen.Inscription;
import com.example.armand.quiestlepluscher.sqlite.*;

public class Welcome_Screen extends AppCompatActivity {

    private static MySQLDataBase mysqlDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mysqlDatabase = new MySQLDataBase(this);


    }


    public static MySQLDataBase getMysqlDatabase() {
        return mysqlDatabase;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome__screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Inscription) {
            Intent intent= new Intent(this,Inscription.class);
            startActivity(intent);
        }

        if (id == R.id.action_Connexion) {
            Intent intent= new Intent(this,Connexion.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


}
