plugins {
    kotlin("multiplatform")
}
kotlin {
    linuxX64("native") {
        binaries {
            executable()
        }
    }
    sourceSets {
        val nativeMain by getting {
            dependencies {
                implementation("org.gtkkn:gtk4:0.0.1-SNAPSHOT")
                implementation("org.gtkkn:adwaita:0.0.1-SNAPSHOT")
                implementation("org.gtkkn:libhelium:0.0.1-SNAPSHOT")
            }
        }
    }
}