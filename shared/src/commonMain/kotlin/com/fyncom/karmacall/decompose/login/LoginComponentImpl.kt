package com.fyncom.karmacall.decompose.login

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.data.entity.User
import com.fyncom.karmacall.viewmodels.LoginViewModel

class LoginComponentImpl(
	componentContext: ComponentContext,
	private val onAuthenticated: (user: User, rememberMe: Boolean) -> Unit,
) : LoginComponent, ComponentContext by componentContext {
	override val loginViewModel: LoginViewModel
		get() = instanceKeeper.getOrCreate { LoginViewModel() }
	
	override fun onAuthenticationSuccess(user: User, rememberMe: Boolean) {
		onAuthenticated(user, rememberMe)
	}
}
