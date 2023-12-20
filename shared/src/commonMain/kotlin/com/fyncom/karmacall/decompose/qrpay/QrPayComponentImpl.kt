package com.fyncom.karmacall.decompose.qrpay

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.fyncom.karmacall.viewmodels.QrPayViewModel

class QrPayComponentImpl(
	componentContext: ComponentContext,
) : QrPayComponent, ComponentContext by componentContext {
	override val qrPayViewModel: QrPayViewModel
		get() = instanceKeeper.getOrCreate { QrPayViewModel() }
}
