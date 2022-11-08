package mirz.study.mealzapp.ui.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import mirz.study.mealzapp.model.MealResponse
import mirz.study.mealzapp.model.MealsRepository

class MealDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    var mealState = mutableStateOf<MealResponse?>(null)
    private val repository: MealsRepository = MealsRepository.getInstance()

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id").orEmpty()
        mealState.value = repository.getMeal(mealId)
    }

}