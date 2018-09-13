package com.example.android.bakingapp.utilities;

import android.util.Log;

import com.example.android.bakingapp.model.Ingredient;
import com.example.android.bakingapp.model.Recipe;
import com.example.android.bakingapp.model.Step;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    public static ArrayList parseRecipeJson(String json) {
        ArrayList recipeList = new ArrayList<>();
        try {
           JSONArray recipesArray = new JSONArray(json);
           for (int i = 0; i < recipesArray.length(); i ++) {
               JSONObject recipe;
               recipe = recipesArray.getJSONObject(i);
               Recipe recipeR = new Recipe(recipe.getString("name"),
                       parseIngredinetsJson(recipe.getJSONArray("ingredients")),
                       parseSteps(recipe.getJSONArray("steps")),
                       recipe.getString("servings"),
                       recipe.getString("image"));
               recipeList.add(recipeR);
           }
            return recipeList;

        }catch (JSONException e) {
            Log.v("Json Error", "something broke");
            return null;
        }

    }
    private static ArrayList parseIngredinetsJson(JSONArray array) {
        ArrayList ingredientsArray = new ArrayList<>();
        try {
            for (int i = 0; i < array.length(); i++) {
                JSONObject ingredient;
                ingredient = array.getJSONObject(i);
                Ingredient ingredient1 = new Ingredient(ingredient.getString("quantity"),
                        ingredient.getString("measure"),
                        ingredient.getString("ingredient"));
                ingredientsArray.add(ingredient1);

            }
            return ingredientsArray;
        } catch (JSONException e) {
            Log.v("JSON", "broken");
            return  null;
        }
    }
    private static ArrayList parseSteps(JSONArray array) {
        ArrayList stepsList = new ArrayList<>();
        try {
            for (int i = 0; i < array.length(); i++) {
                JSONObject step;
                step = array.getJSONObject(i);
                Step step1 = new Step(step.getString("id"),
                        step.getString("shortDescription"),
                        step.getString("description"),
                        step.getString("videoURL"),
                        step.getString("thumbnailURL"));
                stepsList.add(step1);
            }

                return stepsList;

        } catch ( JSONException e) {
            Log.v("JSON", "bad");
            return null;
        }

    }
}
