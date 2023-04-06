plugins {
    kotlin("multiplatform") version "1.8.0"
}

group = "me.alyxia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    // Currently, allow to work only on Linux.
    val nativeTarget = when (val hostOs = System.getProperty("os.name")) {
        "Linux" -> linuxX64("native")
        else -> throw GradleException("$hostOs is not supported.")
    }

    nativeTarget.apply {
        binaries {
            all {
                binaryOptions["memoryModel"] = "experimental"
            }
            executable {
                entryPoint = "main"
            }
        }
    }
    sourceSets {
        val nativeMain by getting {
            dependencies {
                // Core library
                implementation("org.gtk-kt:gtk:1.0.0-alpha1")

                // DSL library to make things easier to write
                implementation("org.gtk-kt:dsl:0.1.0-alpha0")

                // Extra libraries for convenience and interoperability with Kotlin
                implementation("org.gtk-kt:coroutines:0.1.0-alpha0")
                implementation("org.gtk-kt:ktx:0.1.0-alpha0")

                // Base libraries if you want to work with them standalone
                implementation("org.gtk-kt:cairo:0.1.0-alpha0")
                implementation("org.gtk-kt:gdk-pixbuf:0.1.0-alpha0")
                implementation("org.gtk-kt:gio:2.68.0-alpha0") // messed up versioning
                implementation("org.gtk-kt:glib:0.1.0-alpha1")
                implementation("org.gtk-kt:gobject:0.1.0-alpha1")
                implementation("org.gtk-kt:pango:0.1.0-alpha0")
            }
        }
    }
}