package com.fyncom.karmacall.decompose.phoneverification

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.viewmodels.VerifyPhoneViewModel

class PhoneVerificationComponentImpl(
	componentContext: ComponentContext,
	val onVerifiedSuccessfully: () -> Unit,
) : PhoneVerificationComponent, ComponentContext by componentContext {
	override val verificationViewModel: VerifyPhoneViewModel
		get() = instanceKeeper.getOrCreate { VerifyPhoneViewModel() }
	
	override fun onVerificationCompleted() {
		onVerifiedSuccessfully()
	}
}
