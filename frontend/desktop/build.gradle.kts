plugins {
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

dependencies {
    implementation(project(":core:commons-general"))
    implementation(project(":core:history-service"))
    implementation(project(":core:trading-api"))

    implementation("org.jfree:jfreechart:1.5.3")
    implementation("org.swinglabs.swingx:swingx-autocomplete:1.6.5-1")


    implementation("org.slf4j:slf4j-api:${properties["slf4j_version"]}")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${properties["log4j_version"]}")
    implementation("io.github.microutils:kotlin-logging-jvm:${properties["kolog_version"]}")
}
