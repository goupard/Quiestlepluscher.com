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
import com.example.armand.quiestlepluscher.entities.Enregistrement;
import com.example.armand.quiestlepluscher.entities.Marque;
import com.example.armand.quiestlepluscher.entities.Produit;
import com.example.armand.quiestlepluscher.entities.Type;
import com.example.armand.quiestlepluscher.entities.Utilisateur;
import com.example.armand.quiestlepluscher.room.AppDatabase;

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
        final AppDatabase appDatabase = AppDatabase.getAppDatabase(this);
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
                if(!marqueProduitString.isEmpty()) {
                    Marque marque = appDatabase.marqueDao().findByNom(marqueProduitString);
                    if (marque != null) {
                        marqueProduit = marque;
                        foundMarque = true;
                    }
                }
                Type typeProduit = null;
                if(!typeProduitString.isEmpty()) {
                    List<Type> types = appDatabase.typeDao().getAll();
                    for (Type type : types) {
                        if (type.getNom_type().equals(typeProduitString)) {
                            typeProduit = type;
                            foundType = true;
                        }
                    }
                }


                Produit produit = new Produit();
                produit.setNum_code_barres(barcode);
                produit.setNom_produit(nomProduit);
                produit.setDescription(descriptionProduit);
                produit.setFk_type(0); //Ajoute un type vide
                produit.setFk_marque(0); // ajoute une marque vide
                if(foundMarque) {
                    produit.setFk_marque((int) marqueProduit.getId_marque());
                }
                if(foundType) {
                    produit.setFk_type((int) typeProduit.getId_type());
                }

                //produit = ProduitDAO.insertProduit(produit);
                appDatabase.produitDao().insertAll(produit);

                Enregistrement enregistrement = new Enregistrement();
                enregistrement.setDate((int)System.currentTimeMillis());
                enregistrement.setPrix(Integer.parseInt(prix));
                enregistrement.setFk_produit((int) produit.getId_produit());
                enregistrement.setFk_utilisateur((int) utilisateurConnecte.getId_utilisateur());

                //Enregistrement e = EnregistrementDAO.insertEnregistrement(enregistrement);
                appDatabase.enregistrementDao().insertAll(enregistrement);

                Log.i("INFO","Enregistrement d'un enregistrement : " + enregistrement);
                Log.i("INFO","Enregistrement d'un produit : " + produit);


                Intent searchProduct = new Intent(getApplicationContext(),ScannerCodeBarres.class);
                searchProduct.putExtra("utilisateurConnecte",utilisateurConnecte);
                startActivity(searchProduct);
            }
        });
    }
}
