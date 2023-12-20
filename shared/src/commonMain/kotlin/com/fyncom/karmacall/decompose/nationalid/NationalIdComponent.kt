package com.fyncom.karmacall.decompose.nationalid

import com.fyncom.karmacall.viewmodels.NationalIdViewModel

interface NationalIdComponent {
	val nationalIdViewModel: NationalIdViewModel
	
	fun onCaptured(front: String, back: String)
}
