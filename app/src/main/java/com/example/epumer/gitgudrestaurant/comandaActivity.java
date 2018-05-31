package com.example.epumer.gitgudrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import static com.example.epumer.gitgudrestaurant.confirmarFacturaActivity.CLAU_EXTRA_PLATS_SELECCIONATS;

public class comandaActivity extends AppCompatActivity {
    public final static String CLAU_EXTRA_PLATS = "com.example.epumer.gitgudrestaurants.platosDelMenuDelUsuario";
    public ArrayList<String> platosDelMenuDelUsuario;
    private Plat[] mPlatsBank;
    private Button mConfirmarButton;
    private ArrayList<String> platsSeleccionats;
    private ImageView mLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent= getIntent();
        platsSeleccionats = intent.getStringArrayListExtra(CLAU_EXTRA_PLATS_SELECCIONATS);
        setContentView(R.layout.activity_comanda);
        mLogo = (ImageView) findViewById(R.id.logo);
        mLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escoltadorLogo(v);
            }
        });
        mPlatsBank = new Plat[] {
                new Plat(this, "Arroz al minecraft",3.99f,Plat.Tipus.primer, R.drawable.plato1 ),
                new Plat(this, "Patates farcides",2.99f,Plat.Tipus.primer, R.drawable.patatas_rellenas ),
                new Plat(this, "Vichyssoise", 2.99f, Plat.Tipus.primer, R.drawable.vichyssoise),
                new Plat(this,"Albóndiga de sepia con gambón", 5.99f, Plat.Tipus.segon, R.drawable.albondiga_gambon),
                new Plat(this, "Entrecot amb patates", 9.99f, Plat.Tipus.segon, R.drawable.entrecot),
                new Plat(this, "Hamburguesas de mar", 5.50f, Plat.Tipus.segon, R.drawable.hamburguesas_mar),
                new Plat(this,"Torta",1.99f, Plat.Tipus.postre,R.drawable.torta),
                new Plat(this,"Tarta de sorra", 1.99f, Plat.Tipus.postre, R.drawable.tarta_de_sorra),
                new Plat(this,"Dulce manjar",2.50f,Plat.Tipus.postre, R.drawable.dulce_manjar),
                new Plat(this, "Got d'aigua", 0.90f, Plat.Tipus.beguda, R.drawable.got_aigua),
                new Plat(this,"Got de llet",1.20f,Plat.Tipus.beguda, R.drawable.leche),
                new Plat(this, "Got de suc de taronja",1.20f,Plat.Tipus.beguda,R.drawable.zumo_naranja)
        };
        for ( Plat mPlat : mPlatsBank ) {
            switch(mPlat.getTipus()) {
                case primer:
                    afegirPlat( mPlat, (LinearLayout) findViewById(R.id.primers));
                    break;
                case segon:
                    afegirPlat( mPlat, (LinearLayout) findViewById(R.id.segons));
                    break;
                case postre:
                    afegirPlat( mPlat, (LinearLayout) findViewById(R.id.postres));
                    break;
                case beguda:
                    afegirPlat( mPlat, (LinearLayout) findViewById(R.id.begudes));
                    break;
            }
        }
         if ( platsSeleccionats != null ) {
            for ( String platSeleccionat : platsSeleccionats ) {
                for ( Plat mPlat : mPlatsBank ) {
                    if ( platSeleccionat.equals(mPlat.getNom()) ) {
                        mPlat.seleccionar();
                    }
                }
            }
        }
        mConfirmarButton = (Button) findViewById(R.id.finalitzar);
        mConfirmarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escoltadorFinalitzarComanda(v);
            }
        });
    }

    private void afegirPlat(Plat mPlat, LinearLayout ll) {
        mPlat.setOnClickListener(mPlat);
        ll.addView(mPlat);
    }

    private void escoltadorFinalitzarComanda(View v) {
        platosDelMenuDelUsuario = new ArrayList<String>();
        Intent intent = new Intent(this, confirmarFacturaActivity.class);
        for ( Plat mPlat : mPlatsBank ) {
            if ( mPlat.estaSeleccionado() ) {
                platosDelMenuDelUsuario.add(mPlat.getNom() + "," + mPlat.getPreu());
            }
        }
        intent.putExtra(CLAU_EXTRA_PLATS, platosDelMenuDelUsuario);

        startActivity(intent);
    }

    private void escoltadorLogo(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
