package com.fyncom.karmacall.decompose.home

import com.fyncom.karmacall.viewmodels.HomeViewModel

interface HomeComponent {
	val homeViewModel: HomeViewModel
	
	fun onNavigateToSendMoney()
}
