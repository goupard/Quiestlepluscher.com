package com.example.armand.quiestlepluscher.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.armand.quiestlepluscher.R;
import com.example.armand.quiestlepluscher.sqlite.dao.EnregistrementDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.MarqueDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.ProduitDAO;
import com.example.armand.quiestlepluscher.sqlite.dao.TypeDAO;
import com.example.armand.quiestlepluscher.sqlite.entities.Enregistrement;
import com.example.armand.quiestlepluscher.sqlite.entities.Marque;
import com.example.armand.quiestlepluscher.sqlite.entities.Produit;
import com.example.armand.quiestlepluscher.sqlite.entities.Type;
import com.example.armand.quiestlepluscher.sqlite.entities.Utilisateur;

import java.util.Date;
import java.util.List;

/**
 * Created by ulyss on 07/07/2018.
 */

public class UnknownScan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unknownscan__screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        final Utilisateur utilisateurConnecte = (Utilisateur) intent.getSerializableExtra("utilisateurConnecte");
        final String barcode = intent.getStringExtra("barcode");
        TextView tViewNumCodeBarres = (TextView)findViewById(R.id.textViewCodeBarresUnknown);
        tViewNumCodeBarres.setText(barcode);


        Button buttonSearch = (Button) findViewById(R.id.buttonEnregistrement);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean foundMarque = false;
                boolean foundType = false;

                String nomProduit = ((EditText) findViewById(R.id.editNomProduit)).getText().toString();
                String descriptionProduit = ((EditText) findViewById(R.id.editDescriptionProduit)).getText().toString();
                String typeProduitString = ((EditText) findViewById(R.id.editTypeProduit)).getText().toString();
                String marqueProduitString = ((EditText) findViewById(R.id.editMarqueProduit)).getText().toString();
                String prix = ((EditText) findViewById(R.id.editPrixProduit)).getText().toString();

                Marque marqueProduit = null;
                List<Marque> marques = MarqueDAO.getMarques(UnknownScan.super.getParent(),MarqueDAO.sqlFindMarqueByNomMarque(marqueProduitString));
                for(Marque marque : marques){
                    if(marque.getNom_marque().equals(marqueProduitString)){
                        marqueProduit = marque;
                        foundMarque = true;
                    }
                }

                Type typeProduit = null;
                List<Type> types = TypeDAO.getTypes(UnknownScan.super.getParent(),TypeDAO.sqlGetAllTypes);
                for(Type type : types){
                    if(type.getNom_type().equals(typeProduitString)){
                        typeProduit = type;
                        foundType = true;
                    }
                }


                Produit produit = new Produit();
                produit.setNum_code_barres(barcode);
                produit.setNom_produit(nomProduit);
                produit.setDescription(descriptionProduit);
                if(foundMarque) {
                    produit.setFk_marque((int) marqueProduit.getId_marque());
                }
                if(foundType) {
                    produit.setFk_type((int) typeProduit.getId_type());
                }

                produit = ProduitDAO.insertProduit(produit);

                Enregistrement enregistrement = new Enregistrement(new Date(),Integer.parseInt(prix),(int) produit.getId_produit(),(int) utilisateurConnecte.getId_utilisateur());

                Enregistrement e = EnregistrementDAO.insertEnregistrement(enregistrement);

                Log.i("INFO","Enregistrement d'un enregistrement : " +e);
                Log.i("INFO","Enregistrement d'un produit : " + produit);


                Intent searchProduct = new Intent(getApplicationContext(),ScannerCodeBarres.class);
                searchProduct.putExtra("utilisateurConnecte",utilisateurConnecte);
                startActivity(searchProduct);
            }
        });
    }
}
