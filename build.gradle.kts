import org.gradle.kotlin.dsl.*

plugins {
    java
    `jvm-test-suite`
    alias(libs.plugins.lombok)
}

java {
    toolchain {
        version = JavaLanguageVersion.of(21)
    }
}

dependencies {
    compileOnly(libs.jetbrains.annotations)
    compileOnly(libs.spring.core)
    compileOnly(libs.jakarta.validation)
    compileOnly(libs.findbugs)
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter("5.9.3")
        }
    }
}