package com.example.android.bakingapp;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.bakingapp.utilities.JsonUtils;
import com.example.android.bakingapp.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class MasterListFragment extends Fragment {
    private RecyclerView mRv;
    private ListAdapter mListAdapter;
    public ArrayList mRecipeList;
    public Context context;




    public MasterListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        context = ;
        mRecipeList = new ArrayList<>();
        URL url = NetworkUtils.buildUrl();
        new RecipeQuerryTask().execute(url);

        //some adapter recycler view stuff go in here reffrence masterListFragment.java in the android me app.
        //++++
        mRv = (RecyclerView) rootView.findViewById(R.id.rv_masterList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        mRv.setLayoutManager(layoutManager);
        mRv.setHasFixedSize(true);

        return rootView;
    }



    public class RecipeQuerryTask extends AsyncTask<URL, Void, String> {
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
           if (s != null && !s.equals("")) {
               mRecipeList = JsonUtils.parseRecipeJson(s);
               Log.v("inPostExecute&&&&&", Integer.toString(mRecipeList.size()));
               mListAdapter = new ListAdapter(mRecipeList,context  );
               mRv.setAdapter(mListAdapter);
           }
        }
    }


}
