package icu.repsaj.android.mytrivia.ui.addCategory

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import icu.repsaj.android.mytrivia.R

@Composable
fun AddCategoryView(
    viewModel: AddCategoryViewModel = viewModel(factory = AddCategoryViewModel.Factory),
    navigateUp: () -> Unit
) {
    val categoryName = viewModel.categoryName
    val selectedIcon = viewModel.selectedIcon
    val icons = viewModel.icons
    val scrollState = rememberScrollState()
    val isValid = viewModel.isValid()
    val errors = viewModel.errors

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                stringResource(R.string.category_information),
                style = MaterialTheme.typography.labelMedium
            )
            OutlinedTextField(
                value = categoryName,
                onValueChange = { viewModel.categoryName = it },
                label = { Text(stringResource(R.string.category_name)) },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(stringResource(R.string.select_icon), style = MaterialTheme.typography.labelMedium)
            Row(
                modifier = Modifier
                    .horizontalScroll(scrollState)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                icons.forEach { icon ->
                    OutlinedButton(
                        onClick = { viewModel.selectedIcon = icon },
                        shape = RoundedCornerShape(50),
                        border = if (icon == selectedIcon) {
                            BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                        } else null,
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = Color.Transparent
                        ),
                        modifier = Modifier.padding(horizontal = 1.dp)
                    ) {
                        Icon(imageVector = icon, contentDescription = null)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    viewModel.addCategory(callback = navigateUp)
                },
                enabled = isValid,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Add Category")
            }

            if (errors.isNotEmpty()) {
                Column {
                    errors.forEach { error ->
                        Text(
                            text = error,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddCategoryScreenPreview() {
    AddCategoryView(navigateUp = {})
}