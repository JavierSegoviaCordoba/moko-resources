/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("multiplatform-library-convention")
}

kotlin {
    sourceSets {
        val commonMain by getting {}

        val appleMain by creating {
            dependsOn(commonMain)
        }
        val iosMain by getting {
            dependsOn(appleMain)
        }
        val macosX64Main by getting {
            dependsOn(appleMain)
        }
    }
}
