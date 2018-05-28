package com.example.epumer.gitgudrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class comandaActivity extends AppCompatActivity {

    private Plat[] mPlatsBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comanda);
        mPlatsBank = new Plat[] {
                new Plat(this, "Arroz al minecraft",3.99f,Plat.Tipus.primer, R.drawable.plato1 ),
                new Plat(this, "Patates farcides",2.99f,Plat.Tipus.primer, R.drawable.patatas_rellenas ),
                new Plat(this,"Albóndiga de sepia con gambón", 5.99f, Plat.Tipus.segon, R.drawable.albondiga_gambon),
                new Plat(this,"Tarta de sorra", 1.99f, Plat.Tipus.postre, R.drawable.tarta_de_sorra),
                new Plat(this, "Got d'aigua", 0.90f, Plat.Tipus.beguda, R.drawable.got_aigua)
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
    }

    private void afegirPlat(Plat mPlat, LinearLayout ll) {
        mPlat.setOnClickListener(mPlat);
        ll.addView(mPlat);
    }
}
