package com.fyncom.karmacall.decompose.splash

import com.fyncom.karmacall.viewmodels.SplashViewModel

interface SplashComponent {
	val splashViewModel: SplashViewModel
	
	fun onSplashTimeFinish(isOnboardedBefore: Boolean)
}
