/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.generator.jvm

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
import dev.icerock.gradle.generator.ColorsGenerator
import org.gradle.api.file.FileTree

class JvmColorsGenerator(colorsFileTree: FileTree) : ColorsGenerator(colorsFileTree) {

    override fun getImports() = listOf(
        ClassName("dev.icerock.moko.graphics", "Color")
    )

    override fun getClassModifiers(): Array<KModifier> = arrayOf(KModifier.ACTUAL)

    override fun getPropertyModifiers(): Array<KModifier> = arrayOf(KModifier.ACTUAL)
}