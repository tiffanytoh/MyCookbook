package com.example.tiffany.myapplication;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ListView lvRecipe;
    RecipeListAdapter adapter;
    List<Recipe> recipeList;
    SQLController sql;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        lvRecipe = (ListView) v.findViewById(R.id.list);

        try {
            sql = new SQLController(getContext());
            sql.open();
            Cursor cursor = sql.query("SELECT * FROM RecipeTable");

            RecipeListAdapter adapter = new RecipeListAdapter(getContext(), cursor);

            lvRecipe.setAdapter(adapter);
            sql.close();

        } catch (Exception e) {
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        return v;
    }

}
