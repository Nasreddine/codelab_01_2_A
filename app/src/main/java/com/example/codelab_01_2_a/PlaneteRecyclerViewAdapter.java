package com.example.codelab_01_2_a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlaneteRecyclerViewAdapter extends RecyclerView.Adapter<PlaneteViewHolder> {

    private ArrayList<Planete> planetes;

    public PlaneteRecyclerViewAdapter(ArrayList<Planete> planetes) {
        this.planetes = planetes;
    }

    @Override
    public PlaneteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_planete_item, parent, false);
        return new PlaneteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaneteViewHolder conteneur, int position) {
      conteneur.tv_nom.setText(planetes.get(position).getNom());
      conteneur.tv_taille.setText(planetes.get(position).getTaille());
    }

    @Override
    public int getItemCount() {
        return planetes.size();
    }
}