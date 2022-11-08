package mirz.study.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import mirz.study.mealzapp.ui.details.MealDetailsScreen
import mirz.study.mealzapp.ui.details.MealDetailsViewModel
import mirz.study.mealzapp.ui.meals.MealsCategoriesScreen
import mirz.study.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MealsApp()
                }
            }
        }
    }

    @Composable
    private fun MealsApp() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "meals_list") {
            composable("meals_list") {
                MealsCategoriesScreen {
                    navController.navigate("meals_detail/$it")
                }
            }
            composable(
                "meals_detail/{meal_category_id}",
                arguments = listOf(navArgument("meal_category_id") {
                    type = NavType.StringType
                })
            ) {
                val viewModel: MealDetailsViewModel = viewModel()
                viewModel.mealState.value?.let { it1 -> MealDetailsScreen(it1) }
            }
        }
    }
}


