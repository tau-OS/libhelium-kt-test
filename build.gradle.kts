plugins {
    kotlin("multiplatform") version "1.8.10" apply false
}
tasks.withType<Wrapper> {
    description = "Regenerates the Gradle Wrapper files"
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "7.6"
}