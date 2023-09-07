import extension.addUiDependency

plugins {
    id("commons.android-core")
    id("commons.android-compose")
}

android{
    namespace = "com.fikrisandi.theme"
}


dependencies {
    addUiDependency()

    implementation(SupportLibs.splashScreen)
}