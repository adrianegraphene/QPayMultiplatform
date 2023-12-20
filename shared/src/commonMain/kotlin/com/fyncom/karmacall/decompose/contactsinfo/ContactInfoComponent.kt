package com.fyncom.karmacall.decompose.contactsinfo

import com.fyncom.karmacall.viewmodels.ContactsViewModel

interface ContactInfoComponent {
	val contactsViewModel: ContactsViewModel
	
	fun onOtpSent()
}
