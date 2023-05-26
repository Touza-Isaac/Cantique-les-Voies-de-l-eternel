package com.sintel.lesvoiesdeleternel;

import static android.content.Context.MODE_PRIVATE;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashSet;
import java.util.Set;

public class CantiqueActivity extends AppCompatActivity {

    String [] Titre, ContenuCantique, AuteursCantique ;
    Button btn;
    EditText NumeroCantique;
    TextView titre, contenu, auteur;
    int size_texte_cantique=19;
    int size_title=24;
    int nbre_zoom=1;
    public static int position;
    SharedPreferences sharedPreferences;
    private Set<String> liste_favoris = new HashSet<String>();
    BottomNavigationView bottomNavigationView;
    Menu menu;
    private Handler handler=new Handler();
    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantique);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_cantique);
        sharedPreferences = getSharedPreferences("com.sintel.lesvoiesdeleternel", MODE_PRIVATE);
        liste_favoris = sharedPreferences.getStringSet("liste_favoris",  new HashSet<String>());

        btn=findViewById(R.id.Idbutton);

        ImageView imageView = findViewById(R.id.share);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PartagerCantique("*****************Chant N°" +(position+1)+"*****************\n \n"+contenu.getText().toString()+"\n"+"------------------------------------------------------\n"+"Partager depuis l'application LES VOIES DE L'ETERNEL ");
            }
        });
        ContenuCantique = getResources().getStringArray(R.array.ContenuCantique);
        Titre=getResources().getStringArray(R.array.titreCantique);
        AuteursCantique = getResources().getStringArray(R.array.noms_auteurs);
        NumeroCantique = findViewById(R.id.IdEditText);

        //on recupere le numero de la recherche
        position = getIntent().getIntExtra("position", 1);

        //on recupere le numero puis on ecrit dans la zone de recherche
        int num = getIntent().getIntExtra("numero", 115);
        if (num <= 115 && num >0){
            NumeroCantique.setText("");
        }

        bottomNavigationView=findViewById(R.id.bottom_navigation2);
        menu= bottomNavigationView.getMenu();

        if(liste_favoris.contains(""+position)){
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_baseline_favorite_24));
        }


        if (position <= 115) {
            AfficherCantique(position);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifier_numero();
                if(liste_favoris.contains(""+position)){
                    menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_baseline_favorite_24));
                }else{
                    menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_baseline_favorite_border_24));
                }

                NumeroCantique.setText("");
            }
        });

    }

    public  void AfficherCantique(int NumeroCantique){
        titre = findViewById(R.id.Numerocantique);
        contenu = findViewById(R.id.TexteCantique);
        auteur= findViewById(R.id.AuteurCantique);

        String text = ContenuCantique[NumeroCantique];
        String title = Titre[NumeroCantique];
        String author = AuteursCantique[NumeroCantique];
        titre.setText(NumeroCantique+1+"\n"+title);
        contenu.setText(text);
        auteur.setText(author);
    }

    private void PartagerCantique(String s) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, s);
        startActivity(intent);
    }

    private void verifier_numero(){
        int num = 1;
        try {
            num = Integer.parseInt(NumeroCantique.getText().toString());
        } catch (Exception e) {
            new AlertDialog.Builder(CantiqueActivity.this)
                    .setTitle("Numero incorrect")
                    .setMessage("Entrer un numero compris entre 1 et 115")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
            return;
        }

        if (0 < num && num < 116) {
            position=num-1;
            AfficherCantique(position);
        }
        else {
            new AlertDialog.Builder(CantiqueActivity.this)
                    .setTitle("Numero incorrect")
                    .setMessage("Entrer un numero compris entre 1 et 115")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).show();
        }
    }

    public void AfficherCantiquePrecedent(MenuItem item) {

        if (position>0) {
            AfficherCantique(position-1);
            position--;
        }
        else {
            Toast.makeText(CantiqueActivity.this, "Vous avez atteint le numero minimal", Toast.LENGTH_SHORT).show();
        }

        if(liste_favoris.contains(""+position)){
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_baseline_favorite_24));
        }else{
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_baseline_favorite_border_24));
        }
        NumeroCantique.setText("");
    }


    public void AfficherCantiqueSuivant(MenuItem item) {

        if (position==114){
            Toast.makeText(CantiqueActivity.this, "Vous avez atteint le numero maximal", Toast.LENGTH_SHORT).show();
        }
        else{
            AfficherCantique(position+1);
            position++;
        }

        if(liste_favoris.contains(""+position)){
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_baseline_favorite_24));
        }else{
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_baseline_favorite_border_24));
        }
        NumeroCantique.setText("");
    }

    public void AgrandirTexte(MenuItem item) {
        if (nbre_zoom<=20) {
            TextView textView = findViewById(R.id.TexteCantique);
            TextView title = findViewById(R.id.Numerocantique);
            title.setTextSize(size_title+1);
            textView.setTextSize(size_texte_cantique + 1);
            size_texte_cantique++;
            size_title++;
            nbre_zoom++;
        }
    }

    public void AjouterFavoris(MenuItem item) {
        if(liste_favoris.contains(""+position)){
            liste_favoris.remove(""+position);
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_baseline_favorite_border_24));
            Toast.makeText(this, "Cantique retiré de la liste des favoris", Toast.LENGTH_SHORT).show();
        }else{
            liste_favoris.add(""+position);
            menu.findItem(R.id.favoris).setIcon(getResources().getDrawable(R.drawable.ic_baseline_favorite_24));
            Toast.makeText(this, "Cantique ajouté à la liste des favoris", Toast.LENGTH_SHORT).show();
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("liste_favoris", liste_favoris);
        editor.apply();
    }

    public void ReduireTexte(MenuItem item) {
        if(nbre_zoom>=1) {
            TextView textView = findViewById(R.id.TexteCantique);
            TextView title = findViewById(R.id.Numerocantique);
            title.setTextSize(size_title-1);
            textView.setTextSize(size_texte_cantique - 1);
            size_texte_cantique--;
            size_title--;
            nbre_zoom--;
        }
    }

}