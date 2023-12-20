package com.fyncom.karmacall.ui.states

import com.fyncom.karmacall.data.entity.Pocket

sealed interface PocketUIState {
	data object Loading : PocketUIState
	data class Loaded(val pockets: List<Pocket>) : PocketUIState
	class Error(val code: String) : PocketUIState
}
