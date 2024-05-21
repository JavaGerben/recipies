package com.cookbook.recipe.ingredient;

import com.cookbook.recipe.recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/ingredients")
@CrossOrigin("http://localhost:5173")
public class IngredientController {
    private final IngredientRepository ingredientRepository;

    @GetMapping
    public Iterable<Ingredient> getAllRecipes () {
        return ingredientRepository.findAll();
    }

    @GetMapping("{id}")
    public Ingredient GetIngredientById (@PathVariable UUID id) {
        var possibleIngredient = ingredientRepository.findById(id);
        if (possibleIngredient.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return possibleIngredient.get();
    }

    @PostMapping
    public ResponseEntity<Ingredient> addIngredient (@RequestBody Ingredient ingredient, UriComponentsBuilder ucb) {
        var uri = ucb.path("api/v1/ingredients/{id}").buildAndExpand(ingredient.getId()).toUri();
        return ResponseEntity.created(uri).body(ingredientRepository.save(ingredient));
    }
}
