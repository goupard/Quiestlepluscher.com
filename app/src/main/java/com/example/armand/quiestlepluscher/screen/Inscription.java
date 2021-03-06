package com.example.armand.quiestlepluscher.screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.armand.quiestlepluscher.R;
import com.example.armand.quiestlepluscher.entities.Utilisateur;
import com.example.armand.quiestlepluscher.room.AppDatabase;
import com.example.armand.quiestlepluscher.tools.Md5Getter;
import com.example.armand.quiestlepluscher.views.Welcome_Screen;

import java.util.List;

/**
 * Created by armand on 15/06/2018.
 */

public class Inscription extends AppCompatActivity {

    private Utilisateur nouvelInscrit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final AppDatabase appDatabase = AppDatabase.getAppDatabase(this);

        setContentView(R.layout.activity_inscription__screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button) findViewById(R.id.buttonConfirmerInscription);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();
                String confirmation = ((EditText) findViewById(R.id.editTextConfirmation)).getText().toString();
                String nom = ((EditText) findViewById(R.id.editTextNom)).getText().toString();
                String prenom = ((EditText) findViewById(R.id.editTextPrenom)).getText().toString();
                String email = ((EditText) findViewById(R.id.editTextEmail)).getText().toString();

                if(password.isEmpty() || confirmation.isEmpty() || nom.isEmpty() || prenom.isEmpty() || email.isEmpty()){
                    Toast.makeText(Inscription.this, "Les champs ne peuvent être vides.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!password.equals(confirmation)){
                    Toast.makeText(Inscription.this, "Les mots de passes ne correspondent pas.", Toast.LENGTH_SHORT).show();
                    return;
                }


                //List<Utilisateur> userFromLogin = UtilisateurDAO.getUtilisateurs(Inscription.super.getParent(),UtilisateurDAO.sqlFindUserByLogin(email));
                Utilisateur utilisateur = appDatabase.userDao().findByLogin(email);


                if(utilisateur != null){
                    Toast.makeText(Inscription.this, "Email déjà utilisé.", Toast.LENGTH_SHORT).show();
                    return;
                }

                nouvelInscrit = new Utilisateur();
                nouvelInscrit.setLogin(email);
                nouvelInscrit.setPrenom(prenom);
                nouvelInscrit.setNom(nom);
                String hash = Md5Getter.md5(password);
                nouvelInscrit.setHashed_password(hash);
                nouvelInscrit.setEmail(email);
                appDatabase.userDao().insertAll(nouvelInscrit);
                Intent welcomScreen = new Intent(getApplicationContext(),Welcome_Screen.class);
                welcomScreen.putExtra("utilisateurConnecte",nouvelInscrit);
                startActivity(welcomScreen);
            }
        });
    }


}
