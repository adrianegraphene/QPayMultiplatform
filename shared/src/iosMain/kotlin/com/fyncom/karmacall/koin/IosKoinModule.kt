package com.fyncom.karmacall.koin

import com.fyncom.karmacall.permissions.CameraPermissionDelegate
import com.fyncom.karmacall.utils.permissions.Permission
import com.fyncom.karmacall.utils.permissions.PermissionDelegate
import org.koin.core.qualifier.named
import org.koin.dsl.module

actual fun getPlatformModule() = module {
	single<PermissionDelegate>(named(Permission.Camera.name)) {
		CameraPermissionDelegate()
	}
}
