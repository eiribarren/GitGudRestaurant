package com.example.epumer.gitgudrestaurant;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.epumer.gitgudrestaurant.comandaActivity.CLAU_EXTRA_PLATS;
import java.util.ArrayList;


public class confirmarFacturaActivity extends AppCompatActivity {
    public final static String CLAU_EXTRA_PLATS_SELECCIONATS = "com.example.epumer.gitgudrestaurants.nomPlats";
    private Button mEditButton;
    private ArrayList<String> platsSeleccionats;
    private ArrayList<String> nomPlats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        platsSeleccionats = intent.getStringArrayListExtra(CLAU_EXTRA_PLATS);
        nomPlats = new ArrayList<String>();
        setContentView(R.layout.activity_confirmar_factura);
        LinearLayout ll = (LinearLayout)findViewById(R.id.Factura);
        LinearLayout ll_preus = (LinearLayout)findViewById(R.id.Factura_preus);
        for(String p : platsSeleccionats){
            String[] datos = p.split(",");
            String nom = datos[0];
            nomPlats.add(nom);
            String preu = datos[1];
            TextView tv = new TextView(this);
            TextView preu_tv = new TextView(this);
            tv.setText(nom);
            preu_tv.setText(preu + "€");
            if(tv.getParent()!=null)
                ((ViewGroup)tv.getParent()).removeView(tv);
            if(preu_tv.getParent()!=null)
                ((ViewGroup)preu_tv.getParent()).removeView(preu_tv);
            ll.addView(tv);
            ll_preus.addView(preu_tv);

        }
        mEditButton = (Button) findViewById(R.id.boto_EditButton);
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escoltadorEditarComanda(v);
            }
        });
    }

    public void escoltadorEditarComanda (View v) {
        Intent intent = new Intent(this, comandaActivity.class);
        intent.putExtra(CLAU_EXTRA_PLATS_SELECCIONATS,nomPlats);
        startActivity(intent);
    }
}
