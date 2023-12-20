package com.fyncom.karmacall.decompose.createauth

import com.fyncom.karmacall.data.entity.User
import com.fyncom.karmacall.viewmodels.CreateAuthenticateViewModel

interface CreateAuthComponent {
	val createAuthenticateViewModel: CreateAuthenticateViewModel
	
	fun onAuthPinCreated(user: User)
}
