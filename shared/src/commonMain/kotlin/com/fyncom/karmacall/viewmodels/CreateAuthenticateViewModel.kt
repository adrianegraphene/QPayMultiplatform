package com.fyncom.karmacall.viewmodels

import androidx.compose.runtime.mutableStateOf
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.fyncom.karmacall.data.entity.User
import com.fyncom.karmacall.data.repositories.UserRepository
import com.fyncom.karmacall.ui.states.CreateAuthUIState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class CreateAuthenticateViewModel : InstanceKeeper.Instance {
	private val viewModelScope = CoroutineScope(Dispatchers.Unconfined)
	val uiState = mutableStateOf<CreateAuthUIState>(CreateAuthUIState.Idle)
	val pin = mutableStateOf("")
	
	fun updatePin(newPin: String) {
		pin.value = newPin
	}
	
	fun saveUserPin(
		pin: String,
		onCredentialsCreated: (user: User) -> Unit,
	) {
		uiState.value = CreateAuthUIState.Creating(pin)
		viewModelScope.launch {
			// Now we should have a fake user generated for our journey
			UserRepository.getAuthenticatedUser().let(onCredentialsCreated)
		}
	}
	
	override fun onDestroy() {
		viewModelScope.cancel()
	}
}
