package com.example.epumer.gitgudrestaurant;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Plat extends RelativeLayout implements View.OnClickListener, Parcelable {
    private String nom;
    private TextView preu;
    private ImageView imagen;
    private String ingredients;
    private String descripcio;
    private Tipus tipus;
    private boolean seleccionado;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nom);
    }

    public enum Tipus {
        primer, segon, postre, beguda
    }

    public Plat ( Context context, String nom, float preu, Tipus tipus, int idImagen ) {
        super(context);
        this.nom = nom;
        this.tipus = tipus;
        this.preu = new TextView(context);
        this.preu.setText(String.valueOf(preu) + "€");
        this.preu.setPadding(5,5,5,5);
        this.preu.setTextColor(context.getResources().getColor(R.color.colorPrecio));
        this.preu.setBackgroundColor(context.getResources().getColor(R.color.sombra));
        this.imagen = new ImageView(context);
        this.imagen.setImageDrawable(context.getResources().getDrawable(idImagen));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.imageview_width),(int) getResources().getDimension(R.dimen.imageview_height));
        this.imagen.setLayoutParams(lp);
        this.addView(this.preu);
        this.addView(this.imagen);
    }

    public Plat(Parcel source) {
        prevName =
    }

    public Plat ( Context context, String nom, float preu, Tipus tipus, int idImagen, String ingredients ) {
        this(context,nom,preu,tipus, idImagen);
        this.ingredients = ingredients;
    }

    public Plat ( Context context, String nom, float preu, Tipus tipus, int idImagen, String ingredients, String descripcio ) {
        this(context, nom,preu,tipus, idImagen, ingredients);
        this.descripcio = descripcio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public void seleccionar() { this.seleccionado = true; setBackgroundColor(getResources().getColor(R.color.seleccionado)); }

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
    public static final Parcelable.Creator<Plat> CREATOR  =  new Parcelable.Creator<Plat>() {
        public Plat createFromParcel(Parcel in) {
            return new Plat (in);
        }
        public Plat [] newArray(int size) {
            return new Plat [size];
        }
    };

}
