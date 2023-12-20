package com.fyncom.karmacall.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.moriatsushi.insetsx.SystemBarsBehavior
import com.moriatsushi.insetsx.rememberWindowInsetsController
import com.fyncom.karmacall.data.entity.LocalUser
import com.fyncom.karmacall.decompose.root.QPayRoot
import com.fyncom.karmacall.koin.LocalKoinApplication
import com.fyncom.karmacall.resources.LocalStringProvider
import com.fyncom.karmacall.ui.screens.BottomNavPage
import com.fyncom.karmacall.ui.screens.ContactPage
import com.fyncom.karmacall.ui.screens.CreateAuthenticationPage
import com.fyncom.karmacall.ui.screens.IdentityVerificationPage
import com.fyncom.karmacall.ui.screens.LoginPage
import com.fyncom.karmacall.ui.screens.NationalIDCapturePage
import com.fyncom.karmacall.ui.screens.OnboardingPage
import com.fyncom.karmacall.ui.screens.PhoneVerificationPage
import com.fyncom.karmacall.ui.screens.SignInOptionsPage
import com.fyncom.karmacall.ui.screens.SplashPage
import com.fyncom.karmacall.ui.theme.CommonQPayTheme

@Composable
fun QPayApp(
	root: QPayRoot,
) {
	val windowsInsets = rememberWindowInsetsController()
	val user by root.rootViewModel.user.collectAsState()
	
	LaunchedEffect(Unit) {
		windowsInsets?.setIsNavigationBarsVisible(false)
		windowsInsets?.setIsStatusBarsVisible(false)
		windowsInsets?.setSystemBarsBehavior(SystemBarsBehavior.Immersive)
	}
	
	CommonQPayTheme {
		CompositionLocalProvider(
			LocalStringProvider provides root.stringProvider,
			LocalKoinApplication provides root.koinApplication,
			LocalUser provides user,
		) {
			val stack by root.backstack.subscribeAsState()
			val current = stack.active.instance
			
			Column(
				modifier = Modifier.fillMaxSize()
					.background(MaterialTheme.colorScheme.surface),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally,
			) {
				Children(
					stack = stack,
					modifier = Modifier.weight(1f),
				) { childCreated ->
					when (val child = childCreated.instance) {
						is QPayRoot.MainDestinationChild.Splash -> {
							SplashPage(
								viewModel = child.component.splashViewModel,
								onSplashFinished = { onboardedBefore ->
									child.component.onSplashTimeFinish(
										isOnboardedBefore = onboardedBefore,
									)
								}
							)
						}
						
						is QPayRoot.MainDestinationChild.Onboarding -> {
							OnboardingPage(
								onGetStarted = {
									child.component.onOnboarded()
								}
							)
						}
						
						is QPayRoot.MainDestinationChild.SignInOptions -> {
							SignInOptionsPage(
								onCreateAccount = {
									child.component.onCreateAccountClicked()
								},
								onSignToQpayAccount = {
									child.component.onSignInToAccountClicked()
								}
							)
						}
						
						is QPayRoot.MainDestinationChild.Login -> {
							LoginPage(
								viewModel = child.component.loginViewModel,
								onUserAuthenticated = { user, rememberMe ->
									child.component.onAuthenticationSuccess(
										user = user,
										rememberMe = rememberMe,
									)
								}
							)
						}
						
						is QPayRoot.MainDestinationChild.ContactInfo -> {
							ContactPage(
								viewModel = child.component.contactsViewModel,
							) {
								child.component.onOtpSent()
							}
						}
						
						is QPayRoot.MainDestinationChild.PhoneVerification -> {
							PhoneVerificationPage(
								viewModel = child.component.verificationViewModel,
							) {
								child.component.onVerificationCompleted()
							}
						}
						
						is QPayRoot.MainDestinationChild.NationalIdCapture -> {
							NationalIDCapturePage(
								viewModel = child.component.nationalIdViewModel,
							) { front, back ->
								child.component.onCaptured(front, back)
							}
						}
						
						is QPayRoot.MainDestinationChild.IdentifyVerification -> {
							IdentityVerificationPage(
								viewModel = child.component.identityVerificationViewModel,
								onStatusBarColorChangeRequest = {
									child.component.onChangeStatusBarColor(it)
								},
								onIdentityVerified = {
									child.component.onIdentityVerified()
								}
							)
						}
						
						is QPayRoot.MainDestinationChild.CreateAuthenticationPin -> {
							CreateAuthenticationPage(
								viewModel = child.component.createAuthenticateViewModel,
								onAuthenticationCreated = {
									child.component.onAuthPinCreated(it)
								},
							)
						}
						
						is QPayRoot.MainDestinationChild.BottomNavHolder -> {
							BottomNavPage(
								bottomNavComponent = child.component,
								onNavigateToMainChild = {
									child.component.onNavigateToMainChild(it)
								}
							)
						}
					}
				}
			}
		}
	}
}
