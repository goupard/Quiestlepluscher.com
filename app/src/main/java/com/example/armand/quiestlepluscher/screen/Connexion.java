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
import com.example.armand.quiestlepluscher.entities.Categorie;
import com.example.armand.quiestlepluscher.entities.Marque;
import com.example.armand.quiestlepluscher.entities.Type;
import com.example.armand.quiestlepluscher.entities.Utilisateur;
import com.example.armand.quiestlepluscher.room.AppDatabase;
import com.example.armand.quiestlepluscher.tools.Md5Getter;
import com.example.armand.quiestlepluscher.views.Welcome_Screen;

/**
 * Created by armand on 25/06/2018.
 */

public class Connexion extends AppCompatActivity {


    //private static MySQLDataBase mysqlDatabase;
    private AppDatabase appDatabase;

    private static Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appDatabase = AppDatabase.getAppDatabase(this);

        Marque marque = new Marque();
        marque.setDescription("");
        marque.setLoc_logo("");
        marque.setNom_marque("");
        appDatabase.marqueDao().insertAll(marque);

        Categorie categorie = new Categorie();
        categorie.setDescription("");
        categorie.setNom_categorie("");

        appDatabase.categorieDao().insertAll(categorie);

        categorie = appDatabase.categorieDao().getAll().get(0);

        Type type = new Type();
        type.setDescription("");
        type.setNom_type("");
        type.setFk_categorie((int)categorie.getId_categorie());
        appDatabase.typeDao().insertAll(type);
        //mysqlDatabase = new MySQLDataBase(this);
        bundle = savedInstanceState;

        setContentView(R.layout.activity_connexion__screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button buttonInscription = (Button) findViewById(R.id.buttonCreationCompteConnexion);
        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creationCompteIntent = new Intent(getApplicationContext(),Inscription.class);
                startActivity(creationCompteIntent);
            }
        });

        Button button = (Button) findViewById(R.id.buttonConnexion);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ((EditText) findViewById(R.id.editTextEmailConnexion)).getText().toString();
                String motDePasse = ((EditText) findViewById(R.id.editTextMotDePasseConnexion)).getText().toString();

                if(email.isEmpty() || motDePasse.isEmpty()){
                    Toast.makeText(Connexion.this, "Les champs ne peuvent être vides.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //List<Utilisateur> utilisateurs = UtilisateurDAO.getUtilisateurs(Connexion.super.getParent(),UtilisateurDAO.sqlFindUserByLogin(email));
                Utilisateur utilisateur = appDatabase.userDao().findByLogin(email);


                if(utilisateur == null){
                    Toast.makeText(Connexion.this, "Email non reconnu.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String hashedPass = utilisateur.getHashed_password();
                if(!Md5Getter.md5(motDePasse).equals(hashedPass)){
                    Toast.makeText(Connexion.this, "Les mots de passe ne correspondent pas.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent welcomScreen = new Intent(getApplicationContext(),Welcome_Screen.class);
                welcomScreen.putExtra("utilisateurConnecte",utilisateur);
                startActivity(welcomScreen);
            }
        });
    }

    /*public static MySQLDataBase getMysqlDatabase() {
        return mysqlDatabase;
    }*/

    public AppDatabase getAppDatabase(){
        return appDatabase;
    }

    public static Bundle getBundle() {
        return bundle;
    }
}
