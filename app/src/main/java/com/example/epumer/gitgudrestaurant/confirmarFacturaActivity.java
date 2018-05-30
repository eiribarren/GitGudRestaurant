package com.example.epumer.gitgudrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static com.example.epumer.gitgudrestaurant.comandaActivity.CLAU_EXTRA_PLATS;
import java.util.ArrayList;


public class confirmarFacturaActivity extends AppCompatActivity {
    public final static String CLAU_EXTRA_PLATS_SELECCIONATS = "com.example.epumer.gitgudrestaurants.platsSeleccionats";
    private Button mEditButton;
    private ArrayList<Plat> platsSeleccionats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent= getIntent();
        platsSeleccionats = intent.getParcelableArrayListExtra(CLAU_EXTRA_PLATS);
        setContentView(R.layout.activity_confirmar_factura);
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
        intent.putExtra(CLAU_EXTRA_PLATS_SELECCIONATS,platsSeleccionats);
        startActivity(intent);
    }
}
