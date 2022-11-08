package mirz.study.mealzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import mirz.study.mealzapp.model.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse) {
    var profilePictureState by remember {
        mutableStateOf(MealProfilePictureState.Normal)
    }
    val transition = updateTransition(targetState = profilePictureState, label = "")
    val imageSizeDp by transition.animateDp(targetValueByState = { it.size }, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
    val borderSize by transition.animateDp(targetValueByState = { it.borderWidth }, label = "")

    Column {
        Row {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(borderSize, color)
            ) {
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
            onClick = {
                profilePictureState =
                    if (profilePictureState == MealProfilePictureState.Normal) MealProfilePictureState.Expanded else MealProfilePictureState.Normal
            }, modifier = Modifier
                .padding(16.dp)
                .align(CenterHorizontally)
        ) {
            Text("Change State of Meal Image")
        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Green, 200.dp, 16.dp),
}