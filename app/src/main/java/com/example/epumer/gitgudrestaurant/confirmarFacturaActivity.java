package com.example.epumer.gitgudrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.epumer.gitgudrestaurant.comandaActivity.CLAU_EXTRA_PLATS;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class confirmarFacturaActivity extends AppCompatActivity {
    public final static String CLAU_EXTRA_PLATS_SELECCIONATS = "com.example.epumer.gitgudrestaurants.nomPlats";
    private Button mEditButton;
    private ArrayList<String> platsSeleccionats;
    private ArrayList<String> nomPlats;
    private Button mConfirmarButton;
    static float sumaTotal;
    static DecimalFormat df;
    private ImageView mLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        platsSeleccionats = intent.getStringArrayListExtra(CLAU_EXTRA_PLATS);
        nomPlats = new ArrayList<String>();
        setContentView(R.layout.activity_confirmar_factura);
        TableLayout tl = (TableLayout) findViewById(R.id.layout_factura);
        sumaTotal = 0;
        mLogo = (ImageView) findViewById(R.id.logo_factura);
        mLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escoltadorLogo(v);
            }
        });
        for(String p : platsSeleccionats){
            String[] datos = p.split(",");
            String nom = datos[0];

            String preu = datos[1];
            TextView tv = new TextView(this);
            TextView preu_tv = new TextView(this);
            tv.setText(nom);
            nomPlats.add(nom);
            tv.setMaxWidth((int) getResources().getDimension(R.dimen.max_width_descrip));
            tv.setMinWidth((int) getResources().getDimension(R.dimen.max_width_descrip));

            TableRow tr = new TableRow(this);

            tv.setTextSize(20);
            preu_tv.setTextSize(20);
            preu_tv.setText(preu + "€");

            sumaTotal += Float.parseFloat(preu);

            if(tv.getParent()!=null)
                ((ViewGroup)tv.getParent()).removeView(tv);
            if(preu_tv.getParent()!=null)
                ((ViewGroup)preu_tv.getParent()).removeView(preu_tv);
            tr.addView(tv);
            tr.addView(preu_tv);
            if(tr.getParent()!=null)
                ((ViewGroup)tr.getParent()).removeView(tr);
            tl.addView(tr);

        }
        df = new DecimalFormat("#.## €");
        mConfirmarButton = (Button) findViewById(R.id.boto_confirmar);
        mConfirmarButton.setText(df.format(sumaTotal));
        mEditButton = (Button) findViewById(R.id.boto_EditButton);
        mConfirmarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escoltadorConfirmar();
            }
        });
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escoltadorEditarComanda(v);
            }
        });
    }
    public void escoltadorConfirmar(){
        Toast.makeText(this,"S'han carregat " + df.format(sumaTotal) + " al teu compte corrent." ,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void escoltadorEditarComanda (View v) {
        Intent intent = new Intent(this, comandaActivity.class);
        intent.putExtra(CLAU_EXTRA_PLATS_SELECCIONATS,nomPlats);
        startActivity(intent);
    }
    private void escoltadorLogo(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
