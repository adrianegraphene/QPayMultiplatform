package com.fyncom.karmacall.utils.permissions

interface PermissionDelegate {
	fun getPermissionState(): PermissionState
	fun openSettingForPermission()
	suspend fun askForPermission(
		onGranted: () -> Unit,
		onFailure: () -> Unit,
	)
}
