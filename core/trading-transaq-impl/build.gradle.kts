dependencies {
    implementation(project(":core:commons-general"))
    implementation(project(":core:trading-api"))

    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("com.google.code.gson:gson:${properties["gson_version"]}")
    implementation("net.java.dev.jna:jna:5.3.1")
    implementation("javax.xml.bind:jaxb-api:${properties["jaxb_version"]}")
    implementation("org.glassfish.jaxb:jaxb-runtime:${properties["jaxb_version"]}")

    implementation("org.slf4j:slf4j-api:${properties["slf4j_version"]}")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${properties["log4j_version"]}")
    implementation("org.apache.logging.log4j:log4j-core:${properties["log4j_version"]}")
    implementation("io.github.microutils:kotlin-logging-jvm:${properties["kolog_version"]}")
}