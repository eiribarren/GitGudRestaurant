package com.example.epumer.gitgudrestaurant;

import android.widget.ImageView;

public class Plat {
    private String nom;
    private int idImagen;
    private float preu;
    private String ingredients;
    private String descripcio;
    private Tipus tipus;

    public enum Tipus {
        primer, segon, postre, beguda
    }

    public Plat ( String nom, float preu, Tipus tipus, int idImagen) {
        this.nom = nom;
        this.preu = preu;
        this.tipus = tipus;
        this.idImagen = idImagen;
    }

    public Plat ( String nom, float preu, Tipus tipus, int idImagen, String ingredients ) {
        this(nom,preu,tipus, idImagen);
        this.ingredients = ingredients;
    }

    public Plat ( String nom, float preu, Tipus tipus, int idImagen, String ingredients, String descripcio ) {
        this(nom,preu,tipus,idImagen,ingredients);
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

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
}
