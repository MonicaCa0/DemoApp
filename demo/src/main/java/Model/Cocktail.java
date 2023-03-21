package Model;

import java.util.List;

public class Cocktail {
    private int cocktailID;
    private String Name;
    private String ingredients;
    private String recipe;

    public int getCocktailID() {
        return cocktailID;
    }

    public void setCocktailID(int cocktailID) {
        this.cocktailID = cocktailID;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
