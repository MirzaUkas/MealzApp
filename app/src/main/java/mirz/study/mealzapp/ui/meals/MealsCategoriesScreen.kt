package mirz.study.mealzapp.ui.meals

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import mirz.study.mealzapp.model.MealResponse
import mirz.study.mealzapp.ui.theme.MealzAppTheme


@Composable
fun MealsCategoriesScreen(navigationCallback: (String) -> Unit) {
    val viewModel = viewModel<MealCategoriesViewModel>()
    val meals = viewModel.mealsState.value
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { item ->
            MealCategory(meal = item, navigationCallback)
        }
    }
}

@Composable
fun MealCategory(meal: MealResponse, navigationCallback: (String) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clickable {
                navigationCallback(meal.idCategory)
            }
    ) {
        Row(modifier = Modifier.animateContentSize()) {
            Image(
                rememberImagePainter(meal.categoryThumb),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(88.dp)
            )
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth(0.8f)
                    .padding(16.dp)
            ) {
                Text(text = meal.categoryName, style = MaterialTheme.typography.h6)
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = meal.categoryDesc,
                        style = MaterialTheme.typography.subtitle2,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = if (isExpanded) 10 else 2
                    )
                }
            }
            Icon(
                imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "",
                modifier = Modifier
                    .padding(16.dp)
                    .align(if (isExpanded) Alignment.Bottom else Alignment.CenterVertically)
                    .clickable { isExpanded = !isExpanded }
            )
        }


    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MealzAppTheme {
//        MealsCategoriesScreen()
//    }
//}