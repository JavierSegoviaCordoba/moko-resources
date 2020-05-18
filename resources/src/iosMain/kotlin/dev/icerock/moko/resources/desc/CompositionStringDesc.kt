/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.moko.resources.desc

actual data class CompositionStringDesc actual constructor(
    val args: List<StringDesc>,
    val separator: String?
) : StringDesc {
    override fun localized(): String {
        return args.joinToString(separator = separator ?: "") { it.localized() }
    }
}
