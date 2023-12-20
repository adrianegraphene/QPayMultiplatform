package com.fyncom.karmacall.decompose.createaccount

import com.fyncom.karmacall.viewmodels.SignInOptionsViewModel

interface SignInOptionsComponent {
	val signInOptionsViewModel: SignInOptionsViewModel
	
	fun onCreateAccountClicked()
	fun onSignInToAccountClicked()
}
