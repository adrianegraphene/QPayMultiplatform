package com.fyncom.karmacall.decompose.splash

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.viewmodels.SplashViewModel

class SplashComponentImpl(
	componentContext: ComponentContext,
	val onSplashTimeFinished: (onboardedBefore: Boolean) -> Unit,
) : SplashComponent, ComponentContext by componentContext {
	override val splashViewModel: SplashViewModel
		get() = instanceKeeper.getOrCreate { SplashViewModel() }
	
	override fun onSplashTimeFinish(isOnboardedBefore: Boolean) {
		onSplashTimeFinished(isOnboardedBefore)
	}
}
