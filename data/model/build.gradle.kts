import extension.FRAMEWORK
import extension.ksp

plugins {
    id("commons.android-core")
    id("commons.dagger-hilt")
    id("com.google.devtools.ksp")
}

android{
    namespace = "com.fikrisandi.model"
}


dependencies {
    FRAMEWORK

    implementation(StorageLibs.roomKtx)
    ksp(StorageLibs.roomCompiler)
    implementation(NetworkLibs.retrofit2)
    implementation(NetworkLibs.gson)
}