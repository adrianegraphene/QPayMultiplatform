package com.fyncom.karmacall.ui.states

import com.fyncom.karmacall.data.entity.Transaction

sealed interface WalletUiState {
	data object Loading : WalletUiState
	data class Loaded(val transactions: List<Transaction>) : WalletUiState
	class Error(val code: String) : WalletUiState
}
