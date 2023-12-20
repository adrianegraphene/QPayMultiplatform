package com.fyncom.karmacall.decompose.onboarding

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.viewmodels.OnboardingViewModel

class OnboardingComponentImpl(
	componentContext: ComponentContext,
	val onOnboardingFinished: () -> Unit,
) : OnboardingComponent, ComponentContext by componentContext {
	override val onboardingViewModel: OnboardingViewModel
		get() = instanceKeeper.getOrCreate { OnboardingViewModel() }
	
	override fun onOnboarded() {
		onOnboardingFinished()
	}
}
