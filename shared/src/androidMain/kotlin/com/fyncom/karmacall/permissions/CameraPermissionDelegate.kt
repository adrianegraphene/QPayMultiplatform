package com.fyncom.karmacall.permissions

import android.Manifest
import android.app.Activity
import android.content.Context
import com.fyncom.karmacall.utils.askForPermissions
import com.fyncom.karmacall.utils.checkPermissions
import com.fyncom.karmacall.utils.openAppSettingsPage
import com.fyncom.karmacall.utils.permissions.Permission
import com.fyncom.karmacall.utils.permissions.PermissionDelegate
import com.fyncom.karmacall.utils.permissions.PermissionState

class CameraPermissionDelegate(
	private val context: Context,
	private val activity: Lazy<Activity>,
) : PermissionDelegate {
	override fun getPermissionState(): PermissionState {
		return checkPermissions(
			context = context,
			activity = activity,
			permissions = listOf(Manifest.permission.CAMERA)
		)
	}
	
	override fun openSettingForPermission() {
		context.openAppSettingsPage(permission = Permission.Camera)
	}
	
	override suspend fun askForPermission(
		onGranted: () -> Unit,
		onFailure: () -> Unit,
	) {
		activity.value.askForPermissions(
			permissions = listOf(Manifest.permission.CAMERA),
			onFailure = { onFailure() },
		)
	}
}
