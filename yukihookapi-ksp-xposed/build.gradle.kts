plugins {
    autowire(libs.plugins.kotlin.jvm)
    autowire(libs.plugins.kotlin.ksp)
    autowire(libs.plugins.maven.publish)
    autowire(libs.plugins.kotlin.compose)
}

group = property.project.groupName
version = property.project.yukihookapi.ksp.xposed.version

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    jvmToolchain(21)
    sourceSets.getByName("main") {
        kotlin.srcDir("src/api/kotlin")
    }
    compilerOptions {
        freeCompilerArgs = listOf(
            "-Xno-param-assertions",
            "-Xno-call-assertions",
            "-Xno-receiver-assertions"
        )
    }
}

dependencies {
    implementation(org.jetbrains.compose.runtime.runtime)
    implementation(com.google.auto.service.auto.service.annotations)
    compileOnly(com.google.devtools.ksp.symbol.processing.api)
    ksp(dev.zacsweers.autoservice.auto.service.ksp)
}

mavenPublishing {
    coordinates(
        groupId = group.toString(),
        artifactId = property.project.yukihookapi.ksp.xposed.moduleName,
        version = version.toString()
    )
}