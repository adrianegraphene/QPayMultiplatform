package com.fyncom.karmacall.decompose.phoneverification

import com.fyncom.karmacall.viewmodels.VerifyPhoneViewModel

interface PhoneVerificationComponent {
	val verificationViewModel: VerifyPhoneViewModel
	
	fun onVerificationCompleted()
}
