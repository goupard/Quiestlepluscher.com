package com.example.armand.quiestlepluscher.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.armand.quiestlepluscher.R;
import com.example.armand.quiestlepluscher.sqlite.dao.MarqueDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.ProduitDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.TypeDAO;
import com.example.armand.quiestlepluscher.sqlite.entities.Marque;
import com.example.armand.quiestlepluscher.sqlite.entities.Produit;
import com.example.armand.quiestlepluscher.sqlite.entities.Type;
import com.example.armand.quiestlepluscher.sqlite.entities.Utilisateur;

import java.util.List;

/**
 * Created by armand on 07/07/2018.
 */

public class KnownScan extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        final Utilisateur utilisateurConnecte = (Utilisateur) intent.getSerializableExtra("utilisateurConnecte");
        setContentView(R.layout.activity_result_scan__screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String barcode = intent.getStringExtra("barcode");
        TextView tviewNumCodeBarres = (TextView)findViewById(R.id.contenunumero);
        tviewNumCodeBarres.setText(barcode);


        Button buttonSearch = (Button) findViewById(R.id.otherscan);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchProduct = new Intent(getApplicationContext(),ScannerCodeBarres.class);
                searchProduct.putExtra("utilisateurConnecte",utilisateurConnecte);
                startActivity(searchProduct);
            }
        });


        /*Produit produit = null;
        List<Produit> produits =  ProduitDAO.getProduits(ProduitDAO.sqlGetAllProduits);
        for(Produit p : produits){
            if(p.getNum_code_barres().equals(barcode)){
                produit = p;
            }
        }
        if(produit == null){
            return;
        }*/
        Produit produit = ProduitDAO.getProduits(this,ProduitDAO.sqlFindProduitByNumCodeBarres(barcode)).get(0);

        TextView tviewNomProduit = (TextView)findViewById(R.id.contenuNomProduit);
        tviewNomProduit.setText(produit.getNom_produit());

        TextView tviewDescProduit = (TextView)findViewById(R.id.contenudescriptionproduit);
        tviewDescProduit.setText(produit.getDescription());


        TextView tviewMarquePrduit = (TextView)findViewById(R.id.contenumarqueproduit);
        Marque marque = MarqueDAO.getMarques(this,MarqueDAO.sqlFindMarqueById(produit.getFk_marque())).get(0);
        tviewMarquePrduit.setText(marque.getNom_marque());


        Type type = null;
        List<Type> types =  TypeDAO.getTypes(this,TypeDAO.sqlGetAllTypes);
        for(Type t : types){
            if(t.getId_type() == produit.getFk_type()){
                type = t;
            }
        }
        if(type == null){
            return;
        }

        TextView tviewTypeProduit = (TextView)findViewById(R.id.contenutypeproduit);
        //Type type = TypeDAO.getTypes(TypeDAO.sqlFindTypeById(produit.getFk_type())).get(0);
        tviewTypeProduit.setText(type.getNom_type());
    }
}
