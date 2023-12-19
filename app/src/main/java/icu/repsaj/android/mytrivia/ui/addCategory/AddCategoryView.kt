package icu.repsaj.android.mytrivia.ui.addCategory

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import icu.repsaj.android.mytrivia.R
import icu.repsaj.android.mytrivia.model.iconMap
import icu.repsaj.android.mytrivia.ui.compontents.ErrorDialog
import icu.repsaj.android.mytrivia.ui.compontents.RecomposeChecker
import icu.repsaj.android.mytrivia.ui.theme.spacing

/**
 * Composable function that displays the UI for adding a new category.
 *
 * @param viewModel The ViewModel that provides the state and handles logic.
 * @param navigateUp A function to navigate back to the previous screen.
 */
@Composable
fun AddCategoryView(
    viewModel: AddCategoryViewModel = viewModel(factory = AddCategoryViewModel.Factory),
    navigateUp: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val apiState = viewModel.apiState
    val icons = iconMap.values.toList()

    RecomposeChecker(viewName = "AddCategoryView")

    if (apiState is AddCategoryApiState.Error) {
        ErrorDialog(
            dialogTitle = stringResource(id = R.string.error),
            dialogText = apiState.message,
            onConfirmation = viewModel::clear
        )
    }

    if (apiState is AddCategoryApiState.Loading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(all = MaterialTheme.spacing.medium)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

            CategoryNameInput(
                categoryName = uiState.categoryName,
                onCategoryNameChanged = { viewModel.setCategoryName(it) },
                error = uiState.nameError
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))

            IconSelector(
                icons = icons,
                onIconChanged = { viewModel.setSelectedIcon(it) },
                selectedIcon = uiState.selectedIcon,
                error = uiState.iconError
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.large))

            Button(
                onClick = {
                    viewModel.addCategory(callback = navigateUp)
                },
                enabled = uiState.isValid,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(stringResource(R.string.add_category))
            }

        }
    }
}

/**
 * Composable function that displays a text field for category name input.
 *
 * @param categoryName The current name entered in the text field.
 * @param onCategoryNameChanged A lambda that is called when the text changes.
 * @param error An error message to be displayed if the input is invalid.
 * @param modifier The modifier to be applied to the text field.
 */
@Composable
private fun CategoryNameInput(
    categoryName: String,
    onCategoryNameChanged: (String) -> Unit,
    error: String,
    modifier: Modifier = Modifier
) {
    Text(
        stringResource(R.string.category_information),
        style = MaterialTheme.typography.labelMedium
    )
    OutlinedTextField(
        value = categoryName,
        onValueChange = { onCategoryNameChanged(it) },
        label = { Text(stringResource(R.string.category_name)) },
        singleLine = true,
        shape = RoundedCornerShape(MaterialTheme.spacing.small),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
        ),
        isError = error.isNotBlank(),
        supportingText = {
            if (error.isNotBlank()) {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

/**
 * Composable function that displays a horizontal scrollable row of icons.
 *
 * @param icons A list of ImageVectors representing the icons that can be selected.
 * @param onIconChanged A lambda that is called when an icon is selected.
 * @param selectedIcon The currently selected icon.
 * @param error An error message to be displayed if no icon is selected.
 * @param modifier The modifier to be applied to the icon selector.
 */
@Composable
private fun IconSelector(
    icons: List<ImageVector>,
    onIconChanged: (ImageVector) -> Unit,
    error: String,
    modifier: Modifier = Modifier,
    selectedIcon: ImageVector? = null,
) {
    val scrollState = rememberScrollState()

    Text(stringResource(R.string.select_icon), style = MaterialTheme.typography.labelMedium)
    Row(
        modifier = modifier
            .horizontalScroll(scrollState)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraSmall)
    ) {
        icons.forEach { icon ->
            OutlinedButton(
                onClick = { onIconChanged(icon) },
                shape = RoundedCornerShape(50),
                border = if (icon == selectedIcon) {
                    BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                } else null,
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.extraSmall)
            ) {
                Icon(imageVector = icon, contentDescription = null)
            }
        }
    }
    if (error.isNotBlank()) {
        Text(
            text = error,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddCategoryScreenPreview() {
    AddCategoryView(navigateUp = {})
}