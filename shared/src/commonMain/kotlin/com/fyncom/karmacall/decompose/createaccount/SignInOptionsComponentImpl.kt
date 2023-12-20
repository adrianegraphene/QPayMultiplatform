package com.fyncom.karmacall.decompose.createaccount

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.viewmodels.SignInOptionsViewModel

class SignInOptionsComponentImpl(
	componentContext: ComponentContext,
	val onCreateAccount: () -> Unit,
	val onSignInToAccount: () -> Unit,
) : SignInOptionsComponent, ComponentContext by componentContext {
	override val signInOptionsViewModel: SignInOptionsViewModel
		get() = instanceKeeper.getOrCreate { SignInOptionsViewModel() }
	
	override fun onCreateAccountClicked() {
		onCreateAccount()
	}
	
	override fun onSignInToAccountClicked() {
		onSignInToAccount()
	}
}
