package Controller;

import DAO.CocktailDao;
import DAO.JdbcCocktail;
import Model.Cocktail;
import com.example.demo.CocktailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cocktail/")
public class CocktailController {

    private Cocktail cocktail;
    private CocktailService cocktailService;
    private CocktailDao cocktailDao;
    private JdbcCocktail jdbcCocktail;

    public CocktailController(Cocktail cocktail, CocktailService cocktailService, CocktailDao cocktailDao, JdbcCocktail jdbcCocktail){
        this.cocktail = cocktail;
        this.cocktailService = cocktailService;
        this.cocktailDao = cocktailDao;
        this.jdbcCocktail = jdbcCocktail;
    }

    @RequestMapping(path = "{name}" , method = RequestMethod.GET)
    public Cocktail getCocktailsByName(@PathVariable String name){
        return cocktailService.getDrinksByName(name);
    }

    @RequestMapping(path = "{ingredient}", method = RequestMethod.GET)
    public Cocktail getCocktailsByIngredient(@PathVariable String ingredient){
        return cocktailService.getDrinksByIngredients(ingredient);
    }

}
