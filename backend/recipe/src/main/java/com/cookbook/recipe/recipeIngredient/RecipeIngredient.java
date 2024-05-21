package com.cookbook.recipe.recipeIngredient;

import com.cookbook.recipe.ingredient.Ingredient;
import com.cookbook.recipe.recipe.Recipe;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RecipeIngredient {
    @Id
    @GeneratedValue
    private UUID id;

    private int quantity;

    @ManyToOne
    @JsonBackReference
    private Recipe recipe;

    @ManyToOne
    @JsonBackReference
    private Ingredient ingredient;
}
