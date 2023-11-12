package icu.repsaj.android.mytrivia.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import icu.repsaj.android.mytrivia.model.Category
import icu.repsaj.android.mytrivia.ui.theme.spacing

@Composable
fun CategoryOverviewScreen(
    navigateToGame: () -> Unit,
    setCategory: (Int) -> Unit,
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = Modifier.padding(top = MaterialTheme.spacing.small)) {
        items(categories) {
            CategoryCard(name = it.name, icon = it.image, onClickPlay = {
                setCategory(it.id)
                navigateToGame()
            })
        }
    }
}

@Composable
fun CategoryCard(
    name: String = "",
    icon: ImageVector = Icons.Filled.QuestionMark,
    onClickPlay: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(
                horizontal = MaterialTheme.spacing.medium,
                vertical = MaterialTheme.spacing.extraSmall
            )
            .fillMaxWidth()
            .clickable { onClickPlay() },

        ) {
        Row(
            modifier = Modifier
                .padding(MaterialTheme.spacing.medium)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = name,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = MaterialTheme.spacing.medium)
                    .align(Alignment.CenterVertically)
            )

            Text(
                text = name,
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.displayMedium
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = name,
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}