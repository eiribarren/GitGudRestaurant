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
                new Plat(this, "Patatas rellenas de jamón y queso",2.99f,Plat.Tipus.primer, R.drawable.patatas_rellenas )
        };
        for ( Plat mPlat : mPlatsBank ) {
            switch(mPlat.getTipus()) {
                case primer:
                    afegirPlat( mPlat, (LinearLayout) findViewById(R.id.primers));
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

    private void afegirPlat(Plat mPlat, LinearLayout ll) {
        mPlat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(getResources().getColor(R.color.seleccionado));
            }
        });
        ll.addView(mPlat);
    }
}
