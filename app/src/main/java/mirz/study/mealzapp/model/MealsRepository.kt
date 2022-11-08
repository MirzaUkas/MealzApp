package mirz.study.mealzapp.model

import mirz.study.mealzapp.model.api.MealsWebService

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    private var cachedMeals = listOf<MealResponse>()
    suspend fun getMeals(): MealsCategoriesResponses {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeals.firstOrNull { it.idCategory == id }
    }

    companion object {
        @Volatile
        private var instance : MealsRepository? = null

        fun getInstance() = instance ?: synchronized(this){
            instance ?: MealsRepository().also {
                instance = it
            }
        }
    }
}