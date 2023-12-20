package com.fyncom.karmacall.koin

import com.fyncom.karmacall.utils.permissions.PermissionHandlerImpl
import org.koin.core.module.Module
import org.koin.dsl.module

internal expect fun getPlatformModule(): Module

val permissionModule = module {
	includes(getPlatformModule())
	
	single<PermissionHandlerImpl> {
		PermissionHandlerImpl()
	}
}
