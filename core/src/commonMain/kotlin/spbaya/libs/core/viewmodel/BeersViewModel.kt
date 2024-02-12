package spbaya.libs.core.viewmodel

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.annotation.Factory
import spbaya.libs.core.model.Beer
import spbaya.libs.core.repository.BeerRepository

@Factory
public class BeersViewModel(private val beerRepository: BeerRepository) : KMMViewModel() {
    private val _uiState: MutableStateFlow<BeersUiState>             = MutableStateFlow(viewModelScope = viewModelScope, value = BeersUiState.Loading)
    public val uiState: StateFlow<BeersUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.coroutineScope.launch {
            val beers = beerRepository.getBeers()
            _uiState.value = BeersUiState.Success(beers)
        }
    }
}

public sealed interface BeersUiState {
    public data object Loading : BeersUiState
    public data class Success(val data: List<Beer>) : BeersUiState
    public data class Error(val message: String) : BeersUiState
}
