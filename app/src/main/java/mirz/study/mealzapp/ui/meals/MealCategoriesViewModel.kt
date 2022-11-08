package mirz.study.mealzapp.ui.meals

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import mirz.study.mealzapp.model.MealResponse
import mirz.study.mealzapp.model.MealsRepository

class MealCategoriesViewModel(private val repository: MealsRepository = MealsRepository.getInstance()) :
    ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(
        emptyList()
    )


    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}