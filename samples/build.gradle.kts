dependencies {
    implementation(project(":core:commons-general"))
    implementation(project(":core:history-service"))
    implementation(project(":core:trading-api"))
    implementation(project(":core:simulator"))
    implementation(project(":core:trading-transaq-impl"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${properties["coroutines_version"]}")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:${properties["coroutines_version"]}")
    implementation("com.google.code.gson:gson:${properties["gson_version"]}")
}