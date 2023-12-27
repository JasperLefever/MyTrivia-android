package icu.repsaj.android.mytrivia.ui.compontents

import NetworkConnectionState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import icu.repsaj.android.mytrivia.R
import kotlinx.coroutines.ExperimentalCoroutinesApi
import rememberConnectivityState

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun NoConnectionScreen(child: @Composable () -> Unit) {
    val networkState by rememberConnectivityState()

    when (networkState) {
        is NetworkConnectionState.Available -> {
            child()
        }

        is NetworkConnectionState.Unavailable -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = stringResource(R.string.without_internet_connection_you_can_t_perform_this_action),
                    textAlign = TextAlign.Center, style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        else -> {}
    }

}
