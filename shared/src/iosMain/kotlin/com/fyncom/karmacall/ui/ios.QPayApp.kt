package com.fyncom.karmacall.ui

import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.moriatsushi.insetsx.WindowInsetsUIViewController
import com.fyncom.karmacall.decompose.root.QPayRootImpl
import com.fyncom.karmacall.resources.StringsProvider
import org.koin.core.KoinApplication
import platform.UIKit.UIViewController

fun MainViewController(
	stringProvider: StringsProvider,
	koinApplication: KoinApplication,
) : UIViewController {
	val root = QPayRootImpl(
		componentContext = DefaultComponentContext(lifecycle = LifecycleRegistry()),
		stringProvider = stringProvider,
		koinApplication = koinApplication,
	)
	return WindowInsetsUIViewController {
		QPayApp(
			root = root,
		)
	}
}
