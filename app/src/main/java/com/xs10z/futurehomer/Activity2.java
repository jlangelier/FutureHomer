package com.xs10z.futurehomer;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.xs10z.futurehomer.databinding.Activity2Binding;

public class Activity2 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private Activity2Binding binding;

    DatabaseHelper myDb;
    EditText etDescription, etCompletionDate;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = Activity2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_2);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);



        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        myDb = new DatabaseHelper(this);

        etDescription = (EditText) findViewById(R.id.etName);
        etCompletionDate = (EditText) findViewById(R.id.etCompletionDate);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        AddData();

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_2);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void AddData() {
        btnAdd.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {

                        boolean isInserted = myDb.insertData(etDescription.getText().toString(),
                                            etCompletionDate.getText().toString());

                        if (isInserted = true) {
                            Toast.makeText(Activity2.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(Activity2.this, "Data NOT Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}