package com.fyncom.karmacall.android

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.defaultComponentContext
import com.fyncom.karmacall.decompose.root.QPayRootImpl
import com.fyncom.karmacall.koin.doInitKoinApplication
import com.fyncom.karmacall.resources.StringsProvider
import com.fyncom.karmacall.ui.QPayApp
import org.koin.dsl.module

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		WindowCompat.setDecorFitsSystemWindows(window, false)
		val koinApp = doInitKoinApplication(
			listOf(
				module {
					single<Context> { applicationContext }
					single<Activity> { this@MainActivity }
				}
			)
		)
		val root = QPayRootImpl(
			componentContext = defaultComponentContext(),
			stringProvider = StringsProvider(this),
			koinApplication = koinApp,
		)
		setContent {
			QPayApp(root = root)
		}
	}
}
