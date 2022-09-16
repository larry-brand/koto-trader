dependencies {
    implementation(project(":core:commons-general"))

    implementation("org.apache.commons:commons-lang3:3.12.0")

    implementation("org.slf4j:slf4j-api:${properties["slf4j_version"]}")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${properties["log4j_version"]}")
    implementation("io.github.microutils:kotlin-logging-jvm:${properties["kolog_version"]}")
}