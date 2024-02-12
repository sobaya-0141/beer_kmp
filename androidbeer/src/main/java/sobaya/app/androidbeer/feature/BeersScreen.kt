package sobaya.app.androidbeer.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel
import spbaya.libs.core.viewmodel.BeersUiState
import spbaya.libs.core.viewmodel.BeersViewModel

@Composable
public fun BeersScreenRoot(
    viewModel: BeersViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    BeersScreen(uiState.value)
}

@Composable
private fun BeersScreen(
    uiState: BeersUiState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        when (uiState) {
            is BeersUiState.Loading -> {
                item {

                }
            }

            is BeersUiState.Success -> {
                items(
                    items = uiState.data,
                    key = { beer -> beer.id },
                ) { beer ->
                    AsyncImage(
                        model = beer.image_url,
                        contentDescription = null,
                        modifier = Modifier.width(100.dp),
                        contentScale = ContentScale.FillWidth,
                    )
                }
            }

            is BeersUiState.Error -> {
                item {

                }
            }
        }
    }
}