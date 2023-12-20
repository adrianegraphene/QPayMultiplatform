package com.fyncom.karmacall.decompose.bottomnavholder

import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.value.Value
import com.fyncom.karmacall.decompose.home.HomeComponent
import com.fyncom.karmacall.decompose.pocket.PocketComponent
import com.fyncom.karmacall.decompose.profile.ProfileComponent
import com.fyncom.karmacall.decompose.qrpay.QrPayComponent
import com.fyncom.karmacall.decompose.root.QPayRootImpl
import com.fyncom.karmacall.decompose.wallet.WalletComponent

@OptIn(ExperimentalDecomposeApi::class)
interface BottomNavComponent {
	val pages: Value<ChildPages<*, BottomNavChild>>
	val configs: List<BottomNavComponentImpl.BottomNavConfig>
	
	fun onNewPageSelected(index: Int)
	
	fun onNavigateToMainChild(child: QPayRootImpl.MainNavigationConfig)
	
	sealed interface BottomNavChild {
		data class Home(
			val component: HomeComponent,
		) : BottomNavChild
		
		data class Wallet(
			val component: WalletComponent,
		) : BottomNavChild
		
		data class QrCodePay(
			val component: QrPayComponent,
		) : BottomNavChild
		
		data class Pocket(
			val component: PocketComponent,
		) : BottomNavChild
		
		data class Profile(
			val component: ProfileComponent,
		) : BottomNavChild
	}
}
