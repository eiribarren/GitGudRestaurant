package com.example.epumer.gitgudrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mIniciarComanda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIniciarComanda = (Button) findViewById(R.id.boto_comanda);
        mIniciarComanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escoltadorIniciarComanda(v);
            }
        });
    }

    public void escoltadorIniciarComanda(View v) {
        Intent intent = new Intent(this, comandaActivity.class);
        startActivity(intent);
    }
}