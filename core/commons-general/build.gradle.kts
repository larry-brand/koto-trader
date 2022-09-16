dependencies {
    implementation("commons-beanutils:commons-beanutils:1.9.3")
    implementation("com.google.code.gson:gson:${properties["gson_version"]}")
    implementation("org.jsoup:jsoup:1.7.2")
    implementation("javax.xml.bind:jaxb-api:${properties["jaxb_version"]}")
    implementation("org.glassfish.jaxb:jaxb-runtime:${properties["jaxb_version"]}")

    implementation("io.github.microutils:kotlin-logging-jvm:${properties["kolog_version"]}")
}