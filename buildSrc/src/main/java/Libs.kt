object SupportLibs {
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycleRuntime}"
    const val CoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
    const val CoroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
    const val Material = "com.google.android.material:material:1.11.0-alpha01"
    const val ActivityKtx = "androidx.activity:activity-ktx:1.4.0"
    const val viewmodelRuntime = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycleRuntime}"
    const val datetimeKtx = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"
    const val splashScreen = "androidx.core:core-splashscreen:1.0.1"
    const val coil = "io.coil-kt:coil-compose:2.4.0"
}

object ComposeLibs {
    const val ui = "androidx.compose.ui:ui:${Version.compose}"
    const val bom = "androidx.compose:compose-bom:2023.03.00"
    const val constraint = "androidx.constraintlayout:constraintlayout-compose:${Version.constrainCompose}"
    const val activity = "androidx.activity:activity-compose:${Version.activityCompose}"
    const val uiGraphics = "androidx.compose.ui:ui-graphics:${Version.compose}"
    const val uiPreview = "androidx.compose.ui:ui-tooling-preview:${Version.compose}"
    const val material3 = "androidx.compose.material3:material3:${Version.material3}"
    const val material = "androidx.compose.material:material:${Version.material}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Version.compose}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Version.compose}"
}

object ComposeDestinationLibs{
    const val composeDestination = "io.github.raamcosta.compose-destinations:core:${Version.destination}"
    const val composeDestinationKsp = "io.github.raamcosta.compose-destinations:ksp:${Version.destination}"
}

object StorageLibs{
    const val roomRuntime = "androidx.room:room-runtime:${Version.room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.room_version}"
    const val roomKtx = "androidx.room:room-ktx:${Version.room_version}"
    const val store = "androidx.datastore:datastore:${Version.datastore_version}"
    const val storePref = "androidx.datastore:datastore-preferences:${Version.datastore_version}"
}

object DaggerHiltLibs {
    const val android = "com.google.dagger:hilt-android:${Version.daggerHilt}"
    const val compiler = "com.google.dagger:hilt-compiler:${Version.daggerHilt}"
    const val compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
}

object NetworkLibs {
    const val retrofit2 = "com.squareup.retrofit2:retrofit:2.9.0"
    const val gson = "com.squareup.retrofit2:converter-gson:2.9.0"
}

object Paging3Libs{
    const val runtime = "androidx.paging:paging-runtime:${Version.paging3}"
    const val jetpack = "androidx.paging:paging-compose:3.2.0"
}

object TestLibs {
    const val jUnit = "junit:junit:${Version.jUnit}"
    const val jUnitAndroid = "androidx.test.ext:junit:${Version.jUnitAndroid}"
    const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Version.compose}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
}