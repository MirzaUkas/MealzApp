package mirz.study.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import mirz.study.mealzapp.model.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val imageSizeDp: Dp by animateDpAsState(targetValue = if (isExpanded) 200.dp else 100.dp)
    Column {
        Row {
            Card {
                Image(
                    painter = rememberImagePainter(
                        data = meal.categoryThumb,
                        builder = { transformations(CircleCropTransformation()) },
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .size(imageSizeDp)
                        .padding(16.dp)
                )
            }
            Text(
                meal.categoryName,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(
            onClick = { isExpanded = !isExpanded }, modifier = Modifier
                .padding(16.dp)
                .align(CenterHorizontally)
        ) {
            Text("Change State of Meal Image")
        }
    }
}