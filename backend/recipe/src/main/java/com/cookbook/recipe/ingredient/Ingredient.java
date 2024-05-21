package com.cookbook.recipe.ingredient;

import com.cookbook.recipe.recipeIngredient.RecipeIngredient;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "ingredient")
    @JsonBackReference
    private final Set<RecipeIngredient> recipeIngredients = new HashSet<>();

    public Ingredient(String name) {
        this.name = name;
    }
}
