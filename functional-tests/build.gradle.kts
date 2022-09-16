dependencies {
    implementation(project(":core:history-service"))

    implementation("org.slf4j:slf4j-api:${properties["slf4j_version"]}")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:${properties["log4j_version"]}")

    testImplementation("org.junit.jupiter:junit-jupiter:${properties["junit_version"]}")
    testImplementation("io.kotest:kotest-assertions-core-jvm:${properties["kotest_version"]}")
}