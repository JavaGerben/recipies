package com.cookbook.recipe.recipeIngredient;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/recipeingredients")
@RequiredArgsConstructor
public class RecipeIngredientController {
    private final RecipeIngredientRepository recipeIngredientRepository;

    @GetMapping
    public Iterable<RecipeIngredient> getAll() {
        return recipeIngredientRepository.findAll();
    }
}
