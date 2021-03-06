package com.example.epumer.gitgudrestaurant;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Plat extends RelativeLayout implements View.OnClickListener {

    private String nom;
    private float preu;
    private TextView preuTextView;
    private ImageView imagen;
    private String ingredients;
    private String descripcio;
    private Tipus tipus;
    private boolean seleccionado;

    public enum Tipus {
        primer, segon, postre, beguda
    }


    public Plat (Context context, String nom, float preu, Tipus tipus, int idImagen ) {
        super(context);
        this.nom = nom;
        this.tipus = tipus;
        this.preu = preu;
        this.preuTextView = new TextView(context);
        this.preuTextView.setText(String.valueOf(preu) + "€");
        this.preuTextView.setPadding(5, 5, 5, 5);
        this.preuTextView.setTextColor(context.getResources().getColor(R.color.colorPrecio));
        this.preuTextView.setBackgroundColor(context.getResources().getColor(R.color.sombra));
        this.imagen = new ImageView(context);
        this.imagen.setImageDrawable(context.getResources().getDrawable(idImagen));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.imageview_width), (int) getResources().getDimension(R.dimen.imageview_height));
        this.imagen.setLayoutParams(lp);
        this.addView(this.imagen);
        this.addView(this.preuTextView);
    }

    public Plat (Context context, String nom, float preuTextView, Tipus tipus, int idImagen, String ingredients ) {
        this(context,nom, preuTextView,tipus, idImagen);
        this.ingredients = ingredients;
    }

    public Plat (Context context, String nom, float preuTextView, Tipus tipus, int idImagen, String ingredients, String descripcio ) {
        this(context, nom, preuTextView,tipus, idImagen, ingredients);
        this.descripcio = descripcio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Tipus getTipus() {
        return tipus;
    }

    public void setTipus(Tipus tipus) {
        this.tipus = tipus;
    }

    public void seleccionar() { this.seleccionado = true; Toast.makeText(getContext(), "Has seleccionat el plat " + this.getNom(), Toast.LENGTH_SHORT).show(); setBackgroundColor(getResources().getColor(R.color.seleccionado)); }

    public void deseleccionar() { this.seleccionado = false; setBackgroundColor(getResources().getColor(R.color.colorPantallaPrincipal)); }

    public boolean estaSeleccionado() { return this.seleccionado; }

    @Override
    public void onClick(View v) {
        if ( estaSeleccionado() ) {
            deseleccionar();
        } else {
            seleccionar();
        }
    }


}
