package com.example.android.bakingapp.utilities;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.android.bakingapp.ListAdapter;
import com.example.android.bakingapp.MainActivity;
import com.example.android.bakingapp.model.Recipe;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AsyncTasks extends AsyncTask<URL, Void, String> {
    public ArrayList recipeList;
    private Context context;

    public AsyncTasks(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(URL... params) {
        Log.v("Do in backGround Url", String.valueOf(params[0]));
        if (params[0] != null) {
            URL searchUrl = params[0];
            String searchResults = null;

            try {
                searchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return searchResults;
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        recipeList = new ArrayList<>();


        if (s != null && !s.equals("")) {
            recipeList = JsonUtils.parseRecipeJson(s);
            Log.v("inPostExecute&&&&&", Integer.toString(recipeList.size()));
            //remove the following because we need to return the results of this async task to the calling activity
//            mListAdapter = new ListAdapter(mRecipeList );
            //this to need to be removed becaseu it will be called in the activity
           // mRv.setAdapter(mListAdapter);
            MainActivity activity = (MainActivity) context;
            activity.mRecipeList = recipeList;
            Log.v("onPPPExecute", Integer.toString(activity.mRecipeList.size()));
            activity.loadFragment();

        }
        //this returns the recepie list in another method becuase that all i knew how to do.
    }

}
