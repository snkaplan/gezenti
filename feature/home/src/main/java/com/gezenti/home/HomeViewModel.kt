package com.gezenti.home

import com.gezenti.common.base.BaseViewModel
import com.gezenti.common.base.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeUiState>() {
    override fun createInitialState() = HomeUiState()
}

data class HomeUiState(
    val isLoading: Boolean = false
) : IViewState
