package com.fyncom.karmacall.viewmodels

import androidx.compose.runtime.mutableStateOf
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.fyncom.karmacall.data.entity.ActivityFilter
import com.fyncom.karmacall.data.entity.User
import com.fyncom.karmacall.data.repositories.TransactionRepository
import com.fyncom.karmacall.ui.states.WalletUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class WalletViewModel : InstanceKeeper.Instance {
	private val viewModelScope = CoroutineScope(Dispatchers.Unconfined)
	
	override fun onDestroy() {
		viewModelScope.cancel()
	}
	
	val uiState = mutableStateOf<WalletUiState>(WalletUiState.Loading)
	
	fun getHistory(me: User) {
		viewModelScope.launch {
			TransactionRepository.getTransaction(me, ActivityFilter.LastFiveTrans)
				.let {
					uiState.value = WalletUiState.Loaded(transactions = it)
				}
		}
	}
}
