package mirz.study.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import mirz.study.mealzapp.model.MealResponse
import java.lang.Float.min

@Composable
fun MealDetailsScreen(meal: MealResponse) {
    val scrollState = rememberScrollState()
    val offset = min(1f, 1 - (scrollState.value / 600f))
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp*offset))
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.dp, Color.Green)
                    ) {
                        Image(
                            painter = rememberImagePainter(
                                data = meal.categoryThumb,
                                builder = { transformations(CircleCropTransformation()) },
                            ),
                            contentDescription = "",
                            modifier = Modifier
                                .size(size)
                        )
                    }
                    Text(
                        meal.categoryName,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
                Text("This is a text element", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Green, 200.dp, 16.dp),
}