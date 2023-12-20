package com.fyncom.karmacall.permissions

import com.fyncom.karmacall.utils.openAppSettingsPage
import com.fyncom.karmacall.utils.permissions.PermissionDelegate
import com.fyncom.karmacall.utils.permissions.PermissionState
import platform.AVFoundation.AVCaptureDevice
import platform.AVFoundation.AVMediaTypeVideo
import platform.AVFoundation.authorizationStatusForMediaType
import platform.AVFoundation.requestAccessForMediaType
import platform.CoreBluetooth.CBManagerAuthorizationAllowedAlways
import platform.CoreBluetooth.CBManagerAuthorizationDenied
import platform.CoreBluetooth.CBManagerAuthorizationRestricted

class CameraPermissionDelegate : PermissionDelegate {
	override fun getPermissionState(): PermissionState {
		return when (AVCaptureDevice.authorizationStatusForMediaType(AVMediaTypeVideo)) {
			CBManagerAuthorizationAllowedAlways,
			CBManagerAuthorizationRestricted -> PermissionState.GRANTED
			
			CBManagerAuthorizationDenied -> PermissionState.DENIED
			else -> PermissionState.UNKNOWN
		}
	}
	
	override fun openSettingForPermission() {
		openAppSettingsPage()
	}
	
	override suspend fun askForPermission(
		onGranted: () -> Unit,
		onFailure: () -> Unit,
	) {
		AVCaptureDevice.requestAccessForMediaType(AVMediaTypeVideo) {
			if (it) onGranted()
			else onFailure()
		}
	}
}
