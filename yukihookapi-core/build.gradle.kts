import com.android.build.gradle.internal.tasks.factory.dependsOn
import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import org.gradle.internal.impldep.org.junit.experimental.categories.Categories.CategoryFilter.include

plugins {
    autowire(libs.plugins.android.library)
    autowire(libs.plugins.kotlin.android)
    autowire(libs.plugins.maven.publish)
}

group = property.project.groupName
version = property.project.yukihookapi.core.version

android {
    namespace = property.project.groupName
    compileSdk = property.project.android.compileSdk

    defaultConfig {
        minSdk = property.project.android.minSdk
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
        freeCompilerArgs = listOf(
            "-Xno-param-assertions",
            "-Xno-call-assertions",
            "-Xno-receiver-assertions"
        )
    }
    lint { checkReleaseBuilds = false }
}

dependencies {
    implementation(androidx.core.core.ktx)
    implementation(androidx.appcompat.appcompat)
    implementation(org.jetbrains.kotlin.kotlin.reflect)
    implementation(io.github.dreammooncai.yukireflection.api.kotlin)
    compileOnly(com.highcapable.yukihookapi.api)
}

mavenPublishing {
    configure(AndroidSingleVariantLibrary(publishJavadocJar = false))
    coordinates(
        groupId = group.toString(),
        artifactId = property.project.yukihookapi.core.moduleName,
        version = version.toString()
    )
}

tasks.register<Copy>("makeJar") {
    delete("build/${property.project.name}_V${property.project.yukihookapi.core.version}.jar") //删除之前的旧jar包
    from("build/intermediates/full_jar/release/createFullJarRelease/") //从这个目录下取出默认jar包
    into("build/") //将jar包输出到指定目录下
    include("full.jar")
    rename("full.jar", "outputs/jar/${property.project.name}_V${property.project.yukihookapi.core.version}.jar") //自定义jar包的名字
}
tasks.named("makeJar").dependsOn("createFullJarRelease")

tasks.register<Copy>("makeSourcesJar") {
    delete("build/${property.project.name}_V${property.project.yukihookapi.core.version}.jar") //删除之前的旧jar包
    from("build/intermediates/source_jar/release/") //从这个目录下取出默认jar包
    into("build/") //将jar包输出到指定目录下
    include("release-sources.jar")
    rename("release-sources.jar", "outputs/jar/${property.project.name}_V${property.project.yukihookapi.core.version}-sources.jar") //自定义jar包的名字
}
tasks.named("makeSourcesJar").dependsOn("sourceReleaseJar")