package com.example.android.bakingapp.model;

public class Ingredient {
    private String quantity;
    private String meassure;
    private String ingredient;

    public Ingredient() { }

    public Ingredient(String quantity, String meassure, String ingredient) {
        this.quantity = quantity;
        this.meassure = meassure;
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMeassure() {
        return meassure;
    }

    public void setMeassure(String meassure) {
        this.meassure = meassure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
