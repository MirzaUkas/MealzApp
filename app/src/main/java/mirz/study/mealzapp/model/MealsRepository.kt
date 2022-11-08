package mirz.study.mealzapp.model

import mirz.study.mealzapp.model.api.MealsWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(successCallback: (response: MealsCategoriesResponses?) -> Unit) {
        return webService.getMeals().enqueue(object : Callback<MealsCategoriesResponses> {
            override fun onResponse(
                call: Call<MealsCategoriesResponses>,
                response: Response<MealsCategoriesResponses>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<MealsCategoriesResponses>, t: Throwable) {

            }
        })
    }
}