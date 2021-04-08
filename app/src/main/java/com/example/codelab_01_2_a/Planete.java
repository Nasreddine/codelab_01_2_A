package com.example.codelab_01_2_a;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Planete {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "name")
    private String nom;

    @ColumnInfo(name = "size")
    private String taille;

    Planete(String nom, String taille){
        this.nom = nom;
        this.taille = taille;
    }

    public String getNom() {
        return nom;
    }

    public String getTaille() {
        return taille;
    }

}