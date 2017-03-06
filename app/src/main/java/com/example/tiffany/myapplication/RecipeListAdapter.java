package com.example.tiffany.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Tiffany on 04-Mar-17.
 */

public class RecipeListAdapter extends CursorAdapter {


    public RecipeListAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.recipe_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        View v = View.inflate(context, R.layout.recipe_layout, null);
        TextView recipeTxt = (TextView) view.findViewById(R.id.tv_recipeDisplay);
        TextView detailTxt = (TextView) view.findViewById(R.id.tv_detailsDisplay);
        //CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkbox);

        String recipe = cursor.getString(cursor.getColumnIndexOrThrow("_recipe"));
        String details = cursor.getString(cursor.getColumnIndexOrThrow("_details"));

        recipeTxt.setText(recipe);
        detailTxt.setText(details);

    }
}