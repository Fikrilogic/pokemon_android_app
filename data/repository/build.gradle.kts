import extension.FRAMEWORK
import extension.LOCAL
import extension.MODEL
import extension.REMOTE

plugins {
    id("commons.android-core")
    id("commons.dagger-hilt")
}

android{
    namespace = "com.fikrisandi.repository"
}


dependencies {
    FRAMEWORK
    LOCAL
    MODEL
    REMOTE
}