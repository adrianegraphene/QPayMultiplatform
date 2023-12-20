package com.fyncom.karmacall.decompose.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.fyncom.karmacall.decompose.bottomnavholder.BottomNavComponent
import com.fyncom.karmacall.decompose.contactsinfo.ContactInfoComponent
import com.fyncom.karmacall.decompose.createaccount.SignInOptionsComponent
import com.fyncom.karmacall.decompose.createauth.CreateAuthComponent
import com.fyncom.karmacall.decompose.identityverification.IdentityVerificationComponent
import com.fyncom.karmacall.decompose.login.LoginComponent
import com.fyncom.karmacall.decompose.nationalid.NationalIdComponent
import com.fyncom.karmacall.decompose.onboarding.OnboardingComponent
import com.fyncom.karmacall.decompose.phoneverification.PhoneVerificationComponent
import com.fyncom.karmacall.decompose.splash.SplashComponent
import com.fyncom.karmacall.resources.StringsProvider
import com.fyncom.karmacall.viewmodels.RootViewModel
import org.koin.core.KoinApplication

interface QPayRoot {
	val stringProvider: StringsProvider
	val backstack: Value<ChildStack<*, MainDestinationChild>>
	val koinApplication: KoinApplication
	val rootViewModel: RootViewModel
	
	sealed class MainDestinationChild {
		class Splash(
			val component: SplashComponent,
		) : MainDestinationChild()
		
		class Onboarding(
			val component: OnboardingComponent,
		) : MainDestinationChild()
		
		class SignInOptions(
			val component: SignInOptionsComponent
		) : MainDestinationChild()
		
		class Login(
			val component: LoginComponent
		) : MainDestinationChild()
		
		class ContactInfo(
			val component: ContactInfoComponent,
		) : MainDestinationChild()
		
		class PhoneVerification(
			val component: PhoneVerificationComponent,
		) : MainDestinationChild()
		
		class NationalIdCapture(
			val component: NationalIdComponent,
		) : MainDestinationChild()
		
		class IdentifyVerification(
			val component: IdentityVerificationComponent,
		) : MainDestinationChild()
		
		class CreateAuthenticationPin(
			val component: CreateAuthComponent,
		) : MainDestinationChild()
		
		class BottomNavHolder(
			val component: BottomNavComponent,
		) : MainDestinationChild()
	}
}
