package com.fikrisandi.pokemonapps.provider

import androidx.navigation.NavController
import com.fikrisandi.detail.destinations.DetailScreenDestination
import com.fikrisandi.home.destinations.HomeScreenDestination
import com.fikrisandi.provider.NavigationProvider
import com.ramcosta.composedestinations.navigation.navigate

class AppNavigationProvider(private val navController: NavController) : NavigationProvider {
    override fun navigateUp() {
        navController.popBackStack()
    }

    override fun navigateToHome() {
        navController.navigate(HomeScreenDestination)
    }

    override fun navigateToDetail(url: String) {
        navController.navigate(DetailScreenDestination.invoke(url = url))
    }
}