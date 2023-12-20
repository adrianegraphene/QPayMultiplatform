package com.fyncom.karmacall.decompose.login

import com.fyncom.karmacall.data.entity.User
import com.fyncom.karmacall.viewmodels.LoginViewModel

interface LoginComponent {
	val loginViewModel: LoginViewModel
	
	fun onAuthenticationSuccess(user: User, rememberMe: Boolean)
}
