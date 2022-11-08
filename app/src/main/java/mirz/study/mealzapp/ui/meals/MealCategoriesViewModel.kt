package mirz.study.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import mirz.study.mealzapp.model.MealResponse
import mirz.study.mealzapp.model.MealsCategoriesResponses
import mirz.study.mealzapp.model.MealsRepository

class MealCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {
        fun getMeals(successCallback: (response: MealsCategoriesResponses?) -> Unit) {
            repository.getMeals { response ->
                successCallback(response)
           }
        }
}