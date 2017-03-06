package com.example.tiffany.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Tiffany on 04-Mar-17.
 */

public class AddNewRecipe extends AppCompatActivity {
    private TextView recipeTitle;
    private TextView recipeDetails;
    private EditText enterTitle;
    private EditText enterDetails;
    private Button done;
    private String recipe, details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnew_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recipeTitle = (TextView) findViewById(R.id.recipe_title);
        recipeDetails = (TextView) findViewById(R.id.recipe_details);
        enterTitle = (EditText) findViewById(R.id.enter_title);
        enterDetails = (EditText) findViewById(R.id.enter_details);

        done = (Button) findViewById(R.id.button_done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEntry();
                Intent intent = new Intent(AddNewRecipe.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }


    public void addEntry() {
        try {

            recipe = enterTitle.getText().toString();


            details = enterDetails.getText().toString();


            SQLController newEntry = new SQLController(this);

            try {
                if (recipe.matches("")) {
                    Toast.makeText(this, "Please enter title", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    newEntry.open();

                    newEntry.createEntry(recipe, details);
                    newEntry.close();

                    Toast.makeText(this, "Content added", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

}

