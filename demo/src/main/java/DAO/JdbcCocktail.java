package DAO;

import Model.Cocktail;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcCocktail implements CocktailDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcCocktail(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Cocktail> getAllCocktails() {
        String sql = "SELECT * FROM cocktails";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Cocktail> cocktailsList = new ArrayList<>();
        while(results.next()){
            cocktailsList.add(mapRowToCocktail(results));
        }
        return cocktailsList;
    }


    @Override
    public void addNewCocktailItem(Cocktail cocktail) {
        String name = cocktail.getName();
        String ingredients = cocktail.getIngredients();
        String recipe = cocktail.getRecipe();
        String sql = "INSERT INTO cocktails(cocktail_name, ingredients, recipe)" +
                "VALUES(?, ?, ?)";
        jdbcTemplate.update(sql,name, ingredients, recipe );

    }


    @Override
    public void deleteCocktail(String name) {
        String sql = "DELETE FROM cocktails WHERE name = ?";
        jdbcTemplate.update(sql, name);

    }

    private Cocktail mapRowToCocktail(SqlRowSet rs){
        Cocktail cocktail = new Cocktail();
        cocktail.setCocktailID(rs.getInt("cocktail_id"));
        cocktail.setName(rs.getString("name"));
        cocktail.setRecipe(rs.getString("recipe"));
        cocktail.setIngredients(rs.getString("ingredients"));
        return cocktail;
    }
}
