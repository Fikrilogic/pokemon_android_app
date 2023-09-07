import extension.FRAMEWORK
import extension.MODEL

plugins {
    id("commons.android-core")
    id("commons.dagger-hilt")
}

android {
    namespace = "com.fikrisandi.remote"

}

dependencies {
    FRAMEWORK
    MODEL

    implementation(NetworkLibs.retrofit2)
    implementation(NetworkLibs.gson)

}