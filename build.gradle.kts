// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.com.android.library) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.devtools.ksp) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.org.jetbrains.dokka) apply false
}
tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        named("main") {
            // used as project name in the header
            moduleName.set("Portal Material Design")
        }
    }
}
true // Needed to make the Suppress annotation work for the plugins block