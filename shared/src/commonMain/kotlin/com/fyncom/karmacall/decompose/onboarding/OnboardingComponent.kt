package com.fyncom.karmacall.decompose.onboarding

import com.fyncom.karmacall.viewmodels.OnboardingViewModel

interface OnboardingComponent {
	val onboardingViewModel: OnboardingViewModel
	
	fun onOnboarded ()
}
