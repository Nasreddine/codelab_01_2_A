package com.example.codelab_01_2_a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

/* ref https://androidtutos.com/collapsing-toolbar/*/


// Exercices:
// 1. avec fragment ajouter une planete à la liste
// 2. supprimer avec un boutton menu une planete selectionnée

public class CoordinatorActivity extends AppCompatActivity {

    private RecyclerView planetesRecyclerView;
    private PlaneteRecyclerViewAdapter planetesAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    final String PREFS_NAME = "preferences_file";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        collapsingToolbarLayout = findViewById(R.id.collapseLayout);
        collapsingToolbarLayout.setTitle("Planetes");

        FloatingActionButton fab = findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Message", Snackbar.LENGTH_LONG).show();
            }
        });

        initDatabase();

        planetesRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        planetesRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        planetesRecyclerView.setLayoutManager(mLayoutManager);
        planetesAdapter = new PlaneteRecyclerViewAdapter(getDataSource());
        planetesRecyclerView.setAdapter(planetesAdapter);

    }

    private void initDatabase() {

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "planetesDB").allowMainThreadQueries().build();


        if (settings.getBoolean("is_data_loaded", false)) {



            settings.edit().putBoolean("my_first_time", true).commit();
        } else {

        }



        PlaneteDao planeteDao = db.planeteDao();
        Planete planete = new Planete("my planete","100");
        //planeteDao.insertAll(planete);
        List<Planete> planetes = planeteDao.getAll();

        Toast.makeText(this, "->" + planetes.size(), Toast.LENGTH_SHORT).show();


    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private ArrayList<Planete> getDataSource() {

        ArrayList<String> nomPlanetes = new ArrayList<String>();

        nomPlanetes.add("Mercure");
        nomPlanetes.add("Venus");
        nomPlanetes.add("Terre");
        nomPlanetes.add("Mars");
        nomPlanetes.add("Jupiter");
        nomPlanetes.add("Saturne");
        nomPlanetes.add("Uranus");
        nomPlanetes.add("Neptune");
        nomPlanetes.add("Pluton");

        String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};

        ArrayList planetes = new ArrayList<Planete>();
        for (int index = 0; index < nomPlanetes.size(); index++) {
            Planete planete = new Planete(nomPlanetes.get(index), taillePlanetes[index]);
            planetes.add(index, planete);
        }
        return planetes;
    }
}