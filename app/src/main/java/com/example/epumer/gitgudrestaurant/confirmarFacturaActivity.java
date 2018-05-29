package com.example.epumer.gitgudrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class confirmarFacturaActivity extends AppCompatActivity {
    private Button mEditButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_factura);
        mEditButton = (Button) findViewById(R.id.boto_EditButton);
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escoltadorIniciarComanda(v);
            }
        });
    }
    public void escoltadorIniciarComanda(View v) {
        Intent intent = new Intent(this, confirmarFacturaActivity.class);
        startActivity(intent);
    }
}
