package com.fyncom.karmacall.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fyncom.karmacall.SharedRes
import com.fyncom.karmacall.ui.composables.VerticalBrandLogo
import com.fyncom.karmacall.ui.states.SplashUIState
import com.fyncom.karmacall.utils.get
import com.fyncom.karmacall.viewmodels.SplashViewModel

@Composable
fun SplashPage(
	viewModel: SplashViewModel,
	onSplashFinished: (onboardedBefore: Boolean) -> Unit,
) {
	val loggedUser by viewModel.uiState.collectAsState()
	
	when (loggedUser) {
		SplashUIState.Waiting -> {
			Column(
				modifier = Modifier
					.fillMaxSize()
					.background(MaterialTheme.colorScheme.primary)
					.padding(20.dp),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
				VerticalBrandLogo(
					text = SharedRes.strings.app_name.get(),
					logo = SharedRes.images.qpay,
				)
			}
		}
		
		is SplashUIState.Success -> {
			(loggedUser as SplashUIState.Success).let {
				onSplashFinished(it.onboardBefore)
			}
		}
	}
}
