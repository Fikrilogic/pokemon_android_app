import extension.COMPONENT
import extension.DOMAIN
import extension.FRAMEWORK
import extension.JETFRAMEWORK
import extension.MODEL
import extension.PROVIDER
import extension.THEME
import extension.addDestinationDependency
import extension.implementation

plugins {
    id("commons.android-feature")
    id("commons.android-compose")
    id("commons.dagger-hilt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.fikrisandi.detail"

}

ksp{
    arg("compose-destinations.mode", "navgraphs")
    arg("compose-destinations.moduleName", "detail")
}

dependencies {
    THEME
    COMPONENT
    PROVIDER

    FRAMEWORK
    JETFRAMEWORK

    DOMAIN
    MODEL

    addDestinationDependency()
    implementation(DaggerHiltLibs.compose)
    implementation(SupportLibs.coil)

}