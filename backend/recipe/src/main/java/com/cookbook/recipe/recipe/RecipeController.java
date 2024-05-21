package com.cookbook.recipe.recipe;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/recipes")
    @CrossOrigin("http://localhost:5173")
public class RecipeController {
    private final RecipeRepository recipeRepository;

    @GetMapping
    public Iterable<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @GetMapping("{id}")
    public Recipe getById (@PathVariable UUID id) {
        var possibleRecipe = recipeRepository.findById(id);
        if (possibleRecipe.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return possibleRecipe.get();
    }

    @PostMapping
    public ResponseEntity<Recipe> AddRecipe (@RequestBody Recipe recipe, UriComponentsBuilder ucb) {
        var uri = ucb.path("api/v1/recipes/{id}").buildAndExpand(recipe.getId()).toUri();
        return ResponseEntity.created(uri).body(recipeRepository.save(recipe));
    }
}
