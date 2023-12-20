package com.fyncom.karmacall.viewmodels

import androidx.compose.runtime.mutableStateOf
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.fyncom.karmacall.data.repositories.PocketRepository
import com.fyncom.karmacall.ui.states.PocketUIState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class PocketViewModel : InstanceKeeper.Instance {
	private val viewModelScope = CoroutineScope(Dispatchers.Unconfined)
	
	override fun onDestroy() {
		viewModelScope.cancel()
	}
	
	val uiState = mutableStateOf<PocketUIState>(PocketUIState.Loading)
	
	init {
		getPockets()
	}
	
	private fun getPockets() {
		viewModelScope.launch {
			uiState.value = PocketUIState.Loading
			PocketRepository.getPockets().let {
				uiState.value = PocketUIState.Loaded(it)
			}
		}
	}
}
