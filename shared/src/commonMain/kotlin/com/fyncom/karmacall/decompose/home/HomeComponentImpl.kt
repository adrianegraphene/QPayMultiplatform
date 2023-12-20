package com.fyncom.karmacall.decompose.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.viewmodels.HomeViewModel

class HomeComponentImpl(
	private val componentContext: ComponentContext,
	private val onOpenSendMoney: () -> Unit,
) : HomeComponent, ComponentContext by componentContext {
	override val homeViewModel: HomeViewModel
		get() = instanceKeeper.getOrCreate { HomeViewModel() }
	
	override fun onNavigateToSendMoney() {
		onOpenSendMoney()
	}
}
