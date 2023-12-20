package com.fyncom.karmacall.decompose.profile

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.viewmodels.ProfileViewModel

class ProfileComponentImpl(
	componentContext: ComponentContext,
) : ProfileComponent, ComponentContext by componentContext {
	override val profileViewModel: ProfileViewModel
		get() = instanceKeeper.getOrCreate { ProfileViewModel() }
}
