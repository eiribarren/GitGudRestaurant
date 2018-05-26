package com.example.epumer.gitgudrestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class comandaActivity extends AppCompatActivity {

    private Plat[] mPlatsBank = new Plat[] {
            new Plat("Arroz al minecraft",20.99f,Plat.Tipus.primer, R.drawable.plato1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comanda);
        for ( Plat mPlat : mPlatsBank ) {
            switch(mPlat.getTipus()) {
                case primer:
                    ImageView imagen = new ImageView(this);
                    imagen.setImageDrawable(getDrawable(mPlat.getIdImagen()));
                    LinearLayout ll = (LinearLayout) findViewById(R.id.primers);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.imageview_width),(int) getResources().getDimension(R.dimen.imageview_height));
                    imagen.setLayoutParams(lp);
                    ll.addView(imagen);
                    break;
                case segon:
                    break;
                case postre:
                    break;
                case beguda:
                    break;

            }
        }
    }
}
