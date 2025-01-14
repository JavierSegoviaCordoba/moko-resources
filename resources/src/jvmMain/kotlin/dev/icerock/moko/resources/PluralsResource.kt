/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.resources

import com.ibm.icu.text.MessageFormat
import com.ibm.icu.text.PluralRules
import com.ibm.icu.util.ULocale
import java.util.*

actual class PluralsResource(
    val resourcesClassLoader: ClassLoader,
    val bundleName: String,
    val key: String
) {

    private fun getPluralMessage(locale: Locale, quantity: Int): String {
        val resourceBundle = resourcesClassLoader.getResourceBundle(bundleName, locale)

        val pluralRules = PluralRules.forLocale(ULocale.forLocale(locale))
        val keyWithQuantity = "$key.${pluralRules.select(quantity.toDouble())}"

        return resourceBundle.getString(keyWithQuantity)
    }

    fun localized(locale: Locale = Locale.getDefault(), quantity: Int): String =
        MessageFormat.format(getPluralMessage(locale, quantity))

    fun localized(locale: Locale = Locale.getDefault(), quantity: Int, vararg args: Any?): String =
        MessageFormat.format(getPluralMessage(locale, quantity), *args)
}
