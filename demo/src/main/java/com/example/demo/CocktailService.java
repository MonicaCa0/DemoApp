package com.example.demo;

import Model.Cocktail;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CocktailService {


    public static final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1";
    public RestTemplate restTemplate = new RestTemplate();

    public Cocktail getDrinksByName(String name){
        Cocktail results = restTemplate.getForObject(BASE_URL + "/search.php?s=" + name, Cocktail.class);
        if(results != null){
            return results;
        }
        System.out.println("Sorry, nothing has matched. Please try again!");
        return null;
    }

    public Cocktail getDrinksByIngredients(String ingredient){
        Cocktail results = restTemplate.getForObject(BASE_URL + "/filter.php?i=" + ingredient, Cocktail.class);
        if(results != null){
            return results;
        }
        System.out.println("Sorry, nothing has match your results. Please try again!");
        return null;
    }

}
