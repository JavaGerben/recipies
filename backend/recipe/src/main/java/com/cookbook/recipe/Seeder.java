package com.cookbook.recipe;

import com.cookbook.recipe.ingredient.Ingredient;
import com.cookbook.recipe.ingredient.IngredientRepository;
import com.cookbook.recipe.recipe.Recipe;
import com.cookbook.recipe.recipe.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @Override
    public void run(String... args) throws Exception {
        if (recipeRepository.count() == 0) {
            Recipe recipe1 = new Recipe("Pannenkoeken");
            Recipe recipe2 = new Recipe("Broodje hamburger");
            recipeRepository.saveAll(List.of(recipe1, recipe2));
        }

        if (ingredientRepository.count() == 0) {
            Ingredient ingredient1 = new Ingredient("ui");
            Ingredient ingredient2 = new Ingredient("zout");
            ingredientRepository.saveAll(List.of(ingredient1, ingredient2));
        }
    }
}
