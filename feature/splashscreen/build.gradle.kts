import extension.COMPONENT
import extension.FRAMEWORK
import extension.JETFRAMEWORK
import extension.PROVIDER
import extension.THEME

plugins {
    id("commons.android-feature")
    id("commons.android-compose")
}

android {
    namespace = "com.fikrisandi.splashscreen"

}

dependencies {
    THEME
    COMPONENT
    PROVIDER

    FRAMEWORK
    JETFRAMEWORK


    implementation(SupportLibs.splashScreen)
}