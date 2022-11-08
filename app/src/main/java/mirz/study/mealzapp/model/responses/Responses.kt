package mirz.study.mealzapp.model


import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponses(
    @SerializedName("categories")
    val categories: List<MealResponse>
)


data class MealResponse(
    @SerializedName("idCategory")
    val idCategory: String,
    @SerializedName("strCategory")
    val categoryName: String,
    @SerializedName("strCategoryDescription")
    val categoryDesc: String,
    @SerializedName("strCategoryThumb")
    val categoryThumb: String
)