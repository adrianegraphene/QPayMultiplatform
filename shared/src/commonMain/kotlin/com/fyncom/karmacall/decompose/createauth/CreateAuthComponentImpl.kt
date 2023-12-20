package com.fyncom.karmacall.decompose.createauth

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.data.entity.User
import com.fyncom.karmacall.viewmodels.CreateAuthenticateViewModel

class CreateAuthComponentImpl(
	private val componentContext: ComponentContext,
	private val onAuthenticationCreated: (user: User) -> Unit,
) : CreateAuthComponent, ComponentContext by componentContext {
	override val createAuthenticateViewModel: CreateAuthenticateViewModel
		get() = instanceKeeper.getOrCreate { CreateAuthenticateViewModel() }
	
	override fun onAuthPinCreated(user: User) {
		onAuthenticationCreated(user)
	}
}
