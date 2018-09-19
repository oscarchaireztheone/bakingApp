package com.example.android.bakingapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android.bakingapp.utilities.AsyncTasks;
import com.example.android.bakingapp.utilities.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListAdapter.MyListener{
    public ArrayList mRecipeList;
    public ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize the recipe list
        mRecipeList = new ArrayList<>();
        //Start the asyncTask
        URL url = NetworkUtils.buildUrl();
        new AsyncTasks(this).execute(url);


    }
    public void loadFragment(){
        //make the adapter
        adapter = new ListAdapter(mRecipeList);
        adapter.setCustomListener(this);
        Log.v("OnCreate", Integer.toString(mRecipeList.size()));
        //create the fragment
        MasterListFragment recipeListFragment = MasterListFragment.newInstance(mRecipeList);
        //start up the fragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //start the transaction
        fragmentManager.beginTransaction()
                .add(R.id.recipe_container, recipeListFragment)
                .commit();

    }

    @Override
    public void itemClicked(int position) {
        Log.v("Listener", Integer.toString(position));
        Toast toast = Toast.makeText(this,"Congrats", Toast.LENGTH_SHORT);
        toast.show();
    }
}
