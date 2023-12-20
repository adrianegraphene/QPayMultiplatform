package com.fyncom.karmacall.decompose.wallet

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.viewmodels.WalletViewModel

class WalletComponentImpl(
	componentContext: ComponentContext,
) : WalletComponent, ComponentContext by componentContext {
	override val walletViewModel: WalletViewModel
		get() = instanceKeeper.getOrCreate { WalletViewModel() }
}
