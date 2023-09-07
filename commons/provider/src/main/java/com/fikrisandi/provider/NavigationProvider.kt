package com.fikrisandi.provider

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface NavigationProvider {

    fun navigateUp()
    fun navigateToHome()
    fun navigateToDetail(url: String)

}

class EmptyNavigationProvider: NavigationProvider{
    override fun navigateUp() {
    }

    override fun navigateToHome() {

    }

    override fun navigateToDetail(url: String) {
    }


}

@Parcelize
enum class TodoFlagType(val stringFlag: String) : Parcelable {
    ON_PROGRESS("isLastAdded"),
    COMPLETED("isCompleted")
}