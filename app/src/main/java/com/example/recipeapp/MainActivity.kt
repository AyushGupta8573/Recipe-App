package com.example.recipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipeapp.ui.screens.HomeScreen
import com.example.recipeapp.ui.screens.LoginScreen
import com.example.recipeapp.ui.screens.LoginnScreen
import com.example.recipeapp.ui.theme.RecipeAppTheme
import com.example.recipeapp.ui.viewmodel.RecipeViewModel

class MainActivity : ComponentActivity() {
    private val recipeViewModel: RecipeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, Routes.StartScreen, builder = {
                        composable(Routes.LoginnScreen) {
                            LoginnScreen(
                                onLoginSuccess = {
                                    navController.navigate(Routes.HomeScreen) {
                                        popUpTo(0)
                                    }
                                }
                            )
                        }
                        composable(Routes.StartScreen) {
                            LoginScreen(navController)
                        }
                        composable(Routes.HomeScreen) {
                            HomeScreen(recipeViewModel = recipeViewModel)
                        }
                    })
                }
            }
        }
    }
}






