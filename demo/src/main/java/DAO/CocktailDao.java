package DAO;

import Model.Cocktail;

import java.util.List;

public interface CocktailDao {

    List<Cocktail> getAllCocktails();

    void addNewCocktailItem(Cocktail cocktail);

    void deleteCocktail(String name);
}
