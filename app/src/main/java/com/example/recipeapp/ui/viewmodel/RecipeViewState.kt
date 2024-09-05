package com.example.recipeapp.ui.viewmodel

import com.example.recipeapp.data.model.Meals

sealed class RecipeViewState {
    object Loading: RecipeViewState()
    data class Success(val recipes: List<Meals>): RecipeViewState()
    data class Error(val message: String): RecipeViewState()
}