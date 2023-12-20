package com.fyncom.karmacall.ui.states

import com.fyncom.karmacall.data.entity.Transaction


sealed interface HomeUiState {
	data object Loading : HomeUiState
	data class Loaded(val transactions: List<Transaction>) : HomeUiState
	data object Filtering : HomeUiState
	class Error(val code: String) : HomeUiState
}
