package com.fyncom.karmacall.resources

import androidx.compose.runtime.staticCompositionLocalOf
import dev.icerock.moko.resources.StringResource

expect class StringsProvider {
	fun get(stringId: StringResource, args: List<Any> = listOf()): String
}

val LocalStringProvider = staticCompositionLocalOf<StringsProvider?>{null}
