package com.fyncom.karmacall.decompose.pocket

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.viewmodels.PocketViewModel

class PocketComponentImpl(
	componentContext: ComponentContext
) : PocketComponent, ComponentContext by componentContext {
	override val pocketViewModel: PocketViewModel
		get() = instanceKeeper.getOrCreate { PocketViewModel() }
}
