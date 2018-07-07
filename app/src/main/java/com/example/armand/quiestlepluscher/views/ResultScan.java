package com.example.armand.quiestlepluscher.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.armand.quiestlepluscher.R;
import com.example.armand.quiestlepluscher.sqlite.MySQLDataBase;
import com.example.armand.quiestlepluscher.sqlite.dao.ProduitDAO;
import com.example.armand.quiestlepluscher.sqlite.entities.Produit;

/**
 * Created by armand on 07/07/2018.
 */

public class ResultScan extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_scan__screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        String barcode = intent.getStringExtra("barcode");
        TextView tview = (TextView)findViewById(R.id.contenunumero);
        tview.setText(barcode);
        /*Produit produit=ProduitDAO.getProduits(ProduitDAO.sqlFindProduitByNumCodeBarres(barcode)).get(0);
        tview = (TextView)findViewById(R.id.contenuNomProduit);
        tview.setText(produit.getNom_produit());
        tview = (TextView)findViewById(R.id.contenudescriptionproduit);
        tview.setText(produit.getDescription());
        tview = (TextView)findViewById(R.id.contenumarqueproduit);
        tview.setText(produit.getFk_marque());
        tview = (TextView)findViewById(R.id.contenutypeproduit);
        tview.setText(produit.getFk_type());*/
    }
}
