package com.fikrisandi.splashscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.fikrisandi.framework.extension.launchActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashscreen = installSplashScreen()
        splashscreen.setKeepOnScreenCondition{true}

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED){
                delay(2000)
                launchMainActivity()
            }
        }
    }


    private fun launchMainActivity() {
        launchActivity(
            packageName = packageName,
            className = "com.fikrisandi.pokemonapps"
        ).also {
            finish()
        }
    }
}
