package com.fyncom.karmacall.decompose.identityverification

import androidx.compose.ui.graphics.Color
import com.fyncom.karmacall.viewmodels.IdentityVerificationViewModel

interface IdentityVerificationComponent {
	val identityVerificationViewModel: IdentityVerificationViewModel
	
	fun onIdentityVerified()
	
	fun onChangeStatusBarColor(color: Color)
}
