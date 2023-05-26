package com.sintel.lesvoiesdeleternel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText NumeroCantique;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

        NumeroCantique = findViewById(R.id.EditText);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        NumeroCantique.clearFocus();

        btn=findViewById(R.id.Idbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = 1;
                try {
                    num = Integer.parseInt(NumeroCantique.getText().toString());
                }catch (Exception e){
                    new AlertDialog.Builder(MainActivity.this)
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

                if (0 < num  && num < 116 ) {
                    Intent intent = new Intent(MainActivity.this,CantiqueActivity.class);
                    intent.putExtra("position",num-1);
                    startActivity(intent);
                    //finish();
                }

                else {
                    new AlertDialog.Builder(MainActivity.this)
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
        });
    }

    public void OuvrirSommaire(View view) {
        startActivity(new Intent(this,SommaireActivity.class));
    }
    public void OuvrirApropos(View view) {
        startActivity(new Intent(this,AproposActivity.class));
    }
    public void OuvrirFavoris(View view) {
        startActivity(new Intent(this,FavorisActivity.class));
    }

    public void OuvrirListeCantique(View view) {
        startActivity(new Intent(this,ListeCantiquesActivity.class));
    }
}