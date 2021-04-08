package com.example.codelab_01_2_a;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PlaneteViewHolder extends RecyclerView.ViewHolder {
    TextView tv_nom;
    TextView tv_taille;

    public PlaneteViewHolder(View itemView) {
        super(itemView);
        tv_nom = (TextView) itemView.findViewById(R.id.tv_nom);
        tv_taille = (TextView) itemView.findViewById(R.id.tv_taille);
    }
}
